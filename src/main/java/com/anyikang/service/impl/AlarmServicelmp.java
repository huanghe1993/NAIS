package com.anyikang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.AlarmMapper;
import com.anyikang.service.AlarmService;

/**
 * 
 * @author LvXiaoxiong
 * @date 2018/03/09
 *
 */
@Service
public class AlarmServicelmp implements AlarmService{

    @Autowired
    private AlarmMapper alarmMapper;
	@Override
	public List<Map<String, Object>> getAllSos() {
		List<Map<String, Object>> list =alarmMapper.getAllSos();
		if(list!=null&&list.size()>0){
			return list;
		}
		return null;
	}
	@Override
	public boolean updateIsCall(String alarmId) {
		int n =alarmMapper.updateRscueType(alarmId);
		return n==1;
	}
}
