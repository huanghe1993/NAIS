
package com.anyikang.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.RescueReportMapper;
import com.anyikang.service.InstructionsService;
import com.anyikang.utils.RedisUtils;

/**
 * 
 * @author wangwei
 * @date 2017年4月17日
 */
@Service
public class InstructionsServiceImpl implements InstructionsService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	@Autowired
	private RescueReportMapper reportMapper;
	@Autowired  
    private RedisUtils redisUtils;
	
	@Override
	public boolean send(Map<String, Object> pas) {
		if(pas.isEmpty()){
			return false;
		}
		rabbitTemplate.convertAndSend("BLE_request_config_queue", pas);
		return true;
	}
	
	
	
	
	/**
	 * 查询响应信息
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> responseQuery(Map<String, Object> pas) {
		if(pas.isEmpty()){
			return null;
		}
		if(pas.containsKey("params")&&pas.containsKey("imeiCode")){
			String param =pas.get("params").toString();
			String redisKey =param+"ImeiCode";
			if(redisUtils.exists(redisKey)&&redisUtils.exists(param)&&redisUtils.get(redisKey).equals(pas.get("imeiCode").toString())){
				return (Map<String, Object>) redisUtils.get(param);
			}
		}
		return null;
	}

	
	
	
	
}
