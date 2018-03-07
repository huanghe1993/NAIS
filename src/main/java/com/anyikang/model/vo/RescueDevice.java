package com.anyikang.model.vo;

import java.util.Date;

/**
 * 定位器实体类
 * @author lvXiaoxiong
 * @date  2017/07/13
 *
 */
public class RescueDevice {

    public int deviceId; 
    public String deviceIMEI;
    public String deviceName;
    public String deviceMobile;
    public int devicePower;
    public String deviceStatus;
    public Date onlineTime;
    public Date deviceCreateTime;
    public int bluetoothStatus;

    
    public RescueDevice(){
    	
    }


	public RescueDevice(int deviceId, String deviceIMEI, String deviceName, String deviceMobile, int devicePower,
			String deviceStatus, Date onlineTime, Date deviceCreateTime, int bluetoothStatus) {
		super();
		this.deviceId = deviceId;
		this.deviceIMEI = deviceIMEI;
		this.deviceName = deviceName;
		this.deviceMobile = deviceMobile;
		this.devicePower = devicePower;
		this.deviceStatus = deviceStatus;
		this.onlineTime = onlineTime;
		this.deviceCreateTime = deviceCreateTime;
		this.bluetoothStatus = bluetoothStatus;
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


	public Date getOnlineTime() {
		return onlineTime;
	}


	public void setOnlineTime(Date onlineTime) {
		this.onlineTime = onlineTime;
	}


	public Date getDeviceCreateTime() {
		return deviceCreateTime;
	}


	public void setDeviceCreateTime(Date deviceCreateTime) {
		this.deviceCreateTime = deviceCreateTime;
	}


	public int getBluetoothStatus() {
		return bluetoothStatus;
	}


	public void setBluetoothStatus(int bluetoothStatus) {
		this.bluetoothStatus = bluetoothStatus;
	}

    
	
  
}
