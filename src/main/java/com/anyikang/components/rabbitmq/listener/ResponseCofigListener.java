/**
 * 
 */
package com.anyikang.components.rabbitmq.listener;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.anyikang.components.rabbitmq.service.ResponseCofigUR1Service;
import com.anyikang.components.rabbitmq.service.ResponseCofigUR2Service;

/**
 * @author LvXiaoxiong
 * @date 2017年7月05日
 */
@Component
@RabbitListener(queues={"rescue_web_response_config_queue"})
public class ResponseCofigListener {
	
	private Logger logger = LoggerFactory.getLogger(ResponseCofigListener.class);
	
	@Autowired
	private ResponseCofigUR1Service responseCofigUR1Service;
	
	//
	@Autowired
	private ResponseCofigUR2Service responseCofigUR2Service;
	
	
	
	
	
	@RabbitHandler
	public void process(@Payload Map<String, Object> params){
		logger.debug("=========监听到response_config_queue队列=========");
		System.err.println("{");
		for(Map.Entry<String, Object> param:params.entrySet()){
			System.err.println(" "+param.getKey()+":"+param.getValue()+",");
		}
		System.err.println("}");
	
    	if(params.containsKey("functionCode")){
    		String functionCode =(String)params.get("functionCode");
    		switch(functionCode.toUpperCase()){
    		case "UPLOAD"://数据上传间隔设置响应
				responseCofigUR1Service.upload(params);
				break;
			case "CENTER"://中心号码设置响应
				responseCofigUR1Service.center(params);
				break;
			case "CALL":// 拨打电话指令设置响应
				responseCofigUR1Service.callResponse(params);
				break;
			case "MONITOR":// 监听指令设置响应
				responseCofigUR1Service.monitorResponse(params);
				break;
			case "SOS1":// sos1指令设置响应
				responseCofigUR1Service.sosOneResponse(params);
				break;
			case "SOS2":// sos2指令设置响应
				responseCofigUR1Service.sosOneResponse(params);
				break;
			case "SOS3":// sos3指令设置响应
				responseCofigUR1Service.sosOneResponse(params);
				break;
			case "SOS":// sos指令设置响应
				responseCofigUR1Service.sosResponse(params);
				break;
			case "FACTORY"://恢复出厂设置响应
				responseCofigUR1Service.factoryResponse(params);
   			    break;
			case "CR":// 定位指令设置响应
				responseCofigUR1Service.crResponse(params);
   			    break;
			case "POWEROFF":// 关机指令指令设置响应
				responseCofigUR1Service.poweroffResponse(params);
   			    break;
			case "FIND":// 找定位器指令设置响应
				responseCofigUR1Service.findResponse(params);
   			    break;		
			case "10":// 时间配置响应信息
 		    	responseCofigUR2Service.timeConfig(params);
			    break;
			case "11":// 定位配置响应信息
				responseCofigUR2Service.locationConfig(params);
				break;
			case "12":// 电子围栏配置响应信息
				responseCofigUR2Service.electricConfig(params);
				break;
			case "13":// 亲情号配置响应信息
				responseCofigUR2Service.familyConfig(params);
				break;
			case "14":// 白名单配置响应信息
				responseCofigUR2Service.whiteListConfig(params);
				break;
			case "15":// 运动配置响应信息
				responseCofigUR2Service.sportsConfig(params);
				break;	
			case "16":// 白名单配置响应信息
				responseCofigUR2Service.heartRateConfig(params);
				break;
			case "17":// IP端口配置响应信息
				responseCofigUR2Service.ipConfig(params);
				break;
			case "18":// 心跳配置响应信息
				responseCofigUR2Service.heartConfig(params);
				break;
			case "19":// 闹钟配置响应信息
				responseCofigUR2Service.clockConfig(params);
				break;
			case "1A":// wifi配置响应信息
				responseCofigUR2Service.wifiConfig(params);
				break;
			case "1B":// 提醒配置响应信息
				responseCofigUR2Service.remindConfig(params);
				break;
			case "1C":// 信息推送响应信息
				responseCofigUR2Service.messageConfig(params);
				break;
			case "1D":// 远程控制响应信息
				responseCofigUR2Service.telecontrolConfig(params);
				break;
			case "1E":// sos响应信息
				responseCofigUR2Service.sosConfig(params);
				break;
			case "1F":// 跌倒响应信息
				responseCofigUR2Service.fallConfig(params);
				break;
				default:
					logger.info("============未找到对应的上报功能("+functionCode+")=============");
    		}
    	}
  
	}
    	
	//或者直接调用推送服务

}
