package com.anyikang.service;

import com.anyikang.model.UserOrder;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface UserOrderService extends IService<UserOrder> {
	
	public Page<UserOrder> selectOrders(Page<UserOrder> page, String id,String orderId);

}
