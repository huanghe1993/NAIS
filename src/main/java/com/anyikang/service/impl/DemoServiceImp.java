package com.anyikang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.anyikang.dao.DemoMapper;
import com.anyikang.model.Demo;
import com.anyikang.service.DemoService;
import com.baomidou.mybatisplus.mapper.SqlHelper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

@Service
public class DemoServiceImp extends ServiceImpl<DemoMapper, Demo> implements DemoService {
	
	private Logger logger = LoggerFactory.getLogger(DemoServiceImp.class);

	@Autowired
	private DemoMapper demoMapper;

	@Override
	@Cacheable(value="getDemos")
	public List<Demo> getDemos() {
		System.err.println("===============无缓存时调用==================");
		Map<String, Object> columnMap=new HashMap<>();
		return demoMapper.selectByMap(columnMap);
	}

	@Override
	@Cacheable(value="getDemoByName",key="#name")
	public Demo getDemoByName(String name) {
		System.err.println("===============无缓存时调用==================");
		Demo demo=new Demo();
		demo.setName(name);
		return demoMapper.selectOne(demo);
	}

	@Override
	@Cacheable(value="getDemoByPassword",key="#demo.password")
	public Demo getDemoByPassword(Demo demo) {
		System.err.println("===============无缓存时调用==================");
		return demoMapper.selectOne(demo);
	}

	@Override
	@CacheEvict(value="getDemos",allEntries=true)
	public boolean addDemo(Demo demo) {
		return SqlHelper.retBool(demoMapper.insert(demo));
	}

	

}
