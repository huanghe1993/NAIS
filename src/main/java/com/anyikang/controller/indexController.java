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
import com.anyikang.service.DeviceService;
import com.anyikang.service.RescueCenterService;
import com.anyikang.service.RescueTeamService;
import com.anyikang.service.admin.AdminPermissionService;

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
	private RescueCenterService rescueCenterService;
    @Autowired
    private RescueTeamService rescueTeamService;
    
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
     * 除总中心外
     * @param tokenId
     * @return
     */
    @GetMapping(value="/index/datas")
    public BaseResponse<?> indexDatas(String tokenId){
    	BaseResponse<Map<String,Object>> responseMessage = new BaseResponse<>();
    	Map<String,Object> map=new HashMap<>();
    	
    	long userId=Long.parseLong(tokenId.split("==")[1]);
    	//查询该用户所对应的救援大队区域码,如果为0是全国总队,直接查询全部
    	Map<String,Object> cityCodeMap =rescueTeamService.findCenterCode(userId);
    	if(cityCodeMap==null){
    		responseMessage.setStatus(0);
    		responseMessage.setMsg("查询失败,无对应的救援中心");
    		return responseMessage;
    		
    	}
    	
		List<String> areaidList=rescueTeamService.getAreas(userId);
		//查询求救者位置 以及是否被接单
		List<Map<String,Object>>  deviceList=deviceService.getAllDevicesByAddr(areaidList.toArray(new String[areaidList.size()]));
		//查询任务单
		List<Map<String,Object>> taskList=rescueCenterService.getAllTaskByAddr(areaidList.toArray(new String[areaidList.size()]));
    		
    	if(deviceList==null||deviceList.size()==0){
    		map.put("deviceList", new ArrayList<>());
    	}
    	map.put("deviceList", deviceList);
    	
    	if(deviceList==null||deviceList.size()==0){
    		map.put("taskList", new ArrayList<>());
    	}
    	map.put("taskList", taskList);
    	
    	//查询监护人位置
    	List<Map<String,Object>> guardianList=rescueCenterService.getAllguardian();
    	if(deviceList==null||deviceList.size()==0){
    		map.put("guardianList", new ArrayList<>());
    	}
    	map.put("guardianList", guardianList);
    	responseMessage.setData(map);
    	return responseMessage;
    }

    
    
    /**
     * 总中心接口
     * @param tokenId
     * @return
     */
    @GetMapping(value="/index/datas/center")
    public BaseResponse<?> CenterIndexDatas(String tokenId,String cityCode){
    	BaseResponse<Map<String,Object>> responseMessage = new BaseResponse<>();
    	Map<String,Object> map=new HashMap<>();
    	
    	long userId=Long.parseLong(tokenId.split("==")[1]);
    	//查询该用户所对应的救援大队区域码,如果为0是全国总队,直接查询全部
    	Map<String,Object> cityCodeMap =rescueTeamService.findCenterCode(userId);
    	if(cityCodeMap==null){
    		responseMessage.setStatus(0);
    		responseMessage.setMsg("查询失败,无对应的救援中心");
    		return responseMessage;
    		
    	}
    	//总中心点击各个省查询,用各个省的cityCode反查userId
    	Map<String,Object>  userIdMap = rescueCenterService.findUserIdByCityCode(cityCode);
    	
    	List<String> areaidList=rescueTeamService.getAreas((int)userIdMap.get("userId"));
    	if(areaidList==null||areaidList.size()==0){
    		responseMessage.setStatus(0);
    		responseMessage.setMsg("查询失败");
    		return responseMessage;
    	}
		//查询求救者位置 以及是否被接单
		List<Map<String,Object>>  deviceList=deviceService.getAllDevicesByAddr(areaidList.toArray(new String[areaidList.size()]));
		//查询任务单
		List<Map<String,Object>> taskList=rescueCenterService.getAllTaskByAddr(areaidList.toArray(new String[areaidList.size()]));
    		
    	if(deviceList==null||deviceList.size()==0){
    		map.put("deviceList", new ArrayList<>());
    	}
    	map.put("deviceList", deviceList);
    	
    	if(deviceList==null||deviceList.size()==0){
    		map.put("taskList", new ArrayList<>());
    	}
    	map.put("taskList", taskList);
    	
    	//查询监护人位置
    	List<Map<String,Object>> guardianList=rescueCenterService.getAllguardian();
    	if(deviceList==null||deviceList.size()==0){
    		map.put("guardianList", new ArrayList<>());
    	}
    	map.put("guardianList", guardianList);
    	responseMessage.setData(map);
    	return responseMessage;
    }


}