/**
 * 
 */
package com.anyikang.service;

import java.util.List;
import java.util.Map;

/**
 * @author wangwei
 * @date 2017年4月17日
 */
public interface InstructionsService {

	/**
	 * 发送指令
	 * 
	 * @param jsonStr
	 * @return
	 */
	public boolean send(Map<String, Object> pas);

	
	/**
	 * 配置、查询响应信息查询请求(从redis缓存中获取)
	 * 
	 * @param pas
	 * @return
	 */
	public Map<String, Object> responseQuery(Map<String, Object> pas);
	
	
	
	
	
	

}
