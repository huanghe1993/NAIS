/**
 * 
 */
package com.anyikang.components.rabbitmq.service;

import java.util.Map;

/**
 * @author wangwei
 * @date 2017年4月11日
 */
public interface ResponseMessageQueryService {

	/**
	 * 推送消息
	 * @param msg
	 * @return
	 */


	/*
	 *  版本信息查询服务响应信息
	 */
	public Map<String, Object> versionMessage(Map<String, Object> params);

	/*
	 * 定位查询服务响应信息
	 */
	public Map<String, Object> locationMessage(Map<String, Object> params);

	/*
	 * 丢失报文查询服务响应信息
	 */
	public Map<String, Object> lostWordMessage(Map<String, Object> params);

	/**
	 * 运动查询服务响应信息
	 * @param params
	 * @return
	 */
	public Map<String, Object> sportsMessage(Map<String, Object> params);

	/**
	 * 心率查询服务响应信息
	 * @param params
	 * @return
	 */
	public Map<String, Object> heartRateMessage(Map<String, Object> params);

	/**
	 * 血氧查询服务响应信息
	 * @param params
	 * @return
	 */
	public Map<String, Object> oxygenMessage(Map<String, Object> params);

	/**
	 * 血压查询服务响应信息
	 * @param params
	 * @return
	 */
	public Map<String, Object> bloodPressureMessage(Map<String, Object> params);

	/**
	 * 睡眠查询服务响应信息
	 * @param params
	 * @return
	 */
	public Map<String, Object> sleepMessage(Map<String, Object> params);
}
