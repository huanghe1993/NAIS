package com.anyikang.model;

import java.sql.Timestamp;

/**
 * Created by huanghe on 2017/3/24.
 */
public class Device {

    public int deviceId;
    public String deviceIMEI;
    public String deviceName;
    public String deviceMobile;
    public String deviceStatus;
    public Timestamp onlineTime;
    public Timestamp deviceCreateTime;
    
    public Device(){
    	
    }

	public Device(int deviceId, String deviceIMEI, String deviceName, String deviceMobile, String deviceStatus,
			Timestamp onlineTime, Timestamp deviceCreateTime) {
		super();
		this.deviceId = deviceId;
		this.deviceIMEI = deviceIMEI;
		this.deviceName = deviceName;
		this.deviceMobile = deviceMobile;
		this.deviceStatus = deviceStatus;
		this.onlineTime = onlineTime;
		this.deviceCreateTime = deviceCreateTime;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceIMEI() {
		return deviceIMEI;
	}

	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getDeviceMobile() {
		return deviceMobile;
	}

	public void setDeviceMobile(String deviceMobile) {
		this.deviceMobile = deviceMobile;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public Timestamp getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(Timestamp onlineTime) {
		this.onlineTime = onlineTime;
	}

	public Timestamp getDeviceCreateTime() {
		return deviceCreateTime;
	}

	public void setDeviceCreateTime(Timestamp deviceCreateTime) {
		this.deviceCreateTime = deviceCreateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceCreateTime == null) ? 0 : deviceCreateTime.hashCode());
		result = prime * result + ((deviceIMEI == null) ? 0 : deviceIMEI.hashCode());
		result = prime * result + deviceId;
		result = prime * result + ((deviceMobile == null) ? 0 : deviceMobile.hashCode());
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + ((deviceStatus == null) ? 0 : deviceStatus.hashCode());
		result = prime * result + ((onlineTime == null) ? 0 : onlineTime.hashCode());
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
		Device other = (Device) obj;
		if (deviceCreateTime == null) {
			if (other.deviceCreateTime != null)
				return false;
		} else if (!deviceCreateTime.equals(other.deviceCreateTime))
			return false;
		if (deviceIMEI == null) {
			if (other.deviceIMEI != null)
				return false;
		} else if (!deviceIMEI.equals(other.deviceIMEI))
			return false;
		if (deviceId != other.deviceId)
			return false;
		if (deviceMobile == null) {
			if (other.deviceMobile != null)
				return false;
		} else if (!deviceMobile.equals(other.deviceMobile))
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (deviceStatus == null) {
			if (other.deviceStatus != null)
				return false;
		} else if (!deviceStatus.equals(other.deviceStatus))
			return false;
		if (onlineTime == null) {
			if (other.onlineTime != null)
				return false;
		} else if (!onlineTime.equals(other.onlineTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Device [deviceId=" + deviceId + ", deviceIMEI=" + deviceIMEI + ", deviceName=" + deviceName
				+ ", deviceMobile=" + deviceMobile + ", deviceStatus=" + deviceStatus + ", onlineTime=" + onlineTime
				+ ", deviceCreateTime=" + deviceCreateTime + "]";
	}
    
  
}
