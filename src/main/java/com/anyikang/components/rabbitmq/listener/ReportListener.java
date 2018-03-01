package com.anyikang.components.rabbitmq.listener;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.anyikang.components.rabbitmq.service.ReportService;

@Component
@RabbitListener(queues ="ayk_rescue_web_report_queue")
public class ReportListener {
	
	private Logger logger = LoggerFactory.getLogger(ReportListener.class);
	
	@Autowired
	private ReportService reportService;
	
	


	@RabbitHandler
	public void process(@Payload Map<String,Object> params) {
		if(params!=null){
			System.err.println("{");
			for(Map.Entry<String, Object> param:params.entrySet()){
				System.err.println(" "+param.getKey()+":"+param.getValue()+",");
			}
			System.err.println("}");
			
			
			String functionCode=(String) params.get("functionCode");
			switch (functionCode.toUpperCase()) {
			    case "LK":// 心跳上报
			    	reportService.heart(params);
			    case "0": // 心跳上报
				    reportService.heartOfBLE(params);
				    break;
				case "UD": // 定位上报
				case "UD2":// 盲点信息上报
				case "AL": // 报警信息上报
				case "1":  // 定位上报
					reportService.location(params);
					break;
				case "2":// 运动上报
					reportService.exercise(params);
					break;
				case "3":// 心率上报
					reportService.heartRate(params);
					break;
				case "4":// 血氧上报
					reportService.bloodOxygen(params);
					break;
				case "5":// 血压上报
					reportService.bloodPressure(params);
					break;
				case "6":// 睡眠上报
					reportService.sleep(params);
					break;
				default:
					logger.info("============未找到对应的上报功能("+functionCode+")=============");
			}
		}
		
	}
	
	
}
