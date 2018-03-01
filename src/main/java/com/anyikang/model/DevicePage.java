package com.anyikang.model;

import java.sql.Timestamp;

/**
 * Created by huanghe on 2017/3/29.
 */
public class DevicePage {
    public String deviceMobile;
    public String locationMode;
    public String timeInterval;
    public String alarmControl;
    public Timestamp deviceCreateTime;

    public String getDeviceMobile() {
        return deviceMobile;
    }

    public void setDeviceMobile(String deviceMobile) {
        this.deviceMobile = deviceMobile;
    }

    public String getLocationMode() {
        return locationMode;
    }

    public void setLocationMode(String locationMode) {
        this.locationMode = locationMode;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public String getAlarmControl() {
        return alarmControl;
    }

    public void setAlarmControl(String alarmControl) {
        this.alarmControl = alarmControl;
    }

    public Timestamp getDeviceCreateTime() {
        return deviceCreateTime;
    }

    public void setDeviceCreateTime(Timestamp deviceCreateTime) {
        this.deviceCreateTime = deviceCreateTime;
    }
}
