package com.anyikang.dao;

import java.util.List;

import com.anyikang.model.PayList;
import com.anyikang.model.PayStatus;
import com.anyikang.model.UserOrder;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.github.pagehelper.PageInfo;

public interface UserOrderMapper extends BaseMapper<UserOrder> {
	/**
	 * 查询设备佩戴者服务时间情况
	 * @param oldManId
	 * @return
	 */
	List<PageInfo<List<PayStatus>>> queryPayStatus(String deviceIMEI);

	/**
	 * 查询缴费记录
	 * @param deviceIMEI
	 * @return
	 */
	List<PageInfo<List<PayList>>> queryPayList(String deviceIMEI);
	
}
