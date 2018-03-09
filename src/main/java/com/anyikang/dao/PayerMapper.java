package com.anyikang.dao;

import java.util.List;
import java.util.Map;

import com.anyikang.model.Payer;

public interface PayerMapper {

	/**
	 * 查询支付用户
	 * @param mobile
	 * @return
	 */
	public Payer findByPhone(String mobile);

	/**
	 * 添加支付用户
	 * @param appUser
	 * @return
	 */
	public int insertPayer(Payer appUser);

	/**
	 * 验证用户名密码
	 * @param map
	 * @return
	 */
	public List<Payer> selectByMap(Map<String, Object> map);

	/**
	 * 
	 * @param params
	 * @return
	 */
	public int modifypwById(Map<String, Object> params);

}
