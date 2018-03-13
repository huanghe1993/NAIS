package com.anyikang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.PayMapper;
import com.anyikang.model.Pay;
import com.anyikang.service.PayService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;


@Service
public class PayServiceImpl extends ServiceImpl<PayMapper,Pay> implements PayService {
    @Autowired
    private PayMapper payMapper;
	
	
}
