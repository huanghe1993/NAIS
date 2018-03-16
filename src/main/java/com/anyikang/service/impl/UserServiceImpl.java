package com.anyikang.service.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.UserMapper;
import com.anyikang.model.User;
import com.anyikang.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findByPhone(String mobile) {
		return userMapper.findByPhone(mobile);
	}

	@Override
	public boolean insertUser(User appUser) {
		int n =userMapper.insertUser(appUser);
		return n==1;
	}

	@Override
	public List<User> selectByMap(Map<String, Object> map) {
		List<User> list =userMapper.selectByMap(map);
		if(list==null||list.size()==0){
			return null;
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.PaymentService#modifypwById(int, java.lang.String)
	 */
	@Override
	public boolean modifypwById(String id, String newpw) {
		Map<String,Object> params = new HashMap<>();
		params.put("id", id);
		params.put("newpw", newpw);
		int n =userMapper.modifypwById(params);
		return n==1;
	}

}
