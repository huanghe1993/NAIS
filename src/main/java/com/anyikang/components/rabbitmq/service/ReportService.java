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
	 * 定位上报
	 * 
	 * @param messageBody
	 * @return
	 */
	public boolean location(Map<String,Object> params);

	/**
	 * 心跳上报
	 * @param params
	 */
	public boolean heartOfBLE(Map<String, Object> params);
	

}
