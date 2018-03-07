package com.anyikang.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.anyikang.model.Device;
import com.anyikang.model.Location;
import com.anyikang.model.OldManMsg;
import com.anyikang.model.RescueCount;
import com.anyikang.model.vo.AlarmVO;
import com.anyikang.model.vo.LocatorDeviceMessage;
import com.anyikang.model.vo.LocatorDeviceStatus;
import com.anyikang.model.vo.RescueDevice;

/**
 * Created by huanghe on 2017/3/24.
 */
public interface DeviceMapper {

	
	/**
	 * 更新设备状态、设备报警控制、最新在线时间
	 * @param deviceStatus
	 * @param alarmControle
	 * @param newTime
	 * @return
	 */
	public int ModifyDevice(Device device);
	
	/**
	 * 根据Imei号获取到设备表的主键值deviceId的值,作为报警信息、定位信息外键值
	 * @param deviceIMEI
	 * @return
	 */
	public Map<String,Object> findDeviceByImei(String deviceIMEI );
	
    //根据设备的imei查询设备
    public RescueDevice findByDeviceNumber(String deviceIMEI);

    //更新设备的信息
    public void updateDeviceInfo(Device device);

    //查询设备是否在线
    public int findIsOnlineByDeviceNumber(String deviceIMEI);
    
    /**
     * 根据用户id获取设备列表
     * @param userId
     * @return
     */
    public List<Map<String,Object>> findDevicesByUserId(@Param("userId")long userId);
    
    /**
     * 根据用户id获取所有设备报警信息列表
     * @param userId
     * @return
     */
    public List<AlarmVO> findAlarmInfosByUserId(@Param("userId")long userId);

   
    /**
     * 根据群编号获取旗下的所有设备信息
     * @param teamId
     * @return
     */
    public List<Map<String,Object>> findDeviceByTeam(@Param("teamId")long teamId);
    
    /**
     * 根据设备imei号获取设备信息以及最新报警信息
     * @param deviceIMEI
     * @return
     */
    public Map<String, Object> findByDeviceIMEI(@Param("deviceIMEI")String deviceIMEI);
    
    /**
     * 根据设备id获取对应的最新经度纬度数据
     * @param deviceId
     * @return
     */
    public Location findLastLocation(@Param("deviceId") Integer deviceId);
    
    /**
     * 添加设备
     * @param device
     * @return 
     */
    public int addDevice(RescueDevice device);
    
    /**
     * 
     * @param addr
     * @return
     */
    public List<Map<String,Object>> getAllDevicesByAddr(@Param(value ="areaids") String[] areaids);


	/**
	 * 查询所有设备情况
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
	 * 在线
	 * @return
	 */
	public List<Map<String, Object>> onLine();

	/**
	 * 不在线
	 * @return
	 */
	public List<Map<String, Object>> offLine();

	/**
	 * 查询所有设备信息
	 * @param deviceImei
	 * @return
	 */
	public List<LocatorDeviceMessage> queryDevice(String deviceImei);

	/**
	 * 查询设备定位轨迹
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> queryOrbit(Map<String, Object> map);

	/**
	 * 查询设备状态
	 * @param deviceImei
	 * @return
	 */
	public List<LocatorDeviceStatus> queryDeviceStatus(String deviceIMEI);


	/**
	 * 查询各个省的救援统计
	 * @param userId
	 * @return
	 */
	public List<RescueCount> rescueCount(Integer userId);

	/**
	 * 查询各个市的救援统计
	 * @param rescueCenterId
	 * @return
	 */
	public List<RescueCount> rescueCountCity(String rescueCenterId);

	/**
	 * 添加亲情号
	 * @param phoneMap
	 * @return
	 */
	public int addEmergency(Map<String, Object> phoneMap);

	/**
	 * 添加亲情号关联表
	 * @param phoneMap
	 */
	public void addOldmanEmergency(Map<String, Object> phoneMap);

	/**
	 * 查询该设备蓝牙状态
	 * @param imeiCode
	 * @return
	 */
	public int findBluetoothStatus(String imeiCode);

	/**
	 * 修改蓝牙状态
	 * @param param
	 */
	public void updateBluetoothStatus(Map<String, Object> param);

	/**
	 * 查询是否已经录入佩戴者
	 * @param deviceId
	 * @return
	 */
	public Map<String, Object> findOldManMsg(int deviceId);

	/**
	 * 添加佩戴者信息
	 * @param om
	 * @return
	 */
	public int addOldMan(OldManMsg om);

	/**
	 * 查询佩戴者信息以及亲情号
	 * @param deviceIMEI
	 * @return
	 */
	public List<Map<String, Object>> findOldMans(String deviceIMEI);

	/**
	 * 修改佩戴者信息
	 * @param om
	 * @return
	 */
	public int updateOldMan(OldManMsg om);

	/**
	 * 删除亲情号
	 * @param emergency_id
	 * @return
	 */
	public int deleteEmergency(String oldManId);

	/**
	 * 删除佩戴者信息
	 * @param oldManId
	 * @return
	 */
	public int deleteOldMan(String oldManId);

	/**
	 * 修改亲情号
	 * @param params
	 * @return
	 */
	public int updateParentPhones(Map<String, Object> params);

	/**
	 * 删除单个亲情号
	 * @param emergencyId
	 * @return
	 */
	public int deleteParentPhones(String emergencyId);

	/**
	 * 查询报警记录
	 * @param deviceIMEI
	 * @return
	 */
	public List<Map<String, Object>> queryAlarmRecord(String deviceIMEI);

	/**
	 * 查询亲情号个数
	 * @param oldManId
	 * @return
	 */
	public List<Map<String, Object>> findParentPhones(String oldManId);


}
