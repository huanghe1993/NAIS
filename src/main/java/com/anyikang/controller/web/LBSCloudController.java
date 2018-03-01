/**
 * 
 */
package com.anyikang.controller.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anyikang.utils.LBSCloudAPIUtil;

/**
 * @author wangwei
 * @date 2017年7月28日
 */
@RestController
@RequestMapping(value = "/web/lbs/")
public class LBSCloudController {

	/**
	 * 添加
	 * 
	 * @param lat
	 * @param lng
	 * @param coordType
	 * @param tags
	 * @return
	 */
	@PostMapping("/create")
	public String add(float lat, float lng, int coordType, String tags) {
		return LBSCloudAPIUtil.create(lat, lng, coordType, tags);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@PostMapping("/delete")
	public String delete() {
		return LBSCloudAPIUtil.delete();
	}

}
