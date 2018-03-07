package com.anyikang.controller.web;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.Device;
import com.anyikang.model.OldManMsg;
import com.anyikang.model.vo.RescueDevice;
import com.anyikang.service.DeviceService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

/**
 * 佩戴者信息处理
 * @author LvXiaoxiong
 * @date 2017/08/25
 *
 */
@RestController
@RequestMapping("web/oldman")
public class OldManController extends BaseController {
	
	
    @Autowired
    private DeviceService deviceService;


	
	/**
 	 * 添加佩戴者信息
 	 * @param request
 	 * @return
 	 */
 	@RequestMapping(value ="/addOldMan", method = RequestMethod.POST)
 	public BaseResponse<?> addOldMan(String xing,
 			                         String ming,
 			                         String phone,
			                         String address,
			                         String deviceIMEI,
			                         String deviceName,
 			                         int age,
 			                         int sex,
 			                         String tokenId,
 			                         @RequestParam(required=true) String phone1,
			                         @RequestParam(required=false) String phone2,
			                         @RequestParam(required=false) String phone3,
			                         @RequestParam(required=false) String phone4,
			                         @RequestParam(required=false) String phone5) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
        if(deviceIMEI==null||deviceIMEI.isEmpty()){
        	baseResponse.setStatus(0);
    		baseResponse.setMsg("创建失败,设备号不能为空");
    		return baseResponse;
        }
        if(xing==null||ming==null||phone==null||address==null){
        	baseResponse.setStatus(0);
    		baseResponse.setMsg("您有必填项未填写,请补充后再提交");
    		return baseResponse;
        }
        RescueDevice device = deviceService.findByDeviceNumber(deviceIMEI);
 	    int deviceId=0;
 	    if(device == null){
 	    	//如果设备不存在,创建设备
 	    	RescueDevice addDevice = new RescueDevice();
 	    	addDevice.setDeviceCreateTime(new Timestamp(System.currentTimeMillis()));
 	    	addDevice.setDeviceIMEI(deviceIMEI);
 	    	addDevice.setDeviceName(deviceName);
 	    	addDevice.setBluetoothStatus(0);
 	    	boolean flag =deviceService.addDevice(addDevice);
 	    	if(flag){
 	    		deviceId=addDevice.getDeviceId();
 	    	}
 	    }else{
 	    	deviceId=device.getDeviceId();
 	    }
 	    Map<String,Object> oldMan =deviceService.findOldManMsg(deviceId);
 	    if(oldMan!=null&&oldMan.size()>0){
 		    baseResponse.setStatus(0);
 			baseResponse.setMsg("创建失败,该佩戴者信息已经录入,请勿重复录入");
 			return baseResponse;
 	    }
 	
 		OldManMsg  om = new OldManMsg();
 	    om.setAge(age);
 	    om.setDeviceId(deviceId);
 	    om.setMobile(phone);
 	    om.setName(ming);
 	    om.setSurname(xing);
 	    om.setOldManId(UUID.randomUUID().toString());
 	    om.setAddress(address);
 	    om.setSex(sex);
	    
