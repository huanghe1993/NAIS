package com.anyikang.service;

import java.util.List;
import java.util.Map;

import com.anyikang.model.RescueCenter;
import com.anyikang.model.vo.LocatorDevice;



/**
 * 
 * 紧急救援系统业务处理接口
 * @author LvXiaoxiong 2017/07/11
 *
 */
public interface RescueCenterService {


	/**
	 * 根据Id删除
	 * @param dataId
	 * @return
	 */
	public boolean deleteVolunteerById(String volunteerId);
	
	
	/**
	 * 添加定位器设备信息
	 * @param map
	 * @return
	 */
	public boolean addLocatorDevice(Map<String,Object> map);
	
	/**
	 * 查找全部定位器设备/根据name查询定位器
	 * @param deviceImeiCode
	 * @return
	 */
	public List<LocatorDevice> findLocatorDevice(String deviceImeiCode);
	
	/**
	 * 根据设备号修改
	 * @param map
	 * @return
	 */
	public boolean modifyLocatorDevice(Map<String,Object> map);
	
	/**
	 * 根据设备号删除
	 * @param deviceImeiCode
	 * @return
	 */
	public boolean deleteLocatorDeviceById(String deviceImeiCode);
	
	public List<Map<String,Object>> getAllVolunteerByAddr(long userId);
	
	public List<Map<String,Object>> getAllTaskByAddr(String[] areaids);

	/**
	 * 添加救援中心
	 * @param rescueCenterName
	 * @param rescueChargeName
	 * @param code
	 * @param chargeMobile
	 * @param adress
	 * @param mark
	 * @return
	 */
	public int addRescue(String rescueCenterName, String rescueChargeName, String code, String chargeMobile,
			String address, String mark,String rescueParentCode);

	/**
	 * 查询省份以及区域码
	 * @return
	 */
	public List<Map<String, Object>> findProvinceCode();

	/**
	 * 查询城市已经区域码
	 * @param provinceId
	 * @return
	 */
	public List<Map<String, Object>> findCityCode(String provinceId);

	/**
	 * 删除救援中心
	 * @param rescueCenterId
	 * @return
	 */
	public Boolean deleteRescueById(String rescueCenterId);

	/**
	 * 修改救援中心信息
	 * @param map
	 * @return
	 */
	public Boolean modifyRescue(Map<String, Object> map);

	/**
	 * 查询所有救援中心或者单个查询救援中心
	 * @param rescueCenterName
	 * @return
	 */
	public List<RescueCenter> findRescues(String rescueCenterName);


	/**
	 * 查询所有监护人信息
	 * @return
	 */
	public List<Map<String, Object>> getAllguardian();


	/**
	 * 查询所有任务单
	 * @return
	 */
	public List<Map<String, Object>> getAllTask();


	/**
	 * 查询区县以及区域码
	 * @param cityId
	 * @return
	 */
	public List<Map<String, Object>> findDistrictCode(String cityId);


	/**
	 * 查询上一级单位
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> findParent(String code);

    /**
     * 根据cityCode查询userId
     * @param cityCode 
     * @return
     */
	public Map<String, Object> findUserIdByCityCode(String cityCode);


	/**
	 * 查询所有救援中心
	 * @return
	 */
	public List<RescueCenter> findAllRescue();





}
