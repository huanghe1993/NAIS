package com.anyikang.service;

import com.anyikang.model.Alarm;
import com.anyikang.model.AlarmCustom;

import java.util.List;

/**
 * Created by huanghe on 2017/3/30.
 */
public interface AlarmService {
    //根据设备的id查询出设备的电量和时间戳
    public List<Alarm> findAlarmInfoByDeviceId(Integer deviceId);

    //根据设备的id,报警的类型，起始的时间，终止的时间（包装类AlarmCustom)查询报警信息
    public List<Alarm> findAlarmByDeviceAndDateSection(AlarmCustom alarmCustom);

}
