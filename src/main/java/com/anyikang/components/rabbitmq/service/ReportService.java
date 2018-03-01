/**
 * 
 */
package com.anyikang.components.rabbitmq.service;

import java.util.Map;

/**
 * @author wangwei
 * @date 2017年4月11日
 */
public interface ReportService {
	
	
	
	/**
	 * 心跳上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean heart(Map<String,Object> params);

	/**
	 * 定位上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean location(Map<String,Object> params);

	/**
	 * 运动上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean exercise(Map<String,Object> params);

	/**
	 * 心率上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean heartRate(Map<String,Object> params);

	/**
	 * 血氧上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean bloodOxygen(Map<String,Object> params);

	/**
	 * 血压上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean bloodPressure(Map<String,Object> params);

	/**
	 * 睡眠上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean sleep(Map<String,Object> params);

	/**
	 * 心跳上报
	 * @param params
	 */
	public boolean heartOfBLE(Map<String, Object> params);
	

}
