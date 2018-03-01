package com.anyikang.model.vo;

/**
 * 紧急救援系统设备状态实体类
 * @author LvXiaoXiong
 * @date 2017/07/18
 *
 */
public class LocatorDeviceStatus {

	private String  deviceIMEI;
    private String  deviceStatus;
    private String  deviceMobile;
    private int     locationPower;
    private String  onlineTime;
    
    public LocatorDeviceStatus(){
    	
    }

	public LocatorDeviceStatus(String deviceIMEI, String deviceStatus, String deviceMobile, int locationPower,
			String onlineTime) {
		super();
		this.deviceIMEI = deviceIMEI;
		this.deviceStatus = deviceStatus;
		this.deviceMobile = deviceMobile;
		this.locationPower = locationPower;
		this.onlineTime = onlineTime;
	}

	public String getDeviceIMEI() {
		return deviceIMEI;
	}

	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}

	public String getDeviceStatus() {
		return deviceStatus;
	}

	public void setDeviceStatus(String deviceStatus) {
		this.deviceStatus = deviceStatus;
	}

	public String getDeviceMobile() {
		return deviceMobile;
	}

	public void setDeviceMobile(String deviceMobile) {
		this.deviceMobile = deviceMobile;
	}

	public int getLocationPower() {
		return locationPower;
	}

	public void setLocationPower(int locationPower) {
		this.locationPower = locationPower;
	}

	public String getOnlineTime() {
		return onlineTime;
	}

	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((deviceIMEI == null) ? 0 : deviceIMEI.hashCode());
		result = prime * result + ((deviceMobile == null) ? 0 : deviceMobile.hashCode());
		result = prime * result + ((deviceStatus == null) ? 0 : deviceStatus.hashCode());
		result = prime * result + locationPower;
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
		LocatorDeviceStatus other = (LocatorDeviceStatus) obj;
		if (deviceIMEI == null) {
			if (other.deviceIMEI != null)
				return false;
		} else if (!deviceIMEI.equals(other.deviceIMEI))
			return false;
		if (deviceMobile == null) {
			if (other.deviceMobile != null)
				return false;
		} else if (!deviceMobile.equals(other.deviceMobile))
			return false;
		if (deviceStatus == null) {
			if (other.deviceStatus != null)
				return false;
		} else if (!deviceStatus.equals(other.deviceStatus))
			return false;
		if (locationPower != other.locationPower)
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
		return "LocatorDeviceStatus [deviceIMEI=" + deviceIMEI + ", deviceStatus=" + deviceStatus + ", deviceMobile="
				+ deviceMobile + ", locationPower=" + locationPower + ", onlineTime=" + onlineTime + "]";
	}

	
    
}
