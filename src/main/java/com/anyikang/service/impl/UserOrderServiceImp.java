package com.anyikang.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.UserOrderMapper;
import com.anyikang.model.PayList;
import com.anyikang.model.PayStatus;
import com.anyikang.model.UserOrder;
import com.anyikang.service.UserOrderService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageInfo;

@Service
public class UserOrderServiceImp extends ServiceImpl<UserOrderMapper, UserOrder> implements UserOrderService {
	
	private Logger logger = LoggerFactory.getLogger(UserOrderServiceImp.class);

	@Autowired
	private UserOrderMapper userOrdersMapper;

	@Override
	public Page<UserOrder> selectOrders(Page<UserOrder> page,String id,String orderId) {
//		page.setRecords(ordersMapper.xxxx(page,id,orderId));
		return page;
	}

	
	@Override
	public List<PageInfo<List<PayStatus>>> queryPayStatus(String deviceIMEI) {
		List<PageInfo<List<PayStatus>>> list =userOrdersMapper.queryPayStatus(deviceIMEI);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	public List<PageInfo<List<PayList>>> queryPayList(String deviceIMEI) {
		List<PageInfo<List<PayList>>> list =userOrdersMapper.queryPayList(deviceIMEI);
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
}
