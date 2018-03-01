package com.anyikang.service;

import java.util.List;
import java.util.Map;

import com.anyikang.model.RescueCenter;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author wangwei
 * @date 2017年7月27日
 */
public interface RescueTeamService extends IService<RescueCenter> {
	
	public List<String> getAreas(long userId);

	public Map<String, Object> findCenterCode(long userId);

}
