package com.anyikang.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.RescueTeamMapper;
import com.anyikang.model.RescueCenter;
import com.anyikang.service.RescueTeamService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * @author wangwei
 * @date 2017年7月27日
 */
@Service	
public class RescueTeamServiceImpl extends ServiceImpl<RescueTeamMapper, RescueCenter> implements RescueTeamService {

	@Autowired
	private RescueTeamMapper rescueTeamMapper;

	@Override
	public List<String> getAreas(long userId) {
		List<String> areaidList=rescueTeamMapper.getAreas1(userId);
		if(areaidList==null||areaidList.size()==0){
			areaidList=rescueTeamMapper.getAreas2(userId);
			if(areaidList==null||areaidList.size()==0){
				areaidList=rescueTeamMapper.getAreas3(userId);
			}
		}
		return areaidList;
	}

	@Override
	public Map<String, Object> findCenterCode(long userId) {
		Map<String,Object> map = rescueTeamMapper.findCenterCode(userId);
		if(map==null||map.size()==0){
			return null;
		}
		return map;
	}
}
