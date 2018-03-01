package com.anyikang.model;

public class OldManMsg {

	private String oldManId;
	private int deviceId;
	private String surname;
	private String name;
	private int sex;
	private String imageUrl;
	private int age;
	private String mobile;
	private String address;
	
	public OldManMsg(){
		
	}

	public OldManMsg(String oldManId, int deviceId, String surname, String name, int sex, String imageUrl, int age,
			String mobile, String address) {
		super();
		this.oldManId = oldManId;
		this.deviceId = deviceId;
		this.surname = surname;
		this.name = name;
		this.sex = sex;
		this.imageUrl = imageUrl;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}

	public String getOldManId() {
		return oldManId;
	}

	public void setOldManId(String oldManId) {
		this.oldManId = oldManId;
	}

	public int getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(int deviceId) {
		this.deviceId = deviceId;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + deviceId;
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((oldManId == null) ? 0 : oldManId.hashCode());
		result = prime * result + sex;
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		OldManMsg other = (OldManMsg) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (deviceId != other.deviceId)
			return false;
		if (imageUrl == null) {
			if (other.imageUrl != null)
				return false;
		} else if (!imageUrl.equals(other.imageUrl))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oldManId == null) {
			if (other.oldManId != null)
				return false;
		} else if (!oldManId.equals(other.oldManId))
			return false;
		if (sex != other.sex)
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OldManMsg [oldManId=" + oldManId + ", deviceId=" + deviceId + ", surname=" + surname + ", name=" + name
				+ ", sex=" + sex + ", imageUrl=" + imageUrl + ", age=" + age + ", mobile=" + mobile + ", address="
				+ address + "]";
	}
	
	
}
