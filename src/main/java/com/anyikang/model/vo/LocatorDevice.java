package com.anyikang.model.vo;

import java.sql.Timestamp;

/**
 * 紧急救助定位器设备实体类
 * @author LvXiaoxiong 2017/06/29
 *
 */
public class LocatorDevice {
   
	private int deviceId;//id
	private String deviceImeiCode;//设备号
	private String deviceUser;//设备使用者
    public String deviceMobile;//设备手机号
    public int locationMode;//定位方式
    public int timeInterval;//定位间隔                                                                                                                                                           
    public Timestamp onlineTime;
    public Timestamp deviceCreateTime;//设备创建时间
    
    public LocatorDevice(){
    	
    }

	public LocatorDevice(int deviceId, String deviceImeiCode, String deviceUser, String deviceMobile, int locationMode,
			int timeInterval,Timestamp onlineTime, Timestamp deviceCreateTime) {
		super();
		this.deviceId = deviceId;
		this.deviceImeiCode = deviceImeiCode;
		this.deviceUser = deviceUser;
		this.deviceMobile = deviceMobile;
		this.locationMode = locationMode;
		this.timeInterval = timeInterval;
		this.onlineTime = onlineTime;
		this.deviceCreateTime = deviceCreateTime;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getDeviceImeiCode() {
		return deviceImeiCode;
	}

	public void setDeviceImeiCode(String deviceImeiCode) {
		this.deviceImeiCode = deviceImeiCode;
	}

	public String getDeviceUser() {
		return deviceUser;
	}

	public void setDeviceUser(String deviceUser) {
		this.deviceUser = deviceUser;
	}

	public String getDeviceMobile() {
		return deviceMobile;
	}

	public void setDeviceMobile(String deviceMobile) {
		this.deviceMobile = deviceMobile;
	}

	public int getLocationMode() {
		return locationMode;
	}

	public void setLocationMode(int locationMode) {
		this.locationMode = locationMode;
	}

	public int getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval) {
		this.timeInterval = timeInterval;
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
		result = prime * result + deviceId;
		result = prime * result + ((deviceImeiCode == null) ? 0 : deviceImeiCode.hashCode());
		result = prime * result + ((deviceMobile == null) ? 0 : deviceMobile.hashCode());
		result = prime * result + ((deviceUser == null) ? 0 : deviceUser.hashCode());
		result = prime * result + locationMode;
		result = prime * result + ((onlineTime == null) ? 0 : onlineTime.hashCode());
		result = prime * result + timeInterval;
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
		LocatorDevice other = (LocatorDevice) obj;
		if (deviceCreateTime == null) {
			if (other.deviceCreateTime != null)
				return false;
		} else if (!deviceCreateTime.equals(other.deviceCreateTime))
			return false;
		if (deviceId != other.deviceId)
			return false;
		if (deviceImeiCode == null) {
			if (other.deviceImeiCode != null)
				return false;
		} else if (!deviceImeiCode.equals(other.deviceImeiCode))
			return false;
		if (deviceMobile == null) {
			if (other.deviceMobile != null)
				return false;
		} else if (!deviceMobile.equals(other.deviceMobile))
			return false;
		if (deviceUser == null) {
			if (other.deviceUser != null)
				return false;
		} else if (!deviceUser.equals(other.deviceUser))
			return false;
		if (locationMode != other.locationMode)
			return false;
		if (onlineTime == null) {
			if (other.onlineTime != null)
				return false;
		}else if (!onlineTime.equals(other.onlineTime))
			return false;
		if (timeInterval != other.timeInterval)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocatorDevice [deviceId=" + deviceId + ", deviceImeiCode=" + deviceImeiCode + ", deviceUser="
				+ deviceUser + ", deviceMobile=" + deviceMobile + ", locationMode=" + locationMode + ", timeInterval="
				+ timeInterval + ", onlineTime=" + onlineTime + ", deviceCreateTime=" + deviceCreateTime + "]";
	}
    
    
}
