package com.anyikang.model.vo;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 紧急救助系统定位器定位上报信息实体类
 * @author LvXiaoxiong 2017/07/07
 *
 */
public class VoLocation {

	private String locationId;
	private int deviceId; //设备Id,与设备表关联
	private int locationType;//定位方式（GPS,WIFI,LBS）
	private String locationLongitude;//经度
	private String locationLatitude;//纬度
	private String locationSpeed;//速度
	private String locationDirection;//方向
	private String locationAltitude;//海拔
	private int locationElectricity;//电量
	private Date locationTime;//定位时间
	private Date serverTime;//服务器时间
	
	public VoLocation(){
		
	}

	public VoLocation(String locationId, int deviceId, int locationType, String locationLongitude,
			String locationLatitude, String locationSpeed, String locationDirection, String locationAltitude,
			int locationElectricity, Date locationTime, Date serverTime) {
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

	public String getLocationLongitude() {
		return locationLongitude;
	}

	public void setLocationLongitude(String locationLongitude) {
		this.locationLongitude = locationLongitude;
	}

	public String getLocationLatitude() {
		return locationLatitude;
	}

	public void setLocationLatitude(String locationLatitude) {
		this.locationLatitude = locationLatitude;
	}

	public String getLocationSpeed() {
		return locationSpeed;
	}

	public void setLocationSpeed(String locationSpeed) {
		this.locationSpeed = locationSpeed;
	}

	public String getLocationDirection() {
		return locationDirection;
	}

	public void setLocationDirection(String locationDirection) {
		this.locationDirection = locationDirection;
	}

	public String getLocationAltitude() {
		return locationAltitude;
	}

	public void setLocationAltitude(String locationAltitude) {
		this.locationAltitude = locationAltitude;
	}

	public int getLocationElectricity() {
		return locationElectricity;
	}

	public void setLocationElectricity(int locationElectricity) {
		this.locationElectricity = locationElectricity;
	}

	public Date getLocationTime() {
		return locationTime;
	}

	public void setLocationTime(Date locationTime) {
		this.locationTime = locationTime;
	}

	public Date getServerTime() {
		return serverTime;
	}

	public void setServerTime(Date serverTime) {
		this.serverTime = serverTime;
	}

	
	
	
}
