/**
 * 
 */
package com.anyikang.components.rabbitmq.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.rabbitmq.service.ResponseMessageQueryService;
import com.anyikang.utils.IEEE754Utils;
import com.anyikang.utils.RedisUtils;

/**
 * @author wangwei
 * @date 2017年4月11日
 */
@Service
public class ResponseMessageQueryServiceImpl implements ResponseMessageQueryService {

	@Autowired  
    private RedisUtils redisUtils;
	private String beginCode ="68 ";
	private String endCode ="16";
	private static final long EXPIRY_TIME =3L;
	
    /*
     * 版本信息查询服务响应信息
     * (non-Javadoc)
     * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#timeConfig(java.util.Map)
     */
	@Override
	public Map<String, Object> versionMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("versionMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("版本信息查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("versionMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	/*
	 * 定位查询服务响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#locationConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> locationMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("locationMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		for(Map.Entry<String, Object> param:params.entrySet()){
			if(param.getKey().equals("latitude")||param.getKey().equals("longitude")
				||param.getKey().equals("height")||param.getKey().equals("speed")
				||param.getKey().equals("direction")||param.getKey().equals("precision")){
				params.put(param.getKey(), IEEE754Utils.floatToIEEE754(Float.parseFloat(param.getValue().toString())));
			}
		}
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("定位查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("locationMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}
 
	/*
     * 丢失报文查询服务响应信息
     * (non-Javadoc)
     * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#electricConfig(java.util.Map)
     */
	@Override
	public Map<String, Object> lostWordMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("lostWordMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		for(Map.Entry<String, Object> param:params.entrySet()){
			if(param.getKey().equals("latitude")||param.getKey().equals("longitude")
				||param.getKey().equals("height")||param.getKey().equals("speed")
				||param.getKey().equals("direction")||param.getKey().equals("precision")){
				params.put(param.getKey(), IEEE754Utils.floatToIEEE754(Float.parseFloat(param.getValue().toString())));
			}
		}
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("丢失报文查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("lostWordMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}
	
	/*
	 * 运动信息查询服务响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#sportsMessage(java.util.Map)
	 */

	@Override
	public Map<String, Object> sportsMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("sportsMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("运动信息查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("sportsMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	
	/*
	 * 心率信息查询服务响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#heartRateMessage(java.util.Map)
	 */
	@Override
	public Map<String, Object> heartRateMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("heartRateMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("心率信息查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("heartRateMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	
	/*
	 * 血氧信息查询服务响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#oxygenMessage(java.util.Map)
	 */
	@Override
	public Map<String, Object> oxygenMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("oxygenMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("血氧信息查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("oxygenMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	
	/*
	 * 血压信息查询服务响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#bloodPressureMessage(java.util.Map)
	 */
	@Override
	public Map<String, Object> bloodPressureMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("bloodPressureMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("血压信息查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("bloodPressureMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	
	/*
	 * 睡眠信息查询服务响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseMessageQueryService#sleepMessage(java.util.Map)
	 */
	@Override
	public Map<String, Object> sleepMessage(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("sleepMessageImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
				sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("睡眠信息查询服务响应信息", sb);
		System.err.println(sb);
		redisUtils.set("sleepMessage", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	 
}
