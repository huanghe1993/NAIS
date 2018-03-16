package com.anyikang.service;

import java.util.List;
import java.util.Map;

import com.anyikang.model.User;

public interface UserService{
	
	/**
	 * 根据电话查询用户
	 * @param phone
	 * @return
	 */
	public User findByPhone(String phone);
 
	/**
	 * 添加用户
	 * @param appUser
	 * @return
	 */
	public boolean insertUser(User appUser);

	/**
	 * 验证账号密码是否正确
	 * @param map
	 * @return
	 */
	public List<User> selectByMap(Map<String, Object> map);

	/**
	 * 修改用户
	 * @param userId
	 * @param newpw
	 * @return
	 */
	public boolean modifypwById(String id, String newpw);
}
