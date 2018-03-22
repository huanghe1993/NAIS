package com.anyikang.service;


import java.util.List;
import java.util.Map;

/**
 * Created by huanghe on 2017/3/30.
 */
public interface AlarmService {


    /**
     * 查询所有SOS报警信息以及报警状态
     * @return
     */
	public List<Map<String, Object>> getAllSos();

	/**
	 * 根据Id修改状态
	 * @param alarmId
	 * @return
	 */
	public boolean updateIsCall(String alarmId, int isCall);

}
