/**
 * 
 */
package com.anyikang.components.rabbitmq.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.rabbitmq.service.ResponseCofigUR2Service;
import com.anyikang.utils.BCDUtils;
import com.anyikang.utils.IEEE754Utils;
import com.anyikang.utils.RedisUtils;

/**
 * @author wangwei
 * @date 2017年4月14日
 */

  
@Service
public class ResponseCofigUR2ServiceImpl implements ResponseCofigUR2Service {

	
	@Autowired  
    private RedisUtils redisUtils;
	private String beginCode ="68 ";
	private String endCode ="16";
	private static final long EXPIRY_TIME =3L;
	
	
	

	/*
	 * 时间配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#timeConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> timeConfig(Map<String, Object> params) {
		
		if(params.isEmpty()){
			return null;
		}
		redisUtils.set("timeConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("时间配置响应", sb);
		System.err.println(sb);
		redisUtils.set("timeConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
		
	}
    /*
     * 定位配置响应信息
     * (non-Javadoc)
     * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#locationConfig(java.util.Map)
     */
	@Override
	public Map<String, Object> locationConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		redisUtils.set("locationConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("定位配置响应", sb);
		System.err.println(sb);
		redisUtils.set("locationConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}
 
	/* 电子围栏配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#electricConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> electricConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("electricConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		if(params.containsKey("latitude")){
			params.put("latitude", IEEE754Utils.floatToIEEE754(Float.parseFloat(params.get("latitude").toString())));
		}
		if(params.containsKey("longitude")){
			params.put("longitude", IEEE754Utils.floatToIEEE754(Float.parseFloat(params.get("longitude").toString())));
		}
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("电子围栏配置响应", sb);
		System.err.println(sb);
		redisUtils.set("electricConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	/* ip配置响应
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#ipConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> ipConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("ipConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("ip配置响应", sb);
		System.err.println(sb);
		redisUtils.set("ipConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	/*
	 * 心跳配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#heartConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> heartConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("heartConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("心跳配置响应", sb);
		System.err.println(sb);
		redisUtils.set("heartConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	/*
	 * wifi配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#wifiConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> wifiConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		
		redisUtils.set("wifiConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		for(Map.Entry<String, Object> param:params.entrySet()){
			if(param.getKey().equals("userName")||param.getKey().equals("paramssword")){
				byte [] value =param.getValue().toString().getBytes();
				params.put(param.getKey(), BCDUtils.byteToHexString(value).replaceAll(" ", ""));
			}
		}
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("wifi配置响应", sb);
		System.err.println(sb);
		redisUtils.set("wifiConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	/*
	 * 提醒配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#remindConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> remindConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("remindConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("提醒配置响应", sb);
		System.err.println(sb);
		redisUtils.set("remindConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	/*
	 * 信息推送配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#messageConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> messageConfig(Map<String, Object> params) {
		
		if(params.isEmpty()){
			return null;
		}
		
		
		redisUtils.set("messageConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("信息推送配置响应", sb);
		System.err.println(sb);
		redisUtils.set("messageConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}

	/* 
	 *  远程控制配置响应
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#telecontrolConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> telecontrolConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("telecontrolConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("远程控制配置响应", sb);
		System.err.println(sb);
		redisUtils.set("telecontrolConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}
    
	/*
	 * 亲情号配置响应
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#familyConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> familyConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("familyConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("亲情号配置响应", sb);
		System.err.println(sb);
		redisUtils.set("familyConfig", resultMap,EXPIRY_TIME);
		return resultMap;
	}
	
	/*
	 * sos配置响应
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#sosConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> sosConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("sosConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("sos配置响应", sb);
		System.err.println(sb);
		redisUtils.set("sosConfig", resultMap,EXPIRY_TIME);
		return resultMap;
	}
	
	/*
	 * 白名单配置
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#whiteListConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> whiteListConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("whiteListConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("白名单配置响应", sb);
		System.err.println(sb);
		redisUtils.set("whiteListConfig", resultMap,EXPIRY_TIME);
		return resultMap;
	}
	
	/*
	 * 跌倒配置
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#fallConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> fallConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		
		redisUtils.set("fallConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("跌倒配置响应", sb);
		System.err.println(sb);
		redisUtils.set("fallConfig", resultMap,EXPIRY_TIME);
		return resultMap;
	}
	
	/*
	 *  运动配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#sportsConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> sportsConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		redisUtils.set("sportsConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("运动配置响应", sb);
		System.err.println(sb);
		redisUtils.set("sportsConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}
	
	/* 心率配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#heartRateConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> heartRateConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		redisUtils.set("heartRateConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("心率配置响应", sb);
		System.err.println(sb);
		redisUtils.set("heartRateConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}
	
	/*  闹钟配置响应信息
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#clockConfig(java.util.Map)
	 */
	@Override
	public Map<String, Object> clockConfig(Map<String, Object> params) {
		if(params.isEmpty()){
			return null;
		}
		redisUtils.set("clockConfigImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new HashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+" ");
		}
		sb.append(endCode);
		resultMap.put("闹钟配置响应", sb);
		System.err.println(sb);
		redisUtils.set("clockConfig", resultMap,EXPIRY_TIME);
		return resultMap; 
	}
    
/*	public static void main(String [] args){
		Map<String, Object> map =(Map<String, Object>) redisUtil.get("time");
		for(Map.Entry<String, Object> param:map.entrySet()){
			System.err.println(param.getValue().toString());
	}*/
	
	}	

