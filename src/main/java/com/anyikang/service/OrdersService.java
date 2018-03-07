package com.anyikang.service;

import com.anyikang.model.Orders;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

public interface OrdersService extends IService<Orders> {
	
	public Page<Orders> selectOrders(Page<Orders> page, String id,String orderId);

}
