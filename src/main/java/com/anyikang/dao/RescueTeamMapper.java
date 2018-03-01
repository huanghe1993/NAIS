package com.anyikang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.anyikang.model.RescueCenter;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * @author wangwei
 * @date 2017年7月27日
 */
public interface RescueTeamMapper extends BaseMapper<RescueCenter> {
	List<String> getAreas1(@Param("userId")long userId);
	List<String> getAreas2(@Param("userId")long userId);
	List<String> getAreas3(@Param("userId")long userId);
	List<String> getAreas4(@Param("userId")long userId);
	Map<String, Object> findCenterCode(@Param("userId")long userId);
}
