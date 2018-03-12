package com.anyikang.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseResponse;
import com.anyikang.base.Constants;
import com.anyikang.model.admin.AdminPermission;
import com.anyikang.service.AlarmService;
import com.anyikang.service.DeviceService;
import com.anyikang.service.admin.AdminPermissionService;
import com.anyikang.utils.MapAPIUtil;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
@RestController
public class indexController {
    @Autowired
    private AdminPermissionService adminPermissionService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private AlarmService alarmService;
    
    @RequestMapping({"/index"})
    public BaseResponse<?> index(Integer roleId,String tokenId){
        BaseResponse<List<AdminPermission> > responseMessage = new BaseResponse<>();
        List<AdminPermission> adminPermissionList = null;
        if(roleId == Constants.SUPER_ADMINISTRATOR){
            adminPermissionList = adminPermissionService.selectPermissionAll();
        }else{
//            adminPermissionList =  adminPermissionService.selectPermissionUserId(userId);
            adminPermissionList =  adminPermissionService.selectPermissionUserId(Integer.parseInt(StringUtils.split(tokenId, "==")[1]));
        }
        responseMessage.setData(adminPermissionList);
        return responseMessage;
    }
    
    /**
     * 首页地图显示
     * @param tokenId
     * @return
     */
    @GetMapping(value="/index/datas")
    public BaseResponse<?> indexDatas(String tokenId){
    	BaseResponse<Map<String,Object>> responseMessage = new BaseResponse<>();
    	Map<String,Object> map=new HashMap<>();
    	
		//查询求救者位置 
		List<Map<String,Object>>  deviceList=deviceService.getAllDevices();
    	if(deviceList!=null&&deviceList.size()>0){
    		for(Map<String,Object> deviceMap:deviceList){
    			if(deviceMap.containsKey("famillyPhones")){
    				String [] phone =deviceMap.get("famillyPhones").toString().split(",");
    				deviceMap.put("famillyPhones", phone);
    			}
    		}
    		map.put("deviceList", deviceList);
    	}else{
    		map.put("deviceList", new ArrayList<>());	
    	}
    	//查询佩戴者当前报警状态
    	List<Map<String,Object>> sosList =alarmService.getAllSos();
    	if(sosList!=null&&sosList.size()>0){
    		map.put("sosList", sosList);
    	}else{
    		map.put("sosList", new ArrayList<>());
    	}
    	responseMessage.setData(map);
    	return responseMessage;
    }

}
