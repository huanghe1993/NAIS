/**
 * 
 */
package com.anyikang.components.rabbitmq.service.impl;


import java.sql.Timestamp;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.rabbitmq.service.ReportService;
import com.anyikang.dao.RescueDeviceMapper;
import com.anyikang.model.vo.RescueDevice;
import com.anyikang.utils.DateUtil;



/**
 * @author LvXiaoxiong
 * @date 2017年7月05日
 */
@Service
public class ReportServiceImpl implements ReportService {
	
	private Logger logger = Logger.getLogger(ReportServiceImpl.class);

    
    
	@Autowired
	private RescueDeviceMapper rescueDeviceMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ReportService#positioning(java.lang.String)
	 */
	@Override
	public boolean location(Map<String,Object> params) {
		if(params==null||params.size()==0){
			return false;
		}  
		
		updateDevice(params);//更新设备信息
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
		if(params.containsKey("dateTime")){
			String reportTime = params.get("dateTime").toString();	
		    device.setOnlineTime(DateUtil.addEnight(reportTime));
		}
		if(params.containsKey("imeiCode")){
			device.setDeviceIMEI(params.get("imeiCode").toString());
		}
		if(params.containsKey("reportTime")){
			String reportTime = params.get("reportTime").toString();
			device.setOnlineTime(DateUtil.stringToTimestamp(reportTime));
		}
		
		if(params.containsKey("electricity")){
			device.setDevicePower(Integer.parseInt(params.get("electricity").toString()));
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
	public boolean heart(Map<String, Object> params) {
		
		if(params==null){
			return false;
		}
		RescueDevice device = new RescueDevice();
		if(params.containsKey("imeiCode")){
			device.setDeviceIMEI(params.get("imeiCode").toString());
		}
		if(params.containsKey("electricity")){
			device.setDevicePower(Integer.parseInt(params.get("electricity").toString()));
		}
		device.setOnlineTime(new Timestamp(System.currentTimeMillis()));
		rescueDeviceMapper.modifyDevice(device);
		System.err.println("==============保存心跳信息================");
		return true;
		
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ReportService#exercise(java.lang.String)
	 */
	@Override
	public boolean exercise(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.err.println("==============保存运动信息================");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ReportService#heartRate(java.lang.String)
	 */
	@Override
	public boolean heartRate(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.err.println("==============保存心率信息================");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ReportService#bloodOxygen(java.lang.String)
	 */
	@Override
	public boolean bloodOxygen(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.err.println("==============保存血氧信息================");
		System.err.println("=====imeiCode:"+params.get("imeiCode"));
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ReportService#bloodPressure(java.lang.String)
	 */
	@Override
	public boolean bloodPressure(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.err.println("==============保存血压信息================");
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.anyikang.service.ReportService#sleep(java.lang.String)
	 */
	@Override
	public boolean sleep(Map<String,Object> params) {
		// TODO Auto-generated method stub
		
		System.err.println("==============保存睡眠信息================");
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
