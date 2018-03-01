/**
 * 
 */
package com.anyikang.components.rabbitmq.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.components.rabbitmq.service.ResponseCofigUR1Service;
import com.anyikang.dao.DeviceMapper;
import com.anyikang.utils.RedisUtils;

/**
 * @author wangwei
 * @date 2017年4月14日
 */

  
@Service
public class ResponseCofigUR1ServiceImpl implements ResponseCofigUR1Service {

	@Autowired  
	private DeviceMapper deviceMapper;
	@Autowired  
    private RedisUtils redisUtils;
	private String beginCode ="[";
	private String endCode ="]";
	private static final long EXPIRY_TIME =3L;
	
	
   /*
    * (non-Javadoc)
    * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#upload(java.util.Map)
    */
	@Override
	public void upload(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("数据上传间隔设置响应", sb);
		System.err.println(sb);

		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#center(java.util.Map)
	 */
	@Override
	public void center(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("centerImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("中心号码设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("centerConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#callResponse(java.util.Map)
	 */
	@Override
	public void callResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("callImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("拔打电话指令设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("callConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#monitorResponse(java.util.Map)
	 */
	@Override
	public void monitorResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("monitorImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("监听指令设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("monitorConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#sosOneResponse(java.util.Map)
	 */
	@Override
	public void sosOneResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("sosOneImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("单个sos号码设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("sosOneConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#sosResponse(java.util.Map)
	 */
	@Override
	public void sosResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("sosImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("三个sos号码同时设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("sosConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#crResponse(java.util.Map)
	 */
	@Override
	public void crResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
		redisUtils.set("crImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("定位指令设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("crConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#poweroffResponse(java.util.Map)
	 */
	@Override
	public void poweroffResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("poweroffImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("关机指令设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("poweroffConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#findResponse(java.util.Map)
	 */
	@Override
	public void findResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("findImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("找定位器设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("findConfig", resultMap,EXPIRY_TIME);
		
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.anyikang.components.rabbitmq.service.ResponseCofigService#factoryResponse(java.util.Map)
	 */
	@Override
	public void factoryResponse(Map<String, Object> params) {
		if(params.isEmpty()){
			return;
		}
//		redisUtils.set("factoryImeiCode", params.get("imeiCode").toString(),EXPIRY_TIME);
		Map<String, Object> resultMap = new LinkedHashMap<>();
		StringBuffer sb = new StringBuffer();
		sb.append(beginCode);
		for(Map.Entry<String, Object> param:params.entrySet()){
			sb.append(param.getValue().toString()+"*");
		}
		sb.deleteCharAt(sb.length()-1);
		sb.append(endCode);
		resultMap.put("恢复出厂设置响应", sb);
		System.err.println(sb);
//		redisUtils.set("factoryConfig", resultMap,EXPIRY_TIME);
		
	}
    

	
}	

