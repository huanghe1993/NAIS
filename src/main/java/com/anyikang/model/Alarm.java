package com.anyikang.model;

import java.sql.Timestamp;

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
    public Timestamp alarmTime;
    public String regionNumber;//报警地区编码

    public Alarm() {
       
    }

	public Alarm(String alarmId, String locationId, int alarmType, int rescueType, int alarmPower, Timestamp alarmTime,
			String regionNumber) {
		super();
		this.alarmId = alarmId;
		this.locationId = locationId;
		this.alarmType = alarmType;
		this.rescueType = rescueType;
		this.alarmPower = alarmPower;
		this.alarmTime = alarmTime;
		this.regionNumber = regionNumber;
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

	public Timestamp getAlarmTime() {
		return alarmTime;
	}

	public void setAlarmTime(Timestamp alarmTime) {
		this.alarmTime = alarmTime;
	}

	public String getRegionNumber() {
		return regionNumber;
	}

	public void setRegionNumber(String regionNumber) {
		this.regionNumber = regionNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alarmId == null) ? 0 : alarmId.hashCode());
		result = prime * result + alarmPower;
		result = prime * result + ((alarmTime == null) ? 0 : alarmTime.hashCode());
		result = prime * result + alarmType;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + ((regionNumber == null) ? 0 : regionNumber.hashCode());
		result = prime * result + rescueType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alarm other = (Alarm) obj;
		if (alarmId == null) {
			if (other.alarmId != null)
				return false;
		} else if (!alarmId.equals(other.alarmId))
			return false;
		if (alarmPower != other.alarmPower)
			return false;
		if (alarmTime == null) {
			if (other.alarmTime != null)
				return false;
		} else if (!alarmTime.equals(other.alarmTime))
			return false;
		if (alarmType != other.alarmType)
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (regionNumber == null) {
			if (other.regionNumber != null)
				return false;
		} else if (!regionNumber.equals(other.regionNumber))
			return false;
		if (rescueType != other.rescueType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alarm [alarmId=" + alarmId + ", locationId=" + locationId + ", alarmType=" + alarmType + ", rescueType="
				+ rescueType + ", alarmPower=" + alarmPower + ", alarmTime=" + alarmTime + ", regionNumber="
				+ regionNumber + "]";
	}

	
	
	
	
}
