package com.anyikang.dao;


import com.anyikang.model.Heartbeat;
import com.anyikang.model.vo.VoLocation;

/**
 * 1.本接口用于存储上报报文信息；
 * 2.本接口用于查询数据库上报报文信息。
 * @author LvXiaoxiong on 2017/07/13
 *
 */
public interface RescueReportMapper {

	/**
	 * 存储紧急救助系统定位数据
	 * @param location
	 * @return
	 */
	public int addLocationReport(VoLocation location);
	/**
	 * 心跳上报信息存储
	 * @param heartbeat
	 * @return
	 */
	public int addHeartbeat(Heartbeat heartbeat);
     
   
    

	
}
