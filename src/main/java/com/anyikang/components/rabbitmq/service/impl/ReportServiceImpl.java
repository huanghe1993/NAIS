/**
 * 
 */
package com.anyikang.components.rabbitmq.service.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.rabbitmq.service.ReportService;
import com.anyikang.dao.AlarmMapper;
import com.anyikang.dao.DeviceMapper;
import com.anyikang.dao.RescueDeviceMapper;
import com.anyikang.dao.RescueReportMapper;
import com.anyikang.model.Alarm;
import com.anyikang.model.vo.RescueDevice;
import com.anyikang.model.vo.VoLocation;
import com.anyikang.utils.DateUtil;
import com.anyikang.utils.IEEE754Utils;
import com.anyikang.utils.LngLat;
import com.anyikang.utils.WifLbsUtil;



/**
 * @author LvXiaoxiong
 * @date 2017年7月05日
 */
@Service
public class ReportServiceImpl implements ReportService {
	
	private Logger logger = Logger.getLogger(ReportServiceImpl.class);

    @Autowired
    private AlarmMapper alarmMapper;
    
	@Autowired
	private RescueDeviceMapper rescueDeviceMapper;
	
	@Autowired
	private RescueReportMapper reportMapper;
	
	@Autowired
	private DeviceMapper deviceMapper;

	

