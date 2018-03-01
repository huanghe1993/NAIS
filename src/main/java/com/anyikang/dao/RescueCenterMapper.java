package com.anyikang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.anyikang.model.RescueCenter;
import com.anyikang.model.vo.LocatorDevice;
import com.anyikang.model.vo.Volunteer;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;



/**
 * 紧急救助系统处理的持久层
 * @author LvXiaoxiong  2017/06/29
 *
 */
public interface RescueCenterMapper {

	
	
	/**
	 * 查询所有志愿者列表
	 * @param userId 
	 * @param userName
	 * @return
	 */
	public List<Map<String,Object>> findAllVolunteers(long userId);
	

	/**
	 * 添加定位器设备信息
	 * @param map
	 * @return
	 */
	public int addLocator(LocatorDevice locator);
	
	/**
	 * 查找全部定位器设备/根据name查询定位器
	 * @param deviceImeiCode
	 * @return
	 */
	public List<LocatorDevice> findLocator(String deviceImeiCode);
	
	/**
	 * 根据设备号修改
	 * @param map
	 * @return
	 */
	public int modifyLocator(Map<String,Object> map);
	
	/**
	 * 根据设备号删除
	 * @param deviceImeiCode
	 * @return
	 */
	public int deleteLocatorByImei(String deviceImeiCode);
	
	/**
	 * 查询设备
	 * @param deviceImeiCode
	 * @return
	 */
	public List<LocatorDevice> findLocatorDevice(String deviceImeiCode);
	
	/**
	 * 根据设备号查询设备
	 * @param deviceId
	 * @return
	 */
	public LocatorDevice findLocatorImei(String deviceImeiCode);
	
	/**
	 * 获取当天所有的志愿者以及地理位置
	 * @param addr
	 * @return
	 */
	public List<Map<String,Object>> getAllVolunteerByAddr(long userId);
	
	/**
	 * 获取当天所有的任务
	 * @param addr
	 * @return
	 */
	public List<Map<String,Object>> getAllTaskByAddr(String[] areaids);

	/**
	 * 添加救援中心
	 * @param rescueCenter
	 * @return 
	 */
	public int addRescue(RescueCenter rescueCenter);

	/**
	 * 查询手机号是否已经存在
	 * @param chargeMobile
	 * @return
	 */
	public int findByChargeMobile(String chargeMobile);

	/**
	 * 查询城市名称以及cityCode
	 * @return
	 */
	public List<Map<String, Object>> findProvinceCode();
	/**
	 * 查询城市名称以及cityCode
	 * @return
	 */
	public List<Map<String, Object>> findCityCode(String provinceId);

	/**
	 * 根据Id删除救援中心
	 * @param rescueCenterId
	 * @return
	 */
	public int deleteRescueById(String rescueCenterId);

	/**
	 * 根据Id修改救援中心信息
	 * @param map
	 * @return
	 */
	public int modifyRescue(Map<String, Object> map);

	/**
	 * 查询所有救援中心或者按名称查询
	 * @param rescueCenterName
	 * @return
	 */
	public List<RescueCenter> findRescues(String rescueCenterName);


	/**
	 * 查询所有监护人定位信息
	 * @return
	 */
	public List<Map<String, Object>> getAllguardian();


	/**
	 * 查询所有任务
	 * @return
	 */
	public List<Map<String, Object>> getAllTask();


	/**
	 * 查询区、县以及区域码
	 * @param cityId
	 * @return
	 */
	public List<Map<String, Object>> findDistrictCode(String cityId);


	/**
	 * 查询上级单位
	 * @param code
	 * @return
	 */
	public List<Map<String, Object>> findParent(String code);


	/**
	 * 查询总中心
	 * @param mainCode 
	 * @return
	 */
	public List<Map<String, Object>> findMainCenter(String mainCode);


	/**
	 * 查询是否已经有这个城市的救援中心
	 * @param code
	 * @return
	 */
	public int findCityCodeInTeam(String code);


	/**
	 * 根据cityCode反查userId
	 * @param cityCode
	 * @return
	 */
	public List<Map<String, Object>> findUserIdByCityCode(String cityCode);


	/**
	 * 查询所有救援中心
	 * @return
	 */
	public List<RescueCenter> findAllRescue();
	
}
