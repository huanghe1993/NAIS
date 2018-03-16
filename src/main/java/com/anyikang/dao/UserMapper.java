package com.anyikang.dao;

import java.util.List;
import java.util.Map;

import com.anyikang.model.User;

public interface UserMapper {

	/**
	 * 查询支付用户
	 * @param mobile
	 * @return
	 */
	public User findByPhone(String mobile);

	/**
	 * 添加支付用户
	 * @param appUser
	 * @return
	 */
	public int insertUser(User appUser);

	/**
	 * 验证用户名密码
	 * @param map
	 * @return
	 */
	public List<User> selectByMap(Map<String, Object> map);

	/**
	 * 
	 * @param params
	 * @return
	 */
	public int modifypwById(Map<String, Object> params);

}
