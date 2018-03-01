/**
 * 
 */
package com.anyikang.controller.web;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.service.InstructionsService;

/**
 * 配置指令、查询指令
 * @author wangwei
 * @date 2017年4月6日
 */
@RestController
@RequestMapping(value = "/web/instructions")
public class RescueConfigController {

	 private Logger logger = LoggerFactory.getLogger(RescueConfigController.class);

	    @Autowired
	    private InstructionsService settingService;

	    
	    /**
		 * 指令发送
		 * 
		 * @param messageBody
		 */
	    
	    @RequestMapping(value = "/send", method = { RequestMethod.POST },produces = "application/json")
		public Map<String,Object> config(@RequestBody Map<String,Object> pas) throws RemoteException {
	    	boolean isSuccess=settingService.send(pas);
	    	Map<String, Object> response=new HashMap<>();
	    	response.put("isSuccess", isSuccess);
	        return response;
		}
   
	    
		/**
		 * 查询响应信息处理控制器
		 * 
		 * @param messageBody
		 * @return
		 */
	    @RequestMapping(value = "/responseQuery", method = { RequestMethod.POST },produces = "application/json")
		public Map<String,Object> responseQuery(@RequestBody Map<String,Object> pas) throws RemoteException {
	    	Map<String,Object> map=settingService.responseQuery(pas);
	        return map;
		}
        
		
}
