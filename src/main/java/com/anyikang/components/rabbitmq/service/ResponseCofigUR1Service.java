/**
 * 
 */
package com.anyikang.components.rabbitmq.service;

import java.util.Map;


/**
 * @author LvXiaoxiong
 * @date 2017年7月05日
 */
public interface ResponseCofigUR1Service {


		
	/**
	 * 数据上传间隔设置响应
	 * 
	 * @param messageBody
	 */
	public void upload(Map<String, Object> params);

	/**
	 * 中心号码设置响应
	 * 
	 * @param messageBody
	 * @return
	 */
	public void center(Map<String, Object> params);

	/**
	 * 拨打电话指令设置响应
	 * @param messageBody
	 */
	public void callResponse(Map<String, Object> params);

	/**
	 * 监听指令设置响应
	 * @param messageBody
	 */
	public void monitorResponse(Map<String, Object> params);

	/**
	 * sos1、2、3指令设置响应
	 * @param messageBody
	 */
	public void sosOneResponse(Map<String, Object> params);

	/**
	 *  sos指令设置响应
	 * @param messageBody
	 */
	public void sosResponse(Map<String, Object> params);

	/**
	 * 定位指令设置响应
	 * @param messageBody
	 */
	public void crResponse(Map<String, Object> params);

	/**
	 * 关机指令指令设置响应
	 * @param messageBody
	 */
	public void poweroffResponse(Map<String, Object> params);

	/**
	 * 找定位器指令设置响应
	 * @param messageBody
	 */
	public void findResponse(Map<String, Object> params);

	/**
	 * 恢复出厂设置响应
	 * @param messageBody
	 */
	public void factoryResponse(Map<String, Object> params);



	
}
