package com.anyikang.dao;

import java.util.List;
import java.util.Map;

import com.anyikang.model.Alarm;
import com.anyikang.model.AlarmCustom;
import com.anyikang.model.vo.RescueTask;

/**
 * 报警信息持久层
 * @author LvXiaoxiong
 * @date  2017/08/01
 *
 */
public interface AlarmMapper {
   
    /**
     * 存储报警信息到数据库
     * @param al
     * @return
     */
    public int addAlarmMessage(Alarm al);

    /**
     * 根据报警情况增加救援任务
     * @param task
     */
	public int addAlarmTask(RescueTask task);

	/**
	 * 是否已经创建救援任务
	 * @param imeiCode
	 * @return
	 */
	public Map<String, Object> findAlarmTast(String imeiCode);

	/**
	 * 查询此设备是否有未处理的报警，如果有，就不再存入新的
	 * @param imeiCode
	 * @return 
	 */
	public Map<String, Object> findAlarmByImei(String deviceIMEI);

	/**
	 * 根据地区查找救助队id
	 * @param district
	 * @return
	 */
	public Map<String, Object> findRescueTeam(String address);
	
	/**
	 * 修改任务状态
	 * @param imeiCode
	 * @return
	 */
	public int updateRscueType(String alarmId);
	
	/**
	 * 是否已经创建救援任务
	 * @param imeiCode
	 * @return
	 */
	public Map<String, Object> findAlarmTast(Map<String, Object> map);

	/**
	 * 
	 * @param deviceId
	 * @return
	 */
	public List<Alarm> findAlarmInfoByDeviceId(Integer deviceId);

	/**
	 * 
	 * @param alarmCustom
	 * @return
	 */
	public List<Alarm> findAlarmByDeviceAndDateSection(AlarmCustom alarmCustom);
}