	@Override
	public boolean location(Map<String,Object> params) {
		if(params==null||params.size()==0){
			return false;
		}  
		
		updateDevice(params);//更新设备信息
		String imeiCode =params.get("imeiCode").toString();
	    String gpsValid = params.get("gpsValid").toString();
		
	    //判断该设备是否存在
  		Map<String,Object> deviceMap =rescueDeviceMapper.findDeviceByImei(imeiCode);
  		if(deviceMap==null){
  			return false;
  		}
  		VoLocation vo =new VoLocation();
		vo.setDeviceId((int)deviceMap.get("deviceId"));
		if(params.containsKey("reportTime")){
			vo.setLocationTime(DateUtil.stringToDate(params.get("reportTime").toString()));
		}
		
		if(params.containsKey("electricity")){
			vo.setLocationElectricity(Integer.valueOf(params.get("electricity").toString()));
		}
		vo.setServerTime(new Date());
		vo.setLocationId(UUID.randomUUID().toString());
		
		switch(gpsValid){
		
		case "A":
			 vo.setLocationSpeed(Float.valueOf(params.get("speed").toString()));
		     vo.setLocationAltitude(Float.valueOf(params.get("altitude").toString()));
			 vo.setLocationDirection(Float.valueOf(params.get("direction").toString()));
			 vo.setLocationType(1);
			 vo.setLocationLatitude(IEEE754Utils.stringTofloat(Float.valueOf(params.get("latitude").toString())));
			 vo.setLocationLongitude(IEEE754Utils.stringTofloat(Float.valueOf(params.get("longitude").toString())));
			 break;
		case "V":
		    int wifi=0;
		    int lbs=0;
		    String [] macs=new String[]{};
            String [] nearbts=new String[]{};
            String bts=null;
            String smac=null;
		    if(params.containsKey("wifiNumber")){
			   String wifiNumber =params.get("wifiNumber").toString();
			   wifi =Integer.valueOf(wifiNumber);
		    }
		    if(params.containsKey("lbsStationNumber")){
			   String lbsStationNumber =params.get("lbsStationNumber").toString();
		       lbs =Integer.valueOf(lbsStationNumber);
		    }
		    if(wifi>0&&lbs>0){
				@SuppressWarnings("unchecked")
				List<String> wifiList =(List<String>) params.get("wifi");
				@SuppressWarnings("unchecked")
				List<String> lbsList =(List<String>) params.get("lbs");
				smac=wifiList.get(0);
				bts =lbsList.get(0);
				wifiList.remove(0);
				lbsList.remove(0);
				macs =(String[]) wifiList.toArray(new String[wifiList.size()]);
				nearbts =(String[]) lbsList.toArray(new String[lbsList.size()]);				
				vo.setLocationType(4);
			}else if(wifi>0&&lbs==0){
				System.err.println("=======wifi转换坐标========");
				@SuppressWarnings("unchecked")
				List<String> wifiList =(List<String>) params.get("wifi");
				smac=wifiList.get(0);
				wifiList.remove(0);
				macs =(String[]) wifiList.toArray(new String[wifiList.size()]);
				vo.setLocationType(2);
			}else if(wifi==0&&lbs>0){
				System.err.println("=======lbs转换坐标========");
				@SuppressWarnings("unchecked")
				List<String> lbsList =(List<String>) params.get("lbs");
				bts =lbsList.get(0);
				lbsList.remove(0);
				nearbts =(String[]) lbsList.toArray(new String[lbsList.size()]);
				vo.setLocationType(3);
			}
			LngLat gps = WifLbsUtil.gaodeMixture_to_bd09(0, imeiCode, smac, 0, bts, nearbts, macs);
			vo.setLocationLatitude((float)gps.getLantitude());
			vo.setLocationLongitude((float)gps.getLongitude());
			break;
		default:
			logger.info("============存储失败，无数据=============");
			return false;
    }

		if(vo.getLocationLatitude()==0||vo.getLocationLongitude()==0){
			return false;
		}		
	     
		//2.保存定位数据
		reportMapper.addLocationReport(vo);

		//3.处理上报报警的方法
		if(params.containsKey("deviceStatus")){
			String deviceStatus =Integer.toBinaryString(Integer.parseInt(params.get("deviceStatus").toString(), 16));
			while(deviceStatus.length()<8){
				deviceStatus ="0"+deviceStatus;	
			}
			System.err.println(deviceStatus);
			char [] strs =deviceStatus.toCharArray();
			Alarm al = new Alarm();//报警信息
			al.setAlarmTime(vo.getLocationTime());
			al.setAlarmPower(vo.getLocationElectricity());
			al.setLocationId(vo.getLocationId());
			if(strs[5]=='1'){
				al.setAlarmType(2);
				al.setRescueType(0);
				al.setIsCall(0);
				al.setAlarmId(UUID.randomUUID().toString());
			    int n =alarmMapper.addAlarmMessage(al);
				if(n==1){
				   System.err.println("==============保存报警信息(电量低2)================");
		        }
			}
			if(strs[6]=='0'&&strs[7]=='1'){
				al.setAlarmType(1);
				al.setRescueType(1);
				al.setAlarmId(UUID.randomUUID().toString());
				//查询当前是否为报警状态未处理,如果是未处理,则新的报警信息只进入数据库,不进行处理
				Map<String,Object> map =alarmMapper.findAlarmByImei(imeiCode);
				if(map!=null&&map.size()>0){
					al.setIsCall(0);
				}else{
					al.setIsCall(1);
				}
		        int n =alarmMapper.addAlarmMessage(al);
				if(n==1){
				   System.err.println("==============保存报警信息(发生意外1)================");
		        }
			}
			//查询蓝牙状态
			int  bluetoothStatus = deviceMapper.findBluetoothStatus(imeiCode);
			if(strs[1]=='1'){
				if(bluetoothStatus==1){
					System.err.println("=======蓝牙状态无变化=======");
				}else{
					al.setAlarmType(3);
					al.setRescueType(0);
					al.setAlarmId(UUID.randomUUID().toString());
					al.setIsCall(0);
			        int n =alarmMapper.addAlarmMessage(al);
					if(n==1){
						//修改蓝牙状态为1(1为断开,0为正常)
			    		Map<String,Object> param=new HashMap<>();
			    		param.put("bluetoothStatus", 1);
			    		param.put("deviceIMEI", imeiCode);
			    		deviceMapper.updateBluetoothStatus(param);
					   System.err.println("==============保存蓝牙断开报警信息(蓝牙断开1)================");
			        }
				}
				
			}
			if(strs[1]=='0'){
				if(bluetoothStatus==0){
					System.err.println("=======蓝牙状态无变化=======");
				}else{
					//修改蓝牙状态为0(1为断开,0为正常)
		    		Map<String,Object> param=new HashMap<>();
		    		param.put("bluetoothStatus", 0);
		    		param.put("deviceIMEI", imeiCode);
		    		deviceMapper.updateBluetoothStatus(param);
				   System.err.println("==============蓝牙正常连接(蓝牙连接2)================");
				}
			}
		}
	    return true;
  }

	
	/**
     * 更新设备信息业务
     * @param params
     */
	private void updateDevice(Map<String, Object> params) {
		RescueDevice device = new RescueDevice();
		if(params.containsKey("status")){
			String deviceStatus = Integer.toBinaryString(Integer.parseInt(params.get("status").toString(), 16));
			while(deviceStatus.length()<32){
				deviceStatus ="0"+deviceStatus;
			}
			device.setDeviceStatus(deviceStatus);
		}
		if(params.containsKey("imeiCode")){
			device.setDeviceIMEI(params.get("imeiCode").toString());
		}
		if(params.containsKey("reportTime")){
			String reportTime = params.get("reportTime").toString();
			device.setOnlineTime(DateUtil.stringToDate(reportTime));
		}
		if(params.containsKey("power")){
			device.setDevicePower(Integer.valueOf(params.get("power").toString(), 16));
		}
		
		try {
			rescueDeviceMapper.modifyDevice(device);
		} catch (Exception e) {
			System.out.println("-------错误-------");
		}
		System.err.println("==============更新设备信息================");
	}	
	
	@Override
	public boolean heartOfBLE(Map<String, Object> params) {
		if(params==null){
			return false;
		}
		RescueDevice device = new RescueDevice();
		if(params.containsKey("imeiCode")){
			device.setDeviceIMEI(params.get("imeiCode").toString());
		}
		device.setOnlineTime(new Timestamp(System.currentTimeMillis()));
		rescueDeviceMapper.modifyDeviceOfBle(device);
		System.err.println("==============保存心跳信息================");
		return true;
		
	}




	
   /*public static void main(String [] args){
	  String str ="00161018";
	  int i =Integer.valueOf(str);
	  Integer s =Integer.valueOf(str, 16);
	  String sss= Integer.toBinaryString(s);
	  while(sss.length()<32){
		sss="0"+sss;
	  }
	  System.err.println(sss);	 
   }*/
	 

}
