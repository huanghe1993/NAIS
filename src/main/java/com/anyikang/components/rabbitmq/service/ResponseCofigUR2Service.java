/**
 * 
 */
package com.anyikang.components.rabbitmq.service;

import java.util.Map;

/**
 * @author wangwei
 * @date 2017年4月14日
 */
public interface ResponseCofigUR2Service {

	/**
	 * 推送消息
	 * @param msg
	 * @return
	 */

	
	/*
	 * 时间配置响应信息
	 */
	public Map<String, Object> timeConfig(Map<String, Object> params);
	
	
	
	/*
	 * 定位配置响应信息
	 */
	public Map<String, Object> locationConfig(Map<String, Object> params);

	
	
	/*
	 * 电子围栏配置响应信息
	 */
	public Map<String, Object> electricConfig(Map<String, Object> params);
    
	
	/*
	 * ip配置响应信息
	 */
	public Map<String, Object> ipConfig(Map<String, Object> params);
	
    
	/*
	 * 心跳配置响应信息
	 */
	public Map<String, Object> heartConfig(Map<String, Object> params);

	
	/*
	 * wifi配置响应信息
	 */
	public Map<String, Object> wifiConfig(Map<String, Object> params);
    
	
	/*
	 * 提醒配置响应信息
	 */
	public Map<String, Object> remindConfig(Map<String, Object> params);

	
	/*
	 * 信息推送配置响应信息
	 */
	public Map<String, Object> messageConfig(Map<String, Object> params);
    
	
	/*
	 * 远程控制配置响应信息
	 */
	public Map<String, Object> telecontrolConfig(Map<String, Object> params);

	/*
	 * 亲情号配置响应信息
	 */
	public Map<String, Object> familyConfig(Map<String, Object> params);

    /*
     * sos配置响应信息
     */
	public Map<String, Object> sosConfig(Map<String, Object> params);


	/*
	 * 白名单配置响应信息
	 */

	public Map<String, Object> whiteListConfig(Map<String, Object> params);



	/*
	 * 跌倒配置响应信息
	 */
	public Map<String, Object> fallConfig(Map<String, Object> params);


	/*
	 * 运动配置响应信息
	 */

	public Map<String, Object> sportsConfig(Map<String, Object> params);



	/*
	 * 心率配置响应信息
	 */
	public Map<String, Object> heartRateConfig(Map<String, Object> params);


	/*
	 * 闹钟配置响应信息
	 */

	public Map<String, Object> clockConfig(Map<String, Object> params);
}
