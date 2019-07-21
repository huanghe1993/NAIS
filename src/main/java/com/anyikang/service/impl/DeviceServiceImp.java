package com.anyikang.service.impl;


import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.DeviceMapper;
import com.anyikang.model.OldManMsg;
import com.anyikang.model.vo.LocatorDeviceMessage;
import com.anyikang.model.vo.LocatorDeviceStatus;
import com.anyikang.model.vo.RescueDevice;
import com.anyikang.service.DeviceService;


/**
 * 
 * @author LvXiaoxiong
 * @date   2018/03/02
 *
 */
@Service
public class DeviceServiceImp implements DeviceService {

	
	
    @Autowired
    private DeviceMapper deviceMapper;

    @Override
    public RescueDevice findByDeviceNumber(String deviceIMEI) {
        return deviceMapper.findByDeviceNumber(deviceIMEI);
    }



	/* (non-Javadoc)
	 * @see com.anyikang.service.DeviceService#addDevice(com.anyikang.model.Device)
	 */
	@Override
	public boolean addDevice(RescueDevice device) {
	  int n =deviceMapper.addDevice(device);
	  return n==1;
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
		 if(list==null){
			 return null;
		 }
		 if(list.size()==0){
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
			long time =new Date().getTime()-12*60*60*1000L;
			map.put("startTime", new Timestamp(time));
		}
		if(map.containsKey("endTime")){
			String endTime =map.get("endTime").toString();
			map.put("endTime", Timestamp.valueOf(endTime));
		}
		List<Map<String, Object>> list =deviceMapper.queryOrbit(map);
		if(list==null||list.size()==0){
			return null;
		}
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}



	@Override
	public  List<LocatorDeviceStatus> queryDeviceStatusMessage(String deviceImei) {
		
		 List<LocatorDeviceStatus> list =deviceMapper.queryDeviceStatus(deviceImei);
		 if(list==null||list.isEmpty()){
			 return null;
		 }
		 return list;
	}



	@Override
	public boolean addEmergency(String phone1, String phone2, String phone3, String phone4, String phone5, String oldManId) {
		List<Map<String,Object>> phoneList = new LinkedList<>();
		if(phone1!=null&&phone1.trim().length()!=0){
			Map<String,Object> map =new LinkedHashMap<>();
			String phoneId =UUID.randomUUID().toString();
			map.put("oldManId", oldManId);
			map.put("emergencyId", phoneId);
			map.put("mobile", phone1);
			phoneList.add(map);
		}
		if(phone2!=null&&phone2.trim().length()!=0){
			Map<String,Object> map =new LinkedHashMap<>();
			String phoneId =UUID.randomUUID().toString();
			map.put("oldManId", oldManId);
			map.put("emergencyId", phoneId);
			map.put("mobile", phone2);
			phoneList.add(map);
		}
		if(phone3!=null&&phone3.trim().length()!=0){
			Map<String,Object> map =new LinkedHashMap<>();
			String phoneId =UUID.randomUUID().toString();
			map.put("oldManId", oldManId);
			map.put("emergencyId", phoneId);
			map.put("mobile", phone3);
			phoneList.add(map);
		}
		if(phone4!=null&&phone4.trim().length()!=0){
			Map<String,Object> map =new LinkedHashMap<>();
			String phoneId =UUID.randomUUID().toString();
			map.put("oldManId", oldManId);
			map.put("emergencyId", phoneId);
			map.put("mobile", phone4);
			phoneList.add(map);
		}
		if(phone5!=null&&phone5.trim().length()!=0){
			Map<String,Object> map =new LinkedHashMap<>();
			String phoneId =UUID.randomUUID().toString();
			map.put("oldManId", oldManId);
			map.put("emergencyId", phoneId);
			map.put("mobile", phone5);
			phoneList.add(map);
		}
		if(phoneList.size()==0){
			return false;
		}
		for(Map<String,Object> phoneMap:phoneList){
			//循环添加亲情号
			int n =deviceMapper.addEmergency(phoneMap);
			if(n!=1){
				return false;
			}
		}
		return true;
	}



