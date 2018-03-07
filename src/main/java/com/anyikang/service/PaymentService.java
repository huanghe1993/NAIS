package com.anyikang.service;

import java.util.List;
import java.util.Map;

import com.anyikang.model.Payer;

public interface PaymentService{
	
	/**
	 * 根据电话查询用户
	 * @param phone
	 * @return
	 */
	public Payer findByPhone(String phone);
 
	/**
	 * 添加用户
	 * @param appUser
	 * @return
	 */
	public boolean insertPayer(Payer appUser);

	/**
	 * 验证账号密码是否正确
	 * @param map
	 * @return
	 */
	public List<Payer> selectByMap(Map<String, Object> map);

	/**
	 * 修改用户
	 * @param userId
	 * @param newpw
	 * @return
	 */
	public boolean modifypwById(int userId, String newpw);
}