	    //佩戴者信息存储
		boolean  flag=deviceService.addOldMan(om);
		if(flag==true){
			//添加亲情号已经亲情号与佩戴者管理表
			boolean addParentPhones =deviceService.addEmergency(phone1,phone2,phone3,phone4,phone5,om.getOldManId());
			if(addParentPhones){
				baseResponse.setStatus(1);
				baseResponse.setMsg("创建成功");
				return baseResponse;
			}
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("创建失败");
		return baseResponse;
	}

 	
	 /**
     * 查询佩戴者信息
     * @param deviceIMEI
     * @return
     */
    @RequestMapping(value = "/findOldMan", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse<?> findOldMan(@RequestParam String tokenId,int pageIndex,int pageSize,
    		@RequestParam(required = false) String deviceIMEI){
    	
    	BaseResponse<PageInfo<List<Map<String,Object>>>>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
    	PageMethod.startPage(pageIndex, pageSize);
		@SuppressWarnings("unchecked")
		PageInfo<List<Map<String,Object>>> pageInfo=page(deviceService.findOldMans(deviceIMEI));
		if(pageInfo==null){
			baseResponse.setMsg("查询失败,无数据");
			baseResponse.setStatus(0);
			return baseResponse;
	   
		}
		baseResponse.setData(pageInfo);
		baseResponse.setMsg("查询成功");
		baseResponse.setStatus(1);
		return baseResponse;
   
       
    }
 	
 	
 	
 	/**
 	 * 修改佩戴者信息
 	 * @param request
 	 * @return
 	 */
 	@RequestMapping(value ="/updateOldMan", method = RequestMethod.POST)
 	public BaseResponse<?> updateOldMan(
 			                             String oldManId,
							 			 String xing,
							             String ming,
							             String phone,
							             String address,
							             int age,
							             int sex,
							             String tokenId) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
        
 		OldManMsg  om = new OldManMsg();
 	    om.setAge(age);
 	    om.setMobile(phone);
 	    om.setName(ming);
 	    om.setSurname(xing);
 	    om.setOldManId(oldManId);
 	    om.setAddress(address);
 	    om.setSex(sex);
 	    om.setCreateTime(new Date());
 		
		//有此佩戴者信息,修改
		boolean  flags=deviceService.updateOldMan(om);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("设置成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("设置失败");
		return baseResponse;
	}

 	
    /**
     * 删除佩戴者信息
     * @param deviceIMEI
     * @return
     */
    @RequestMapping(value = "/deleteOldMan", method = {RequestMethod.GET})
    @ResponseBody
    public BaseResponse<?> deleteOldMan(@RequestParam String tokenId,String oldManId){
    	
    	BaseResponse<String>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
    	//首先亲情号,再删佩戴者
    	boolean  fl =deviceService.deleteEmergency(oldManId);
    	if(fl){
			 boolean  flag=deviceService.deleteOldMan(oldManId);
			 if(flag){
				 baseResponse.setMsg("删除成功");
			     baseResponse.setStatus(1);
			     return baseResponse;
			 }
    	}
		baseResponse.setMsg("删除失败");
		baseResponse.setStatus(1);
		return baseResponse;
    }
    
 	
    /**
 	 * 修改佩戴者亲情号
 	 * @param request
 	 * @return
 	 */
 	@RequestMapping(value ="/updateParentPhones", method = RequestMethod.POST)
 	public BaseResponse<?> updateParentPhones(
 			                             String emergencyId,
							             String phone,
							             String tokenId) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
		//有此佩戴者信息,修改
		boolean  flags=deviceService.updateParentPhones(emergencyId,phone);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("修改成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("修改失败");
		return baseResponse;
	}
 	
 	
 	/**
 	 * 删除单个佩戴者亲情号
 	 * @param request
 	 * @return
 	 */
 	@RequestMapping(value ="/deleteParentPhones", method = RequestMethod.POST)
 	public BaseResponse<?> deleteParentPhones(
 			                             String emergencyId,
 			                             String oldManId,
							             String tokenId) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
 		//判断是否只剩一个亲情号,如果只剩一个,则不允许删除,只能修改
 		int parentPhones =deviceService.findParentPhones(oldManId);
 		if(parentPhones<2){
 			baseResponse.setStatus(0);
 			baseResponse.setMsg("删除失败,亲情号不允许删除完");
 			return baseResponse;
 		}
		//删除亲情号
		boolean  flags=deviceService.deleteParentPhones(emergencyId);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("删除成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("删除失败");
		return baseResponse;
	}


    /**
 	 * 添加佩戴者亲情号
 	 * @param request
 	 * @return
 	 */
 	@RequestMapping(value ="/addParentPhone", method = RequestMethod.POST)
 	public BaseResponse<?> addParentPhone(
 			                             String oldManId,
							             String phone,
							             String tokenId) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
 		int parentPhones =deviceService.findParentPhones(oldManId);
 		if(parentPhones>=5){
 			baseResponse.setStatus(0);
 			baseResponse.setMsg("添加失败,亲情号不能超过5个");
 			return baseResponse;
 		}
		//有此佩戴者信息,修改
		boolean  flags=deviceService.addParentPhone(oldManId,phone);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("添加成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("添加失败");
		return baseResponse;
	}

}
