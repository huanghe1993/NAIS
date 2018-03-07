package com.anyikang.model.vo;

/**
 * 紧急救援系统设备状态实体类
 * @author LvXiaoXiong
 * @date 2017/07/18
 *
 */
public class LocatorDeviceStatus {

	private String  deviceIMEI;
    private String  bluetoothStatus;
    private String  deviceMobile;
    private int     locationPower;
    
    public LocatorDeviceStatus(){
    	
    }

	public LocatorDeviceStatus(String deviceIMEI, String bluetoothStatus, String deviceMobile, int locationPower) {
		super();
		this.deviceIMEI = deviceIMEI;
		this.bluetoothStatus = bluetoothStatus;
		this.deviceMobile = deviceMobile;
		this.locationPower = locationPower;
	}

	public String getDeviceIMEI() {
		return deviceIMEI;
	}

	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}

	public String getBluetoothStatus() {
		return bluetoothStatus;
	}

	public void setBluetoothStatus(String bluetoothStatus) {
		this.bluetoothStatus = bluetoothStatus;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bluetoothStatus == null) ? 0 : bluetoothStatus.hashCode());
		result = prime * result + ((deviceIMEI == null) ? 0 : deviceIMEI.hashCode());
		result = prime * result + ((deviceMobile == null) ? 0 : deviceMobile.hashCode());
		result = prime * result + locationPower;
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
		if (bluetoothStatus == null) {
			if (other.bluetoothStatus != null)
				return false;
		} else if (!bluetoothStatus.equals(other.bluetoothStatus))
			return false;
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
		if (locationPower != other.locationPower)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LocatorDeviceStatus [deviceIMEI=" + deviceIMEI + ", bluetoothStatus=" + bluetoothStatus
				+ ", deviceMobile=" + deviceMobile + ", locationPower=" + locationPower + "]";
	}
	
}
