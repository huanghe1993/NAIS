package com.anyikang.model.vo;



/**
 * 紧急救援系统设备信息实体类
 * @author LvXiaoxiong
 * @date 2017/07/17
 *
 */
public class LocatorDeviceMessage {

	private int deviceId;//设备Id
	private String deviceImei;//设备Imei号
	private String deviceUserName;//设备使用者
	private String devicePhone;//设备手机号
	private String familyPhones;//亲情号

	
	public LocatorDeviceMessage(){
		
	}


	public LocatorDeviceMessage(int deviceId, String deviceImei, String deviceUserName, String devicePhone,
			String familyPhones) {
		super();
		this.deviceId = deviceId;
		this.deviceImei = deviceImei;
		this.deviceUserName = deviceUserName;
		this.devicePhone = devicePhone;
		this.familyPhones = familyPhones;
	}


	public int getDeviceId() {
		return deviceId;
	}


	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}


	public String getDeviceImei() {
		return deviceImei;
	}


	public void setDeviceImei(String deviceImei) {
		this.deviceImei = deviceImei;
	}


	public String getDeviceUserName() {
		return deviceUserName;
	}


	public void setDeviceUserName(String deviceUserName) {
		this.deviceUserName = deviceUserName;
	}


	public String getDevicePhone() {
		return devicePhone;
	}


	public void setDevicePhone(String devicePhone) {
		this.devicePhone = devicePhone;
	}


	public String getFamilyPhones() {
		return familyPhones;
	}


	public void setFamilyPhones(String familyPhones) {
		this.familyPhones = familyPhones;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deviceId;
		result = prime * result + ((deviceImei == null) ? 0 : deviceImei.hashCode());
		result = prime * result + ((devicePhone == null) ? 0 : devicePhone.hashCode());
		result = prime * result + ((deviceUserName == null) ? 0 : deviceUserName.hashCode());
		result = prime * result + ((familyPhones == null) ? 0 : familyPhones.hashCode());
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
		LocatorDeviceMessage other = (LocatorDeviceMessage) obj;
		if (deviceId != other.deviceId)
			return false;
		if (deviceImei == null) {
			if (other.deviceImei != null)
				return false;
		} else if (!deviceImei.equals(other.deviceImei))
			return false;
		if (devicePhone == null) {
			if (other.devicePhone != null)
				return false;
		} else if (!devicePhone.equals(other.devicePhone))
			return false;
		if (deviceUserName == null) {
			if (other.deviceUserName != null)
				return false;
		} else if (!deviceUserName.equals(other.deviceUserName))
			return false;
		if (familyPhones == null) {
			if (other.familyPhones != null)
				return false;
		} else if (!familyPhones.equals(other.familyPhones))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "LocatorDeviceMessage [deviceId=" + deviceId + ", deviceImei=" + deviceImei + ", deviceUserName="
				+ deviceUserName + ", devicePhone=" + devicePhone + ", familyPhones=" + familyPhones + "]";
	}

	
	
}
