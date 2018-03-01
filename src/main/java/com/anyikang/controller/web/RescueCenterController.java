package com.anyikang.controller.web;



import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.RescueCenter;
import com.anyikang.service.RescueCenterService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;


/**
 * 
 * 紧急救助系统志愿者录入以及管理控制器
 * @author LvXiaoxiong 
 * @date   2017/07/13
 */
@RestController
@RequestMapping("/web/rescueCenter")
public class RescueCenterController extends BaseController{
    
	private Logger logger = Logger.getLogger(RescueCenterController.class);
	@Value("${spring.files.images-path}")
	private  String imagePath;
	
	@Autowired
	private RescueCenterService rescueCenterService;
	

    /**
     * 添加救援中心
     * @param map
     * @return
     */

	@PostMapping("/addRescue")
    public BaseResponse<?> addRescue(String tokenId,
    		                         String rescueCenterName,
    		                         String rescueChargeName,
    		                         String code,
    		                         String ChargeMobile,
    		                         String address,
    		                         String mark,
    		                         @RequestParam(value="rescueParentCode",required=false) String rescueParentCode){
		
    	BaseResponse<String> responseMessage = new BaseResponse<>();
    	int flag =rescueCenterService.addRescue(rescueCenterName,rescueChargeName,code,ChargeMobile,address,mark,rescueParentCode);
    	if(flag==1){
    		responseMessage.setMsg("添加成功");
    		responseMessage.setStatus(1);
    		return responseMessage;
    	}else if(flag==2){
    		responseMessage.setMsg("添加失败,您输入的手机号已经被人注册,请更换");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}else if(flag==3){
    		responseMessage.setMsg("添加失败,该区域的救援中心已经创建,请勿重复创建");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}else{
    		responseMessage.setMsg("添加失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}
    }
    
	/**
	 * 查询省份以及省份的区域码
	 * @param tokenId
	 * @return
	 */
	@GetMapping("/findProvinceCode")
    public BaseResponse<?> findProvinceCode(String tokenId){
		
    	BaseResponse<List<Map<String,Object>>> responseMessage = new BaseResponse<>();
    	List<Map<String,Object>> provinceList =rescueCenterService.findProvinceCode();
    	if(provinceList!=null&&provinceList.size()!=0){
    		responseMessage.setMsg("查询成功");
    		responseMessage.setStatus(1);
    		responseMessage.setData(provinceList);
    		return responseMessage;
    	}else{
    		responseMessage.setMsg("查询失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}
    }
	
	/**
	 * 查询城市以及城市区域码
	 * @param tokenId
	 * @param provinceId
	 * @return
	 */
	@GetMapping("/findCityCode")
    public BaseResponse<?> findCityCode(String tokenId,String provinceId){
		
    	BaseResponse<List<Map<String,Object>>> responseMessage = new BaseResponse<>();
    	List<Map<String,Object>> cityList =rescueCenterService.findCityCode(provinceId);
    	if(cityList!=null&&cityList.size()!=0){
    		responseMessage.setMsg("查询成功");
    		responseMessage.setStatus(1);
    		responseMessage.setData(cityList);
    		return responseMessage;
    	}else{
    		responseMessage.setMsg("查询失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}
    }
	
	
	/**
	 * 查询区、县以及区县区域码
	 * @param tokenId
	 * @param cityId
	 * @return
	 */
	@GetMapping("/findDistrictCode")
    public BaseResponse<?> findDistrictCode(String tokenId,String cityId){
		
    	BaseResponse<List<Map<String,Object>>> responseMessage = new BaseResponse<>();
    	List<Map<String,Object>> cityList =rescueCenterService.findDistrictCode(cityId);
    	if(cityList!=null&&cityList.size()!=0){
    		responseMessage.setMsg("查询成功");
    		responseMessage.setStatus(1);
    		responseMessage.setData(cityList);
    		return responseMessage;
    	}else{
    		responseMessage.setMsg("查询失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}
    }
	
	/**
	 * 查询上级单位
	 * @param tokenId
	 * @param code
	 * @return
	 */
	@GetMapping("/findParent")
    public BaseResponse<?> findParent(String tokenId,String code){
		
    	BaseResponse<List<Map<String,Object>>> responseMessage = new BaseResponse<>();
    	List<Map<String,Object>> cityList =rescueCenterService.findParent(code);
    	if(cityList!=null&&cityList.size()!=0){
    		responseMessage.setMsg("查询成功");
    		responseMessage.setStatus(1);
    		responseMessage.setData(cityList);
    		return responseMessage;
    	}else{
    		responseMessage.setMsg("查询失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}
    }
	
	

    /**
     * 删除救援中心
     * @param rescueCenterId
     * @return
     */
	@GetMapping("/deleteRescue")
    public BaseResponse<?> deleteRescue(String rescueCenterId){
    	BaseResponse<String> responseMessage = new BaseResponse<>();
    	Boolean flag =rescueCenterService.deleteRescueById(rescueCenterId);
    	if(flag==true){
    		responseMessage.setData("删除成功");
    		responseMessage.setStatus(1);
    		return responseMessage;
    	}else{
    		responseMessage.setData("删除失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}

    }
	  
    
    /**
     * 修改救援中心信息
     * @param map
     * @return
     */
	@PostMapping("/modifyRescue")
    public BaseResponse<?> modifyRescue(@RequestBody Map<String,Object> map){
    	BaseResponse<String> responseMessage = new BaseResponse<>();
    	Boolean flag =rescueCenterService.modifyRescue(map);
    	if(flag==true){
    		responseMessage.setMsg("修改成功");
    		responseMessage.setStatus(1);
    		return responseMessage;
    	}else{
    		responseMessage.setMsg("修改失败");
    		responseMessage.setStatus(0);
    		return responseMessage;
    	}


    }
    
    /**
     * 分页查询救援中心信息/根据救援中心名称查询
     * @param rescueCenterName
     * @return
     */
    @GetMapping("/findRescues")
    public BaseResponse<?> findRescues(int pageIndex,int pageSize,String tokenId,@RequestParam(value="rescueCenterName",required=false) String rescueCenterName){
    	
    	@SuppressWarnings("rawtypes")
		BaseResponse<PageInfo> responseMessage = new BaseResponse<>();
    	PageMethod.startPage(pageIndex, pageSize);
		@SuppressWarnings("unchecked")
		PageInfo<List<RescueCenter>> pageInfo=page(rescueCenterService.findRescues(rescueCenterName));
        if(pageInfo==null){
        	responseMessage.setMsg("查询失败");
        	responseMessage.setStatus(0);
    		return responseMessage;
        }
		responseMessage.setMsg("查询成功");
		responseMessage.setData(pageInfo);
		responseMessage.setStatus(1);                                           
		return responseMessage;
    }
	
    
    /**
     * 查询救援中心信息
     * @param rescueCenterName
     * @return
     */
    @GetMapping("/findAllRescue")
    public BaseResponse<?> findAllRescue(String tokenId){
    	
		BaseResponse<List<RescueCenter>> responseMessage = new BaseResponse<>();
		List<RescueCenter> list=rescueCenterService.findAllRescue();
        if(list==null||list.size()==0){
        	responseMessage.setMsg("查询失败");
        	responseMessage.setStatus(0);
    		return responseMessage;
        }
		responseMessage.setMsg("查询成功");
		responseMessage.setData(list);
		responseMessage.setStatus(1);                                           
		return responseMessage;
    }
}
