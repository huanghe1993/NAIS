package com.anyikang.service.impl;

import com.anyikang.dao.AlarmMapper;
import com.anyikang.model.Alarm;
import com.anyikang.model.AlarmCustom;
import com.anyikang.service.AlarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by huanghe on 2017/3/30.
 */
@Service
public class AlarmServicelmp implements AlarmService{

    @Autowired
    private AlarmMapper alarmMapper;
    @Override
    public List<Alarm> findAlarmInfoByDeviceId(Integer deviceId) {
        return alarmMapper.findAlarmInfoByDeviceId(deviceId);
    }

    @Override
    public List<Alarm> findAlarmByDeviceAndDateSection(AlarmCustom alarmCustom) {
        return alarmMapper.findAlarmByDeviceAndDateSection(alarmCustom);
    }
}
