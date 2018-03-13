package com.anyikang.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 报警信息实体类
 * @author LvXiaoxiong
 * @date 2017/07/31
 *
 */
public class Alarm {
    public String alarmId; //alarmId的数据类型
    public String locationId;
    public int alarmType;
    public int rescueType;
    public int alarmPower;
    public Date alarmTime;
    public String alarmAddr;
    public int isCall;//是否给家属打电话

    public Alarm() {
       
    }

	public Alarm(String alarmId, String locationId, int alarmType, int rescueType, int alarmPower, Date alarmTime,
			String alarmAddr, int isCall) {
		super();
		this.alarmId = alarmId;
		this.locationId = locationId;
		this.alarmType = alarmType;
		this.rescueType = rescueType;
		this.alarmPower = alarmPower;
		this.alarmTime = alarmTime;
		this.alarmAddr = alarmAddr;
		this.isCall = isCall;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public int getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}

	public int getRescueType() {
		return rescueType;
	}

	public void setRescueType(int rescueType) {
		this.rescueType = rescueType;
	}

	public int getAlarmPower() {
		return alarmPower;
	}

	public void setAlarmPower(int alarmPower) {
		this.alarmPower = alarmPower;
	}

	public Date getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Date alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getAlarmAddr() {
		return alarmAddr;
	}

	public void setAlarmAddr(String alarmAddr) {
		this.alarmAddr = alarmAddr;
	}

	public int getIsCall() {
		return isCall;
	}

	public void setIsCall(int isCall) {
		this.isCall = isCall;
	}

	
	
	
	
}
