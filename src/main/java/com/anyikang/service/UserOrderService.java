package com.anyikang.service;

import java.util.List;

import com.anyikang.model.PayList;
import com.anyikang.model.PayStatus;
import com.anyikang.model.UserOrder;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

public interface UserOrderService extends IService<UserOrder> {
	
	public Page<UserOrder> selectOrders(Page<UserOrder> page, String id,String orderId);
	
	public List<PageInfo<List<PayStatus>>> queryPayStatus(String deviceIMEI);

	public List<PageInfo<List<PayList>>> queryPayList(String deviceIMEI);

}
