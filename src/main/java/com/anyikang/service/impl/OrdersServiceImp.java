package com.anyikang.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.OrdersMapper;
import com.anyikang.model.Orders;
import com.anyikang.service.OrdersService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class OrdersServiceImp extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {
	
	private Logger logger = LoggerFactory.getLogger(OrdersServiceImp.class);

	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public Page<Orders> selectOrders(Page<Orders> page,String id,String orderId) {
//		page.setRecords(ordersMapper.xxxx(page,id,orderId));
		return page;
	}

}
