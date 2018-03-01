package com.anyikang;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.anyikang.model.Demo;
import com.anyikang.service.DemoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private DemoService demoService;

	/**
	 * 缓存测试
	 */
	@Test
	public void test1() {
		List<Demo> demoList = demoService.getDemos();
		if (!CollectionUtils.isEmpty(demoList)) {
			System.err.println("==================size:" + demoList.size());
		} else {
			System.err.println("========无数据========");
		}
	}
	
	@Test
	public void test2() {
		Demo demo = demoService.getDemoByName("111");
		if (demo!=null) {
			System.err.println("==================id:"+demo.getId()+"======name:" + demo.getName());
		} else {
			System.err.println("========无数据========");
		}
	}
	
	@Test
	public void test3() {
		Demo demo = new Demo();
		demo.setPassword("1111");
		demo = demoService.getDemoByPassword(demo);
		if (demo!=null) {
			System.err.println("==================id:"+demo.getId()+"======name:" + demo.getName());
		} else {
			System.err.println("========无数据========");
		}
	}
	
	@Test
	public void test4() {
		Demo demo = new Demo();
		demo.setName("lisi");
		demo.setPassword("123456");
		boolean isTrue=demoService.addDemo(demo);
		if (isTrue) {
			System.err.println("==================id:"+demo.getId()+"======name:" + demo.getName());
		} else {
			System.err.println("========无数据========");
		}
	}

}
