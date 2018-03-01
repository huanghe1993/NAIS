package com.anyikang.model;

import java.sql.Timestamp;

/**
 * Created by huanghe on 2017/3/28.
 */
public class Location {
    public String locationId;
    public int deviceId;
    public int locationType;
    public float locationLongitude;
    public float locationLatitude;
    public int locationPower;
    public Timestamp locationTime;
    public Timestamp serverTime;

    
    public Location(){
    	
    }


	public Location(String locationId, int deviceId, int locationType, float locationLongitude, float locationLatitude,
			int locationPower, Timestamp locationTime, Timestamp serverTime) {
		super();
		this.locationId = locationId;
		this.deviceId = deviceId;
		this.locationType = locationType;
		this.locationLongitude = locationLongitude;
		this.locationLatitude = locationLatitude;
		this.locationPower = locationPower;
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


	public int getLocationPower() {
		return locationPower;
	}


	public void setLocationPower(int locationPower) {
		this.locationPower = locationPower;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceId;
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + Float.floatToIntBits(locationLatitude);
		result = prime * result + Float.floatToIntBits(locationLongitude);
		result = prime * result + locationPower;
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
		Location other = (Location) obj;
		if (deviceId != other.deviceId)
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
		if (locationPower != other.locationPower)
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
		return "Location [locationId=" + locationId + ", deviceId=" + deviceId + ", locationType=" + locationType
				+ ", locationLongitude=" + locationLongitude + ", locationLatitude=" + locationLatitude
				+ ", locationPower=" + locationPower + ", locationTime=" + locationTime + ", serverTime=" + serverTime
				+ "]";
	}

    
	
    
}
