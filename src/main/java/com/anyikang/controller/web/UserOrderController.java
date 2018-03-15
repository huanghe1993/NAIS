package com.anyikang.controller.web;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.base.BaseController;
import com.anyikang.base.BaseResponse;
import com.anyikang.model.UserOrder;
import com.anyikang.service.UserOrderService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;

/**
 * @author wangwei
 * @date 2018年3月7日
 */
@RestController
@RequestMapping("web/orders")
public class UserOrderController extends BaseController {
	
    @Autowired
    private UserOrderService ordersService;

    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    public BaseResponse<?> list(int pageNum,int pageSize){
    	
    	BaseResponse<Page<UserOrder>>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
		
		EntityWrapper<UserOrder> entityWrapper = new EntityWrapper<UserOrder>();
		Page<UserOrder> page =ordersService.selectPage(new Page<UserOrder>(pageNum, pageSize), entityWrapper);
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
    
    @RequestMapping(value = "/{ordersId}", method = {RequestMethod.GET})
    public BaseResponse<?> view(@PathVariable("ordersId") String ordersId){
    	
    	BaseResponse<UserOrder>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
    	
    	UserOrder orders=ordersService.selectById(ordersId);
    	
    	if(orders!=null){
    		baseResponse.setData(orders);
        	baseResponse.setMsg("查询成功");
        	baseResponse.setStatus(1);
        	return baseResponse;
    	}
    	baseResponse.setMsg("查询失败,无数据");
		baseResponse.setStatus(0);
		return baseResponse;
    }
	
 	@RequestMapping(value ="/add", method = RequestMethod.POST)
 	public BaseResponse<?> add(UserOrder orders) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
 		
        boolean flags = ordersService.insert(orders);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("创建成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("创建失败");
		return baseResponse;
	}

 	@RequestMapping(value ="/updateById", method = RequestMethod.POST)
 	public BaseResponse<?> updateById(UserOrder orders) {
 		BaseResponse<String> baseResponse = new BaseResponse<>();
 		baseResponse.setTime(System.currentTimeMillis());
        
 		orders.setCreateTime(new Date());
 		
		boolean  flags=ordersService.updateById(orders);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("更新成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("更新失败");
		return baseResponse;
	}

    @RequestMapping(value = "/delete/{ordersId}", method = {RequestMethod.GET})
    public BaseResponse<?> delete(@PathVariable int ordersId){
    	
    	BaseResponse<String>  baseResponse = new BaseResponse<>();
    	baseResponse.setTime(System.currentTimeMillis());
    	boolean  flags =ordersService.deleteById(ordersId);
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
		boolean  flags=ordersService.deleteBatchIds(idList);
		if(flags){
			baseResponse.setStatus(1);
			baseResponse.setMsg("批量删除成功");
			return baseResponse;
		}
		baseResponse.setStatus(0);
		baseResponse.setMsg("批量删除失败");
		return baseResponse;
	}


  

}
