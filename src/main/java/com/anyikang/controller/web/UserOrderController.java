package com.anyikang.controller.web;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.PayList;
import com.anyikang.model.PayStatus;
import com.anyikang.model.UserOrder;
import com.anyikang.service.UserOrderService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;

/**
 * @author wangwei
 * @date 2018年3月7日
 */
@RestController
@RequestMapping("web/userOrder")
public class UserOrderController extends BaseController {
	
    @Autowired
    private UserOrderService userOrderService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public BaseResponse<?> list(@RequestParam(required=true)int pageNum,@RequestParam(required=true)int pageSize){
    	
    	BaseResponse<Page<UserOrder>>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
		
		EntityWrapper<UserOrder> entityWrapper = new EntityWrapper<UserOrder>();
		Page<UserOrder> page =userOrderService.selectPage(new Page<UserOrder>(pageNum, pageSize), entityWrapper);
		if(page!=null){
			baseResponse.setData(page);
			baseResponse.setMsg("查询成功");
			baseResponse.setStatus(1);
			return baseResponse;
	   
		}
		baseResponse.setMsg("查询失败,无数据");
		baseResponse.setStatus(0);
		return baseResponse;
    }
    
    @RequestMapping(value = "/{id}", method = {RequestMethod.GET})
    public BaseResponse<?> view(@PathVariable("id") String id){
    	
    	BaseResponse<UserOrder>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
    	
    	UserOrder userOrder=userOrderService.selectById(id);
    	
    	if(userOrder!=null){
    		baseResponse.setData(userOrder);
        	baseResponse.setMsg("查询成功");
        	baseResponse.setStatus(1);
        	return baseResponse;
    	}
    	baseResponse.setMsg("查询失败,无数据");
		baseResponse.setStatus(0);
		return baseResponse;
    }
	
 	@RequestMapping(value ="/add", method = RequestMethod.POST)
 	public BaseResponse<?> add(UserOrder userOrder) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
 		
        boolean flags = userOrderService.insert(userOrder);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("创建成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("创建失败");
		return baseResponse;
	}

 	@RequestMapping(value ="/update", method = RequestMethod.PUT)
 	public BaseResponse<?> update(UserOrder userOrder) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
        
 		userOrder.setCreateTime(new Date());
 		
		boolean  flags=userOrderService.updateById(userOrder);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("更新成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("更新失败");
		return baseResponse;
	}

    @RequestMapping(value = "/delete/{id}", method = {RequestMethod.DELETE})
    public BaseResponse<?> delete(@PathVariable int id){
    	
    	BaseResponse<String>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
    	boolean  flags =userOrderService.deleteById(id);
    	if(flags){
			 baseResponse.setMsg("删除成功");
		     baseResponse.setStatus(1);
		     return baseResponse;
    	}
		baseResponse.setMsg("删除失败");
		baseResponse.setStatus(0);
		return baseResponse;
    }
    
 	@RequestMapping(value ="/deletes", method = RequestMethod.POST)
 	public BaseResponse<?> deletes(String[] ids) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
 		
 		List<String> idList = Arrays.asList(ids);
		boolean  flags=userOrderService.deleteBatchIds(idList);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("批量删除成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("批量删除失败");
		return baseResponse;
	}


 	/**
 	 * 查询缴费状态
 	 * @param pageSize
 	 * @param pageIndex
 	 * @param deviceIMEI
 	 * @return
 	 */
 	@RequestMapping(value = "/queryPayStatus", method = {RequestMethod.GET})
    public BaseResponse<?> queryPayStatus(int pageSize,int pageIndex, @RequestParam(required=false) String deviceIMEI){
    	BaseResponse<PageInfo<List<PayStatus>>>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
    	PageMethod.startPage(pageIndex, pageSize);
    	@SuppressWarnings("unchecked")
		PageInfo<List<PayStatus>>  pageInfo =page(userOrderService.queryPayStatus(deviceIMEI));
    	if(pageInfo!=null&&pageInfo.getList().size()>0){
			 baseResponse.setMsg("查询成功");
		     baseResponse.setStatus(1);
		     baseResponse.setData(pageInfo);
		     return baseResponse;
    	}
		baseResponse.setMsg("查询失败");
		baseResponse.setStatus(0);
		return baseResponse;
    }
	 
	 /**
	  * 查询缴费记录
	  * @param pageSize
	  * @param pageIndex
	  * @param deviceIMEI
	  * @return
	  */
    @RequestMapping(value = "/queryPayList", method = {RequestMethod.GET})
    public BaseResponse<?> queryPayList(int pageSize,int pageIndex, @RequestParam(required=false) String deviceIMEI){
	   	BaseResponse<PageInfo<List<PayList>>>  baseResponse = new BaseResponse<>();
	   	baseResponse.setTime(System.currentTimeMillis());
	   	PageMethod.startPage(pageIndex, pageSize);
	   	@SuppressWarnings("unchecked")
			PageInfo<List<PayList>>  pageInfo =page(userOrderService.queryPayList(deviceIMEI));
	   	if(pageInfo!=null&&pageInfo.getList().size()>0){
				 baseResponse.setMsg("查询成功");
			     baseResponse.setStatus(1);
			     baseResponse.setData(pageInfo);
			     return baseResponse;
	   	}
			baseResponse.setMsg("查询失败");
			baseResponse.setStatus(0);
			return baseResponse;
	   }
  

}
