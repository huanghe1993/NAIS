package com.anyikang.dao;

import java.util.List;
import java.util.Map;

import com.anyikang.model.Alarm;

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
	 * 查询此设备是否有未处理的报警，如果有，就不再存入新的
	 * @param imeiCode
	 * @return 
	 */
	public Map<String, Object> findAlarmByImei(String deviceIMEI);

	/**
	 * 修改任务状态
	 * @param imeiCode
	 * @return
	 */
	public int updateRscueType(Map<String,Object> params);

	/**
	 * 查询所有报警信息
	 * @return
	 */
	public List<Map<String, Object>> getAllSos();
}
