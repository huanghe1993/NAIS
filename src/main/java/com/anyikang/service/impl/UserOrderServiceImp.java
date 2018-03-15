package com.anyikang.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.UserOrderMapper;
import com.anyikang.model.UserOrder;
import com.anyikang.service.UserOrderService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class UserOrderServiceImp extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
	
	private Logger logger = LoggerFactory.getLogger(UserOrderServiceImp.class);

	@Autowired
	private UserOrderMapper ordersMapper;

	@Override
	public Page<UserOrder> selectOrders(Page<UserOrder> page,String id,String orderId) {
//		page.setRecords(ordersMapper.xxxx(page,id,orderId));
		return page;
	}

}
