package com.anyikang.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anyikang/app1")
@EnableAutoConfiguration
public class TestController {

	private static List<Map<String, Object>> heroes = new ArrayList<>();

	static {
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<>();
			map.put("id", 133);
			map.put("name", "Mr. " + i);
			heroes.add(map);
		}
	}

	@RequestMapping(value = "", method = { RequestMethod.GET },produces = "application/json")
	@RequiresPermissions("test:select")
	public Map<String, Object> heroesGet() {
		Map<String, Object> map = new HashMap<>();
		map.put("heroes", heroes);

		System.err.println(heroes.size()+"=====================================");

		return map;
	}
	
	@RequestMapping(value = "/{id}", method = { RequestMethod.GET },produces = "application/json")
	@ResponseBody
	private Map<String, Object> heroeGet(@PathVariable int id) {
		Map<String, Object> heroe=null;
		for (int i = 0; i < heroes.size(); i++) {
			Map<String, Object> map =heroes.get(i);
			int cid= (int) map.get("id");
			if(cid==id){
				heroe=map;
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("heroe", heroe);
		
		System.err.println(heroes.size()+"=====================================");
		
		return map;
	}

	@RequestMapping(value = "", method = { RequestMethod.POST }, produces = "application/json")
	@ResponseBody
	private Map<String, Object> heroePost(@RequestBody Map<String,Object> pas) {
		String name=(String) pas.get("name");
		Map<String, Object> heroe = new HashMap<>();
		int lastId=(int) heroes.get(heroes.size()-1).get("id");
		heroe.put("id", lastId++);
		heroe.put("name", name);
		heroes.add(heroe);

		Map<String, Object> map = new HashMap<>();
		map.put("heroe", heroe);

		System.err.println(heroes.size()+"=====================================");

		return map;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT }, produces = "application/json")
	@ResponseBody
	private Map<String, Object> heroePut(@PathVariable int id,@RequestBody Map<String,Object> pas) {
		String name=(String) pas.get("name");
		for (int i = 0; i < heroes.size(); i++) {
			Map<String, Object> map =heroes.get(i);
			int cid= (int) map.get("id");
			if(cid==id){
				map.put("name", name);
			}
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("heroes", heroes);

		System.err.println(heroes.size()+"=====================================");

		return map;
	}

	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE }, produces = "application/json")
	@ResponseBody
	private Map<String, Object> heroeDel(@PathVariable int id) {
		for (int i = 0; i < heroes.size(); i++) {
			Map<String, Object> map =heroes.get(i);
			int cid= (int) map.get("id");
			if(cid==id){
				heroes.remove(i);
			}
		}

		Map<String, Object> map = new HashMap<>();
		map.put("heroes", heroes);

		System.err.println(heroes.size()+"=====================================");

		return map;
	}
	

}