	@Override
	public Map<String, Object> findOldManMsg(int deviceId) {
		Map<String, Object> map =deviceMapper.findOldManMsg(deviceId);
		if(map!=null&&map.size()>0){
			return map;
		}
		return null;
	}



	@Override
	public boolean addOldMan(OldManMsg om) {
		int n = deviceMapper.addOldMan(om);
		return n==1;
	}



	@Override
	public List<Map<String, Object>> findOldMans(String deviceIMEI) {
		List<Map<String,Object>> list =deviceMapper.findOldMans(deviceIMEI);
		if(list==null){
			return null;
		}
		if(list.size()==0){
			return null;
		}
		for(Map<String,Object> map:list){
			if(map.containsKey("familyPhones")){
				List<Map<String,Object>> phoneList = new LinkedList<>();
				String familyPhones =map.get("familyPhones").toString();
				if(familyPhones!=null&&!familyPhones.trim().isEmpty()){
					String [] familyPhone =familyPhones.split(",");
					for(String str:familyPhone){
						Map<String,Object> phone = new LinkedHashMap<> ();
						String [] phones =str.split(":");
						String phoneId =phones[0].toString();
						String phoneNumber =phones[1].toString();
						phone.put("emergency_id", phoneId);
						phone.put("mobile", phoneNumber);
						phoneList.add(phone);
					}
					map.put("familyPhones", phoneList);
				}else{
					map.put("familyPhones", null);
				}
				
			}
		}
		return list;
	}


	@Override
	public boolean updateOldMan(OldManMsg om) {
		int n = deviceMapper.updateOldMan(om);
		return n==1;
	}



	@Override
	public boolean deleteOldMan(String oldManId) {
		int n =deviceMapper.deleteOldMan(oldManId);
		return n==1;
	}



	@Override
	public boolean deleteEmergency(String oldManId) {
		int n = deviceMapper.deleteEmergency(oldManId);
		return n>=0;
		
	}



	@Override
	public boolean updateParentPhones(String emergencyId, String phone) {
		Map<String,Object> params =new HashMap<String,Object> ();
		if(emergencyId==null){
			return false;
		}
		if(phone==null){
			return false;
		}
		if(phone.trim().isEmpty()){
			return false;
		}
		if(emergencyId.trim().isEmpty()){
			return false;
		}
		params.put("emergencyId", emergencyId);
		params.put("mobile", phone);
		int n =deviceMapper.updateParentPhones(params);
		return n==1;
	}



	@Override
	public boolean deleteParentPhones(String emergencyId) {
		if(emergencyId==null){
			return false;
		}
		if(emergencyId.trim().isEmpty()){
			return false;
		}
		int n =deviceMapper.deleteParentPhones(emergencyId);
		return n==1;
	}



	@Override
	public List<Map<String, Object>> queryAlarmRecord(String deviceIMEI) {
		List<Map<String,Object>> list =deviceMapper.queryAlarmRecord(deviceIMEI);
		if(list==null){
			return null;
		}
		if(list.size()>0){
			return list;
		}
 		return null;
	}



	@Override
	public int findParentPhones(String oldManId) {
		 List<Map<String,Object>> list =deviceMapper.findParentPhones(oldManId);
		 if(list==null){
			 return 0;
		 }
		 return list.size();
			 
	}



	@Override
	public Map<String,Object> addParentPhone(String oldManId, String phone) {
		Map<String,Object> params =new HashMap<>();
		params.put("oldManId", oldManId);
		params.put("mobile", phone);
		params.put("emergencyId", UUID.randomUUID().toString());
		int n =deviceMapper.addEmergency(params);
		if(n==1){
			return params;
		}
		return null;
	}


}
