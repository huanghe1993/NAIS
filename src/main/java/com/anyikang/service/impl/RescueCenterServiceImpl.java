package com.anyikang.service.impl;


import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.RescueCenterMapper;
import com.anyikang.model.RescueCenter;
import com.anyikang.model.vo.LocatorDevice;
import com.anyikang.service.RescueCenterService;

/**
 * 紧急救助系统后台业务处理
 * @author LvXiaoxiong 2017/07/11
 *
 */

@Service	
public class RescueCenterServiceImpl implements RescueCenterService {

	@Autowired
	private RescueCenterMapper rescueCenterMapper;
	

	@Override
	public boolean addLocatorDevice(Map<String, Object> map) {
		if(map==null||map.size()==0){
			return false;
		}
		if(!map.containsKey("deviceImeiCode")){
			return false;
		}
		LocatorDevice ld =rescueCenterMapper.findLocatorImei(map.get("deviceImeiCode").toString());//判断此志愿者是否已经录入
		if(ld!=null){
			return false;
		}
		LocatorDevice newLd = new LocatorDevice();
		newLd.setDeviceId((int)map.get("deviceId"));
		newLd.setDeviceImeiCode(map.get("deviceImeiCode").toString());
		newLd.setDeviceUser(map.get("deviceUser").toString());
		newLd.setDeviceMobile(map.get("deviceMobile").toString());
		return false;
	}

	@Override
	public List<LocatorDevice> findLocatorDevice(String deviceImeiCode) {
		List<LocatorDevice> list =rescueCenterMapper.findLocatorDevice(deviceImeiCode);
		
		return list;
	}

	@Override
	public boolean modifyLocatorDevice(Map<String, Object> map) {
		if(map==null||map.size()==0){
			return false;
		}
		if(!map.containsKey("deviceImeiCode")){
			return false;
		}
		int n =rescueCenterMapper.modifyLocator(map);
		return n==1;
	}

	@Override
	public boolean deleteLocatorDeviceById(String 
			deviceImeiCode) {
		if(deviceImeiCode==null||deviceImeiCode.trim().isEmpty()){
			return false;
		}
		int n =rescueCenterMapper.deleteLocatorByImei(deviceImeiCode);
		return n==1;
	}





	/* (non-Javadoc)
	 * @see com.anyikang.service.VolunteerService#getAllVolunteerByAddr(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getAllVolunteerByAddr(long userId) {
		// TODO Auto-generated method stub
		return rescueCenterMapper.getAllVolunteerByAddr(userId);
	}




	/* (non-Javadoc)
	 * @see com.anyikang.service.VolunteerService#getAllTaskByAddr(java.lang.String)
	 */
	@Override
	public List<Map<String, Object>> getAllTaskByAddr(String[] areaids) {
		// TODO Auto-generated method stub
		return rescueCenterMapper.getAllTaskByAddr(areaids);
	}




	/*
	 * (non-Javadoc)
	 * @see com.anyikang.service.RescueCenterService#addRescue(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public int addRescue(String rescueCenterName, String rescueChargeName, String code, String chargeMobile,
			String address, String mark,String rescueParentCode) {
		if(rescueCenterName==null||rescueChargeName==null||code==null||chargeMobile==null||address==null){
			return 0;
		}
		int m =rescueCenterMapper.findByChargeMobile(chargeMobile);
		if(m==1){
			return 2;
		}
		int h =rescueCenterMapper.findCityCodeInTeam(code);
		if(h==1){
			return 3;
		}
		
		RescueCenter  rescueCenter =new RescueCenter();
		rescueCenter.setAddress(address);
		rescueCenter.setChargeMobile(chargeMobile);
		rescueCenter.setCode(code);
		rescueCenter.setRescueParentCode(rescueParentCode);
		rescueCenter.setCreateTime(new Timestamp(System.currentTimeMillis()));
		if(mark!=null){
			rescueCenter.setMark(mark);
		}
		rescueCenter.setRescueCenterName(rescueCenterName);
		rescueCenter.setRescueChargeName(rescueChargeName);
		rescueCenter.setRescueCenterId(UUID.randomUUID().toString());
		int n =rescueCenterMapper.addRescue(rescueCenter);
		
		return n;
	}



	@Override
	public List<Map<String, Object>> findProvinceCode() {
		List<Map<String,Object>> list = rescueCenterMapper.findProvinceCode();
		return list;
	}




	@Override
	public List<Map<String, Object>> findCityCode(String provinceId) {
		List<Map<String,Object>> list = rescueCenterMapper.findCityCode(provinceId);
		return list;
	}




	@Override
	public Boolean deleteRescueById(String rescueCenterId) {
		if(rescueCenterId==null||rescueCenterId.trim().isEmpty()){
			return false;
		}
		int n =rescueCenterMapper.deleteRescueById(rescueCenterId);
		return n==1;
	}




	@Override
	public Boolean modifyRescue(Map<String, Object> map) {
		
		if(map==null||map.size()==0){
			return false;
		}
		
		if(!map.containsKey("rescueCenterId")){
			return false;
		}
		int n =rescueCenterMapper.modifyRescue(map);
		return n==1;
	}




	@Override
	public List<RescueCenter> findRescues(String rescueCenterName) {
		List<RescueCenter> list =rescueCenterMapper.findRescues(rescueCenterName);
		return list;
	}

	@Override
	public boolean deleteVolunteerById(String volunteerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Map<String, Object>> getAllguardian() {
		List<Map<String, Object>> list =rescueCenterMapper.getAllguardian();
		return list;
	}

	@Override
	public List<Map<String, Object>> getAllTask() {
		return rescueCenterMapper.getAllTask();
	}

	@Override
	public List<Map<String, Object>> findDistrictCode(String cityId) {
		return rescueCenterMapper.findDistrictCode(cityId);
	}

	@Override
	public List<Map<String, Object>> findParent(String code) {
		List<Map<String, Object>> list = rescueCenterMapper.findParent(code);
		if(list==null||list.size()==0){
		   return null;
		}
		return list;
	}

	@Override
	public Map<String, Object> findUserIdByCityCode(String cityCode) {
		List<Map<String,Object>> list = rescueCenterMapper.findUserIdByCityCode(cityCode); 
		if(list==null||list.size()==0){
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<RescueCenter> findAllRescue() {
		List<RescueCenter> list =rescueCenterMapper.findAllRescue();
		return list;
	}

	

}
