package com.anyikang.model.vo;

import java.sql.Timestamp;

/**
 * 定位器实体类
 * @author lvXiaoxiong
 * @date  2017/07/13
 *
 */
public class RescueDevice {

    public int deviceId; 
    public int deviceType;
    public String deviceIMEI;
    public String deviceName;
    public String deviceModel;
    public float deviceVersion;
    public String deviceMobile;
    public int locationMode;
    public int timeInterval;
    public int devicePower;
    public String deviceStatus;
    public Timestamp onlineTime;
    public Timestamp deviceCreateTime;
    public int deviceOwnerID;

    
    public RescueDevice(){
    	
    }


	public RescueDevice(int deviceId, int deviceType, String deviceIMEI, String deviceName, String deviceModel,
			float deviceVersion, String deviceMobile, int locationMode, int timeInterval, int devicePower,
			String deviceStatus, Timestamp onlineTime, Timestamp deviceCreateTime, int deviceOwnerID) {
		super();
		this.deviceId = deviceId;
		this.deviceType = deviceType;
		this.deviceIMEI = deviceIMEI;
		this.deviceName = deviceName;
		this.deviceModel = deviceModel;
		this.deviceVersion = deviceVersion;
		this.deviceMobile = deviceMobile;
		this.locationMode = locationMode;
		this.timeInterval = timeInterval;
		this.devicePower = devicePower;
		this.deviceStatus = deviceStatus;
		this.onlineTime = onlineTime;
		this.deviceCreateTime = deviceCreateTime;
		this.deviceOwnerID = deviceOwnerID;
	}


	public int getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}


	public int getDeviceType() {
		return deviceType;
	}


	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
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


	public String getDeviceModel() {
		return deviceModel;
	}


	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}


	public float getDeviceVersion() {
		return deviceVersion;
	}


	public void setDeviceVersion(float deviceVersion) {
		this.deviceVersion = deviceVersion;
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


	public int getDevicePower() {
		return devicePower;
	}


	public void setDevicePower(int devicePower) {
		this.devicePower = devicePower;
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


	public int getDeviceOwnerID() {
		return deviceOwnerID;
	}


	public void setDeviceOwnerID(int deviceOwnerID) {
		this.deviceOwnerID = deviceOwnerID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceCreateTime == null) ? 0 : deviceCreateTime.hashCode());
		result = prime * result + ((deviceIMEI == null) ? 0 : deviceIMEI.hashCode());
		result = prime * result + deviceId;
		result = prime * result + ((deviceMobile == null) ? 0 : deviceMobile.hashCode());
		result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
		result = prime * result + ((deviceName == null) ? 0 : deviceName.hashCode());
		result = prime * result + deviceOwnerID;
		result = prime * result + devicePower;
		result = prime * result + ((deviceStatus == null) ? 0 : deviceStatus.hashCode());
		result = prime * result + deviceType;
		result = prime * result + Float.floatToIntBits(deviceVersion);
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
		RescueDevice other = (RescueDevice) obj;
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
		if (deviceModel == null) {
			if (other.deviceModel != null)
				return false;
		} else if (!deviceModel.equals(other.deviceModel))
			return false;
		if (deviceName == null) {
			if (other.deviceName != null)
				return false;
		} else if (!deviceName.equals(other.deviceName))
			return false;
		if (deviceOwnerID != other.deviceOwnerID)
			return false;
		if (devicePower != other.devicePower)
			return false;
		if (deviceStatus == null) {
			if (other.deviceStatus != null)
				return false;
		} else if (!deviceStatus.equals(other.deviceStatus))
			return false;
		if (deviceType != other.deviceType)
			return false;
		if (Float.floatToIntBits(deviceVersion) != Float.floatToIntBits(other.deviceVersion))
			return false;
		if (locationMode != other.locationMode)
			return false;
		if (onlineTime == null) {
			if (other.onlineTime != null)
				return false;
		} else if (!onlineTime.equals(other.onlineTime))
			return false;
		if (timeInterval != other.timeInterval)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "RescueDevice [deviceId=" + deviceId + ", deviceType=" + deviceType + ", deviceIMEI=" + deviceIMEI
				+ ", deviceName=" + deviceName + ", deviceModel=" + deviceModel + ", deviceVersion=" + deviceVersion
				+ ", deviceMobile=" + deviceMobile + ", locationMode=" + locationMode + ", timeInterval=" + timeInterval
				+ ", devicePower=" + devicePower + ", deviceStatus=" + deviceStatus + ", onlineTime=" + onlineTime
				+ ", deviceCreateTime=" + deviceCreateTime + ", deviceOwnerID=" + deviceOwnerID + "]";
	}

    
	
    
  
}
