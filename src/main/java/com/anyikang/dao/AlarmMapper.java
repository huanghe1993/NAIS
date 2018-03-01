package com.anyikang.dao;

import com.anyikang.model.Alarm;
import com.anyikang.model.AlarmCustom;
import com.anyikang.model.vo.RescueTask;

import java.util.List;
import java.util.Map;

/**
 * 报警信息持久层
 * @author LvXiaoxiong
 * @date  2017/08/01
 *
 */
public interface AlarmMapper {

    //根据设备的id查询出设备的电量和时间戳
    public List<Alarm> findAlarmInfoByDeviceId(Integer deviceId);

    //根据设备的id,报警的类型，起始的时间，终止的时间（包装类AlarmCustom)查询报警信息
    public List<Alarm> findAlarmByDeviceAndDateSection(AlarmCustom alarmCustom);
    
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
}
