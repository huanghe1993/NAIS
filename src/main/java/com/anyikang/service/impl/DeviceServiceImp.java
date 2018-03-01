package com.anyikang.service.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.anyikang.dao.DeviceMapper;
import com.anyikang.model.Device;
import com.anyikang.model.RescueCount;
import com.anyikang.model.vo.AlarmVO;
import com.anyikang.model.vo.LocatorDeviceMessage;
import com.anyikang.model.vo.LocatorDeviceStatus;
import com.anyikang.model.vo.RescueDevice;
import com.anyikang.service.DeviceService;


/**
 * Created by huanghe on 2017/3/24.
 */
@Service
public class DeviceServiceImp implements DeviceService {

	
	
	@Value("${spring.files.images-path}")
	private String imagePath;
	
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public Device findByDeviceNumber(String deviceIMEI) {
        return deviceMapper.findByDeviceNumber(deviceIMEI);
    }



    @Override
    public List<Map<String,Object>> findDeviceByTeam(long teamId) {
    	List<Map<String,Object>> list= deviceMapper.findDeviceByTeam(teamId);
    	if(list==null||list.size()==0){
    		return null;
    	}
    	return list;
    }


	/* (non-Javadoc)
	 * @see com.anyikang.service.DeviceService#addDevice(com.anyikang.model.Device)
	 */
	@Override
	public boolean addDevice(RescueDevice device) {
	  int n =deviceMapper.addDevice(device);
	  return n==1;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.DeviceService#getDevicesByUserId(long)
	 */
	@Override
	public List<Map<String,Object>> getDevicesByUserId(long userId) {
		// TODO Auto-generated method stub
		return deviceMapper.findDevicesByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.DeviceService#getAlarmInfosByUserId(long)
	 */
	@Override
	public List<AlarmVO> getAlarmInfosByUserId(long userId) {
	    return deviceMapper.findAlarmInfosByUserId(userId);
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.DeviceService#getAllDevicesByAddr(java.lang.String)
	 */
	@Override
	public List<Map<String,Object>> getAllDevicesByAddr(String[] areaids) {
		// TODO Auto-generated method stub
		return deviceMapper.getAllDevicesByAddr(areaids);
	}

	@Override
	public List<Map<String, Object>> getAllDevices() {
		
		return deviceMapper.getAllDevices();
	}

	@Override
	public List<Map<String, Object>> findDevice() {
		return deviceMapper.findDevice();
	}

	@Override
	public List<Map<String, Object>> findDeviceKinds() {
		return deviceMapper.findDeviceKinds();
	}

	@Override
	public List<Map<String, Object>> onLineDevice() {
		 List<Map<String,Object>> list = deviceMapper.onLine();
		 if(list==null||list.size()==0){
			 return null;
		 }
	     return list;
	}
	

	@Override
	public List<Map<String, Object>> offLineDevice() {
		 List<Map<String,Object>> list = deviceMapper.offLine();
		 if(list==null||list.size()==0){
			 return null;
		 }
	     return list;
	}

	

	@Override
	public List<LocatorDeviceMessage> queryDevice(String deviceImei) {
	
	     List<LocatorDeviceMessage> list = deviceMapper.queryDevice(deviceImei);
		 if(list==null||list.size()==0){
			 return null;
		 }
	     return list;
	}
	



	@Override
	public List<Map<String, Object>> queryOrbits(Map<String,Object> map) {
		if(!map.containsKey("deviceImei")){
			return null;
		}
		if(map.containsKey("startTime")){
			String startTime =map.get("startTime").toString();
			map.put("startTime", Timestamp.valueOf(startTime));
		}else{
			long time =new Date().getTime()-24*60*60*1000L;
			map.put("startTime", new Timestamp(time));
		}
		if(map.containsKey("endTime")){
			String endTime =map.get("endTime").toString();
			map.put("endTime", Timestamp.valueOf(endTime));
		}
		List<Map<String, Object>> list =deviceMapper.queryOrbit(map);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}



	@Override
	public  List<LocatorDeviceStatus> queryDeviceStatusMessage(String deviceImei) {
		
		 List<LocatorDeviceStatus> list =deviceMapper.queryDeviceStatus(deviceImei);
		 if(list.isEmpty()||list==null){
			 return null;
		 }
		 return list;
	}

	@Override
	public List<RescueCount> rescueCount(Integer userId) {
		List<RescueCount> list =deviceMapper.rescueCount(userId);
		if(list==null||list.size()==0){
        	return null;
        }
		return list;
	}

	@Override
	public List<RescueCount> rescueCenterId(String rescueCenterId) {
		List<RescueCount> list =deviceMapper.rescueCountCity(rescueCenterId);
		if(list==null||list.size()==0){
        	return null;
        }
		return list;
	}


}
