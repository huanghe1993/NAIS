package com.anyikang.model.vo;

import java.sql.Timestamp;

/**
 * 
 * @author wangwei
 * @date 2017年6月15日
 */
public class AlarmVO {

	private String deviceIMEI;
	private String alarmId; // alarmId的数据类型
	private int deviceId;
	private int alarmType;
	private int alarmIocationType;
	private float alarmLongitude;
	private float alarmLatitude;
	private int alarmPower;
	private Timestamp alarmTime;

	public String getDeviceIMEI() {
		return deviceIMEI;
	}

	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getAlarmType() {
		return alarmType;
	}

	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}

	public int getAlarmIocationType() {
		return alarmIocationType;
	}

	public void setAlarmIocationType(int alarmIocationType) {
		this.alarmIocationType = alarmIocationType;
	}

	public float getAlarmLongitude() {
		return alarmLongitude;
	}

	public void setAlarmLongitude(float alarmLongitude) {
		this.alarmLongitude = alarmLongitude;
	}

	public float getAlarmLatitude() {
		return alarmLatitude;
	}

	public void setAlarmLatitude(float alarmLatitude) {
		this.alarmLatitude = alarmLatitude;
	}

	public int getAlarmPower() {
		return alarmPower;
	}

	public void setAlarmPower(int alarmPower) {
		this.alarmPower = alarmPower;
	}

	public Timestamp getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Timestamp alarmTime) {
		this.alarmTime = alarmTime;
	}

}
