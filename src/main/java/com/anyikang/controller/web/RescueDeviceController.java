package com.anyikang.controller.web;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.Device;
import com.anyikang.model.RescueCount;
import com.anyikang.model.vo.LocatorDeviceMessage;
import com.anyikang.model.vo.LocatorDeviceStatus;
import com.anyikang.model.vo.RescueDevice;
import com.anyikang.service.DeviceService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;


/**
 * 设备管理
 * @author LvXiaoxiong
 * @date 2017/11/13
 *
 */
@RestController
@RequestMapping("/web/")
public class RescueDeviceController extends BaseController{
     
	@Autowired
    private DeviceService deviceService;

	    

	
	/**
 	 * 设置佩戴者信息(添加或者修改)
 	 * @param request
 	 * @return
 	 */
 	@RequestMapping(value ="device/addDevice", method = RequestMethod.POST)
 	public BaseResponse<?> addDevice(String tokenId,String deviceName,int deviceType,String deviceIMEI) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
 	    Device device = deviceService.findByDeviceNumber(deviceIMEI);
 	    if(device != null){
 	    	baseResponse.setStatus(0);
 			baseResponse.setMsg("该设备已存在");
 			return baseResponse;
 	    }
 	    
 	    //如果设备不存在,创建设备
    	RescueDevice addDevice = new RescueDevice();
    	addDevice.setDeviceCreateTime(new Timestamp(System.currentTimeMillis()));
    	addDevice.setDeviceType(deviceType);
    	addDevice.setDeviceIMEI(deviceIMEI);
    	addDevice.setDeviceName(deviceName);
    	boolean flag =deviceService.addDevice(addDevice);
    	if(flag){
    		baseResponse.setStatus(1);
 			baseResponse.setMsg("设备添加成功");
 			return baseResponse;
    	}
    	baseResponse.setStatus(0);
		baseResponse.setMsg("设备添加失败");
		return baseResponse;
		
	}


 	/**
 	 * 查询所有设备种类
 	 * @param tokenId
 	 * @return
 	 */
 	@RequestMapping(value ="device/findDeviceKinds", method = RequestMethod.GET)
 	public BaseResponse<?> findDeviceKinds(String tokenId) {
 		BaseResponse<List<Map<String,Object>>> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
  
    	List<Map<String,Object>> deviceList =deviceService.findDeviceKinds();
    	if(deviceList!=null&&deviceList.size()!=0){
    		baseResponse.setStatus(1);
 			baseResponse.setMsg("查询成功");
 			baseResponse.setData(deviceList);
 			return baseResponse;
    	}
    	baseResponse.setStatus(0);
		baseResponse.setMsg("查询失败");
		return baseResponse;
		
	}

 	
 	
 	/**
 	 * 查询所有设备
 	 * @param tokenId
 	 * @return
 	 */
 	@RequestMapping(value ="device/findDevice", method = RequestMethod.GET)
 	public BaseResponse<?> findDevice(String tokenId,int pageIndex,int pageSize) {
 		
		BaseResponse<PageInfo<List<Map<String,Object>>>> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
 		PageMethod.startPage(pageIndex, pageSize);
 		
 		@SuppressWarnings("unchecked")
		PageInfo<List<Map<String,Object>>> deviceList =page(deviceService.findDevice());
    	if(deviceList!=null){
    		baseResponse.setStatus(1);
 			baseResponse.setMsg("查询设备成功");
 			baseResponse.setData(deviceList);
 			return baseResponse;
    	}
    	baseResponse.setStatus(0);
		baseResponse.setMsg("查询设备失败");
		return baseResponse;
		
	}

 	
 	
	
 	/**
     * 查询在线设备控制器
     * @return
     */
	@GetMapping("query/onLine")
    public BaseResponse<?> queryOnLineDevice(int pageIndex, int pageSize,String tokenId) {
		BaseResponse<PageInfo<List<Map<String,Object>>>> responseMessage = new BaseResponse<>();
		PageMethod.startPage(pageIndex, pageSize);
		List<Map<String,Object>> list = deviceService.onLineDevice();
		if(list==null){
			responseMessage.setStatus(0);
			responseMessage.setMsg("无数据");
			return responseMessage;
		}
		@SuppressWarnings("unchecked")
		PageInfo<List<Map<String,Object>>> pageInfo=page(list);
		List<Map<String,Object>> deviceList =deviceService.findDevice();
		if(deviceList!=null&&deviceList.size()>0){
			long total =pageInfo.getTotal();
			int size = deviceList.size();
		    double percentage =((double)(total))/(size);
			String percentages =String.valueOf(percentage);
			if(percentages.length()>=5){
				percentage=Double.valueOf(percentages.substring(0, 5));
			}
			responseMessage.setData(pageInfo);
			responseMessage.setObjectbean(percentage);
			responseMessage.setStatus(1);
			responseMessage.setMsg("查询成功");
			return responseMessage;
		}
		responseMessage.setData(pageInfo);
		responseMessage.setStatus(1);
		responseMessage.setMsg("查询成功");
		return responseMessage;
 
    }
	
	
	/**
     * 查询非在线设备控制器
     * @return
     */
    @GetMapping("query/offLine")
    public BaseResponse<?> queryOffLineDevice(int pageIndex, int pageSize,String tokenId) {
    	
    	BaseResponse<PageInfo<List<Map<String,Object>>>> responseMessage = new BaseResponse<>();
		PageMethod.startPage(pageIndex, pageSize);
		List<Map<String,Object>> list = deviceService.offLineDevice();
		if(list==null){
			responseMessage.setStatus(0);
			responseMessage.setMsg("无数据");
			return responseMessage;
		}
		@SuppressWarnings("unchecked")
		PageInfo<List<Map<String,Object>>> pageInfo=page(list);
		List<Map<String,Object>> deviceList =deviceService.findDevice();
		if(deviceList!=null&&deviceList.size()>0){
			long total =pageInfo.getTotal();
			int size = deviceList.size();
			double percentage =((double)(total))/(size);
			String percentages =String.valueOf(percentage);
			if(percentages.length()>=5){
				percentage=Double.valueOf(percentages.substring(0, 5));
			}
		    System.err.println("========"+pageInfo.getList().size()+"======="+deviceList.size()+"=========");
			responseMessage.setData(pageInfo);
			responseMessage.setObjectbean(percentage);
			responseMessage.setStatus(1);
			responseMessage.setMsg("查询成功");
			return responseMessage;
		}
		responseMessage.setData(pageInfo);
		responseMessage.setStatus(1);
		responseMessage.setMsg("查询成功");
		return responseMessage;
 
		
    }
    

    /**
     * 分页查询所有设备信息
     * @return
     */
    @GetMapping("query/device")
    public BaseResponse<?> queryAllDevice(@RequestParam(value="deviceImei",required=false) String deviceImei,int pageIndex, int pageSize) {
	
		BaseResponse<PageInfo<List<LocatorDeviceMessage>>> responseMessage = new BaseResponse<>();
		PageMethod.startPage(pageIndex, pageSize);
		@SuppressWarnings("unchecked")
		PageInfo<List<LocatorDeviceMessage>> pageInfo=page(deviceService.queryDevice(deviceImei));
		responseMessage.setData(pageInfo);
		return responseMessage;

   }
    
    /**
     * 查询当前设备所有轨迹信息
     * @param imeiCode
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping("query/orbit")
    public BaseResponse<?> queryOrbit(@RequestBody Map<String,Object> map) {
    	BaseResponse<List<Map<String,Object>>> responseMessage = new BaseResponse<>();
    	List<Map<String,Object>> list =deviceService.queryOrbits(map);
    	if(list.size()==0||list==null){
    		responseMessage.setMsg("无轨迹信息");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}
    	responseMessage.setMsg("查询成功");
		responseMessage.setStatus(1);
    	responseMessage.setData(list);
        return responseMessage;
    }
    
    /**
     * 查询设备状态控制器
     * @param imeiCode
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("query/status")
    public BaseResponse<?> queryMessageByDeviceStatus(@RequestParam(value="deviceImei",required=false) String deviceImei,int pageIndex, int pageSize) {
 
		BaseResponse<PageInfo<List<LocatorDeviceStatus>>> responseMessage = new BaseResponse<>();
		PageMethod.startPage(pageIndex, pageSize);
		@SuppressWarnings("unchecked")
		PageInfo<List<LocatorDeviceStatus>> pageInfo=page(deviceService.queryDeviceStatusMessage(deviceImei));
		responseMessage.setData(pageInfo);
		return responseMessage;
		
    }
    
    
    /**
     * 救援统计(第1阶) 
     * @param rescueTeamId
     * @param pageIndex
     * @param pageSize
     * @return
     */
	@GetMapping("query/rescueCount")
    public BaseResponse<?> rescueCount(int pageIndex,int pageSize,String tokenId) {
    	
		BaseResponse<PageInfo<List<RescueCount>>> responseMessage = new BaseResponse<>();
		PageMethod.startPage(pageIndex, pageSize);
		Integer userId = Integer.valueOf(tokenId.split("==")[1]);
		@SuppressWarnings("unchecked")
		PageInfo<List<RescueCount>> pageInfo= page(deviceService.rescueCount(userId));
		if(pageInfo==null){
			responseMessage.setMsg("查询失败");
			responseMessage.setStatus(0);
			return responseMessage;
		}
		responseMessage.setData(pageInfo);
		responseMessage.setMsg("查询成功");
		responseMessage.setStatus(1);
		return responseMessage;
 
    }
    
	/**
	 * 救援统计(第二、三阶) 按ID查询
	 * @param pageIndex
	 * @param pageSize
	 * @param tokenId
	 * @param rescueCenterId
	 * @return
	 */
	@GetMapping("query/rescueCount/rescueCenterId")
    public BaseResponse<?> rescueCenterId(int pageIndex,int pageSize,String tokenId,String rescueCenterId) {
    	
		BaseResponse<PageInfo<List<RescueCount>>> responseMessage = new BaseResponse<>();
		PageMethod.startPage(pageIndex, pageSize);

		@SuppressWarnings("unchecked")
		PageInfo<List<RescueCount>> pageInfo= page(deviceService.rescueCenterId(rescueCenterId));
		if(pageInfo==null){
			responseMessage.setMsg("查询失败");
			responseMessage.setStatus(0);
			return responseMessage;
		}
		responseMessage.setData(pageInfo);
		responseMessage.setMsg("查询成功");
		responseMessage.setStatus(1);
		return responseMessage;
 
    }
	
	
}
