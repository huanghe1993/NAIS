package com.anyikang.service;

import java.util.List;

import com.anyikang.model.Demo;
import com.baomidou.mybatisplus.service.IService;

public interface DemoService extends IService<Demo> {

	public List<Demo> getDemos();

	public Demo getDemoByName(String name);

	public Demo getDemoByPassword(Demo demo);

	public boolean addDemo(Demo demo);

}
