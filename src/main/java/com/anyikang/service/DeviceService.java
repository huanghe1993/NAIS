package com.anyikang.service;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;

import com.anyikang.model.Device;
import com.anyikang.model.OldManMsg;
import com.anyikang.model.RescueCount;
import com.anyikang.model.vo.AlarmVO;
import com.anyikang.model.vo.LocatorDeviceMessage;
import com.anyikang.model.vo.LocatorDeviceStatus;
import com.anyikang.model.vo.RescueDevice;

/**
 * 
 * @author LvXiaoxiong
 * @date 2018/03/05
 *
 */
public interface DeviceService {

	/**
	 * 查询设备
	 * @param deviceIMEI
	 * @return
	 */
	public RescueDevice findByDeviceNumber(String deviceIMEI);

	/**
	 * 获取通信服务器中的设备信息
	 * 
	 * @return
	 * @throws RemoteException
	 */

	public List<Map<String,Object>> findDeviceByTeam(long teamId);


	/**
	 * 添加设备
	 * 
	 * @param device
	 */
	public boolean addDevice(RescueDevice device);
	
	/**
	 * 获取用户的所有设备
	 * @param deviceId
	 * @return
	 */
	public List<Map<String,Object>> getDevicesByUserId(long userId);
	
	/**
	 * 获取用户的所有设备的报警信息
	 * @param deviceId
	 * @return
	 */
	public List<AlarmVO> getAlarmInfosByUserId(long userId);
	
	/**
	 * 获取某个区域内的所有终端设备信息以及是否报警是否有人接单
	 * @param deviceId
	 * @return
	 */
	public List<Map<String,Object>> getAllDevicesByAddr(String[] areaids);


	/**
	 * 以总队身份查询
	 * @return
	 */
	public List<Map<String, Object>> getAllDevices();

	/**
	 * 查询所有设备
	 * @return
	 */
	public List<Map<String, Object>> findDevice();

	/**
	 * 查询所有设备种类
	 * @return
	 */
	public List<Map<String, Object>> findDeviceKinds();


	/**
	 * 查询在线设备信息
	 * @param imeiCode
	 * @return
	 */
	public List<Map<String,Object>> onLineDevice();
	
	
	/**
	 * 查询非在线设备信息
	 * @param imeiCode
	 * @return
	 */
	public List<Map<String,Object>> offLineDevice();
	
	/**
	 * 查询所有设备信息列表
	 * @param page
	 * @return
	 */
	List<LocatorDeviceMessage> queryDevice(String deviceImei);
	
	
	/**
	 * 查询设备轨迹/电量信息(某个设备全部位置轨迹点/电量变化点)
	 * @param imeiCode
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<Map<String,Object>> queryOrbits(Map<String,Object> map);
	
	/**
	 * 查询设备状态信息
	 * @param imeiCode
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	List<LocatorDeviceStatus> queryDeviceStatusMessage(String deviceImei);


	/**
	 * 查询各个省的救援统计情况
	 * @param userId
	 * @return
	 */
	public List<RescueCount> rescueCount(Integer userId);

	/**
	 * 查询各个市的救援统计情况
	 * @param rescueCenterId
	 * @return
	 */
	public List<RescueCount> rescueCenterId(String rescueCenterId);

	/**
	 * 添加亲情号
	 * @param phone1
	 * @param phone2
	 * @param phone3
	 * @param phone4
	 * @param phone5
	 * @param deviceId
	 * @return
	 */
	public boolean addEmergency(String phone1, String phone2, String phone3, String phone4, String phone5, String oldManId);

	/**
	 * 查询佩戴者信息
	 * @param oldManId
	 * @return
	 */
	public Map<String, Object> findOldManMsg(int deviceId);

	
	/**
	 * 添加佩戴者信息
	 * @param om
	 * @return
	 */
	public boolean addOldMan(OldManMsg om);

	/**
	 * 查询佩戴者信息以及亲情号
	 * @param deviceIMEI
	 * @return
	 */
	public List<Map<String,Object>> findOldMans(String deviceIMEI);

	/**
	 * 修改佩戴者信息
	 * @param om
	 * @return
	 */
	public boolean updateOldMan(OldManMsg om);

	/**
	 * 
	 * @param oldManId
	 * @return
	 */
	public boolean deleteOldMan(String oldManId);

	/**
	 * 删除亲情号
	 * @param oldManId 
	 * @return
	 */
	public boolean deleteEmergency(String oldManId);

	/**
	 * 根据
	 * @param oldManId
	 * @param phone
	 * @return
	 */
	public boolean updateParentPhones(String emergencyId, String phone);

	/**
	 * 删除单个亲情号
	 * @param emergencyId
	 * @param phone
	 * @return
	 */
	public boolean deleteParentPhones(String emergencyId);

	/**
	 * 查询设备报警记录
	 * @param deviceIMEI
	 * @return
	 */
	public List<Map<String,Object>> queryAlarmRecord(String deviceIMEI);

	/**
	 * 查询亲情号个数
	 * @param oldManId
	 * @return
	 */
	public int findParentPhones(String oldManId);

	/**
	 * 添加亲情号
	 * @param oldManId
	 * @param phone
	 * @return
	 */
	public boolean addParentPhone(String oldManId, String phone);



}
