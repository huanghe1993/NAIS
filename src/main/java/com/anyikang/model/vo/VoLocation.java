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
	private float locationLongitude;//经度
	private float locationLatitude;//纬度
	private float locationSpeed;//速度
	private float locationDirection;//方向
	private float locationAltitude;//海拔
	private int locationElectricity;//电量
	private Date locationTime;//定位时间
	private Date serverTime;//服务器时间
	
	public VoLocation(){
		
	}

	public VoLocation(String locationId, int deviceId, int locationType, float locationLongitude,
			float locationLatitude, float locationSpeed, float locationDirection, float locationAltitude,
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceId;
		result = prime * result + Float.floatToIntBits(locationAltitude);
		result = prime * result + Float.floatToIntBits(locationDirection);
		result = prime * result + locationElectricity;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + Float.floatToIntBits(locationLatitude);
		result = prime * result + Float.floatToIntBits(locationLongitude);
		result = prime * result + Float.floatToIntBits(locationSpeed);
		result = prime * result + ((locationTime == null) ? 0 : locationTime.hashCode());
		result = prime * result + locationType;
		result = prime * result + ((serverTime == null) ? 0 : serverTime.hashCode());
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
		VoLocation other = (VoLocation) obj;
		if (deviceId != other.deviceId)
			return false;
		if (Float.floatToIntBits(locationAltitude) != Float.floatToIntBits(other.locationAltitude))
			return false;
		if (Float.floatToIntBits(locationDirection) != Float.floatToIntBits(other.locationDirection))
			return false;
		if (locationElectricity != other.locationElectricity)
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (Float.floatToIntBits(locationLatitude) != Float.floatToIntBits(other.locationLatitude))
			return false;
		if (Float.floatToIntBits(locationLongitude) != Float.floatToIntBits(other.locationLongitude))
			return false;
		if (Float.floatToIntBits(locationSpeed) != Float.floatToIntBits(other.locationSpeed))
			return false;
		if (locationTime == null) {
			if (other.locationTime != null)
				return false;
		} else if (!locationTime.equals(other.locationTime))
			return false;
		if (locationType != other.locationType)
			return false;
		if (serverTime == null) {
			if (other.serverTime != null)
				return false;
		} else if (!serverTime.equals(other.serverTime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VoLocation [locationId=" + locationId + ", deviceId=" + deviceId + ", locationType=" + locationType
				+ ", locationLongitude=" + locationLongitude + ", locationLatitude=" + locationLatitude
				+ ", locationSpeed=" + locationSpeed + ", locationDirection=" + locationDirection
				+ ", locationAltitude=" + locationAltitude + ", locationElectricity=" + locationElectricity
				+ ", locationTime=" + locationTime + ", serverTime=" + serverTime + "]";
	}

	
	
	
}
