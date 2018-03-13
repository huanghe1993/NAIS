package com.anyikang.service.impl;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.PayerMapper;
import com.anyikang.model.Payer;
import com.anyikang.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PayerMapper payerMapper;
	
	@Override
	public Payer findByPhone(String mobile) {
		return payerMapper.findByPhone(mobile);
	}

	@Override
	public boolean insertPayer(Payer appUser) {
		int n =payerMapper.insertPayer(appUser);
		return n==1;
	}

	@Override
	public List<Payer> selectByMap(Map<String, Object> map) {
		List<Payer> list =payerMapper.selectByMap(map);
		if(list==null||list.size()==0){
			return null;
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.anyikang.service.PaymentService#modifypwById(int, java.lang.String)
	 */
	@Override
	public boolean modifypwById(int userId, String newpw) {
		Map<String,Object> params = new HashMap<>();
		params.put("userId", userId);
		params.put("newpw", newpw);
		int n =payerMapper.modifypwById(params);
		return n==1;
	}

}
