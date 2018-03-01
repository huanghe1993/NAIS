/**
 * 
 */
package com.anyikang.components.rabbitmq.listener;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.anyikang.components.rabbitmq.service.ResponseMessageQueryService;

/**
 * @author wangwei
 * @date 2017年4月11日
 */
@Component
@RabbitListener(queues = "rescue_web_response_message_query_queue")
public class ResponseMessageQueryListener {
	
	private Logger logger = LoggerFactory.getLogger(ResponseMessageQueryListener.class);
	
	@Autowired
	private ResponseMessageQueryService responseMessageQueryService;

	@RabbitHandler
	public void process(@Payload Map<String, Object> params) {
		logger.debug("=========监听到rescue_web_response_message_query_queue队列=========");
		System.err.println("{");
		for(Map.Entry<String, Object> param:params.entrySet()){
			System.err.println(" "+param.getKey()+":"+param.getValue()+",");
		}
		System.err.println("}");
		
		Map<String, Object> isSuccess=new HashMap<>();
    	if(params.containsKey("functionCode")){
    		String functionCode =(String)params.get("functionCode");
    		switch(functionCode.toUpperCase()){
    		    case "30":// 版本信息查询服务响应信息
    		    	isSuccess=responseMessageQueryService.versionMessage(params);
				    break;
				case "31":// 定位查询服务响应信息
					isSuccess=responseMessageQueryService.locationMessage(params);
					break;
				case "32":// 运动查询服务响应信息
					isSuccess=responseMessageQueryService.sportsMessage(params);
					break;
				case "33":// 心率查询服务响应信息
					isSuccess=responseMessageQueryService.heartRateMessage(params);
					break;
				case "34":// 血氧查询服务响应信息
					isSuccess=responseMessageQueryService.oxygenMessage(params);
					break;
				case "35":// 血压查询服务响应信息
					isSuccess=responseMessageQueryService.bloodPressureMessage(params);
					break;
				case "36":// 睡眠查询服务响应信息
					isSuccess=responseMessageQueryService.sleepMessage(params);
					break;
				case "37":// 丢失报文查询服务响应信息
					isSuccess=responseMessageQueryService.lostWordMessage(params);
					break;
				default:
					logger.info("============未找到对应的上报功能("+functionCode+")=============");
    		}
    	}
		
		//或者直接调用推送服务
	}
}
