package com.anyikang.model.vo;

import java.sql.Timestamp;

/**
 * 紧急救助系统定位器定位上报信息实体类
 * @author LvXiaoxiong 2017/07/07
 *
 */
public class VoLocation {

	private String locationId;
	private int deviceId; //设备Id,与设备表关联
	private int locationType;//定位方式（GPS,WIFI,LBS）
	private float locationLongitude;//经度
	private float locationLatitude;//纬度
	private float locationSpeed;//速度
	private float locationDirection;//方向
	private float locationAltitude;//海拔
	private int locationElectricity;//电量
	private Timestamp locationTime;//定位时间
	private Timestamp serverTime;//服务器时间
	private String regionNumber;//区域码
	
	public VoLocation(){
		
	}

	public VoLocation(String locationId, int deviceId, int locationType, float locationLongitude,
			float locationLatitude, float locationSpeed, float locationDirection, float locationAltitude,
			int locationElectricity, Timestamp locationTime, Timestamp serverTime, String regionNumber) {
		super();
		this.locationId = locationId;
		this.deviceId = deviceId;
		this.locationType = locationType;
		this.locationLongitude = locationLongitude;
		this.locationLatitude = locationLatitude;
		this.locationSpeed = locationSpeed;
		this.locationDirection = locationDirection;
		this.locationAltitude = locationAltitude;
		this.locationElectricity = locationElectricity;
		this.locationTime = locationTime;
		this.serverTime = serverTime;
		this.regionNumber = regionNumber;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public int getLocationType() {
		return locationType;
	}

	public void setLocationType(int locationType) {
		this.locationType = locationType;
	}

	public float getLocationLongitude() {
		return locationLongitude;
	}

	public void setLocationLongitude(float locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public float getLocationLatitude() {
		return locationLatitude;
	}

	public void setLocationLatitude(float locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	public float getLocationSpeed() {
		return locationSpeed;
	}

	public void setLocationSpeed(float locationSpeed) {
		this.locationSpeed = locationSpeed;
	}

	public float getLocationDirection() {
		return locationDirection;
	}

	public void setLocationDirection(float locationDirection) {
		this.locationDirection = locationDirection;
	}

	public float getLocationAltitude() {
		return locationAltitude;
	}

	public void setLocationAltitude(float locationAltitude) {
		this.locationAltitude = locationAltitude;
	}

	public int getLocationElectricity() {
		return locationElectricity;
	}

	public void setLocationElectricity(int locationElectricity) {
		this.locationElectricity = locationElectricity;
	}

	public Timestamp getLocationTime() {
		return locationTime;
	}

	public void setLocationTime(Timestamp locationTime) {
		this.locationTime = locationTime;
	}

	public Timestamp getServerTime() {
		return serverTime;
	}

	public void setServerTime(Timestamp serverTime) {
		this.serverTime = serverTime;
	}

	public String getRegionNumber() {
		return regionNumber;
	}

	public void setRegionNumber(String regionNumber) {
		this.regionNumber = regionNumber;
	}

	@Override
	public String toString() {
		return "VoLocation [locationId=" + locationId + ", deviceId=" + deviceId + ", locationType=" + locationType
				+ ", locationLongitude=" + locationLongitude + ", locationLatitude=" + locationLatitude
				+ ", locationSpeed=" + locationSpeed + ", locationDirection=" + locationDirection
				+ ", locationAltitude=" + locationAltitude + ", locationElectricity=" + locationElectricity
				+ ", locationTime=" + locationTime + ", serverTime=" + serverTime + ", regionNumber=" + regionNumber
				+ "]";
	}

	
	
	
}
