package com.anyikang.model.vo;

import java.util.List;

/**
 * 求救人信息实体类
 * @author LvXiaoxiong
 * @param <Emergency>
 * @date  2017/07/20
 *
 */
public class SosPerson<Emergency> {

	private String imageUrl;
	private String name;
	private String sex;
	private String age;
	private String mobile;
	private String address;
	private List<Emergency> emergency;
	
	public SosPerson(){
		
	}

	public SosPerson(String imageUrl, String name, String sex, String age, String mobile, String address,
			List<Emergency> emergency) {
		super();
		this.imageUrl = imageUrl;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.emergency = emergency;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
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

	public List<Emergency> getEmergency() {
		return emergency;
	}

	public void setEmergency(List<Emergency> emergency) {
		this.emergency = emergency;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((emergency == null) ? 0 : emergency.hashCode());
		result = prime * result + ((imageUrl == null) ? 0 : imageUrl.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
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
		SosPerson other = (SosPerson) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (emergency == null) {
			if (other.emergency != null)
				return false;
		} else if (!emergency.equals(other.emergency))
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
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SosPerson [imageUrl=" + imageUrl + ", name=" + name + ", sex=" + sex + ", age=" + age + ", mobile="
				+ mobile + ", address=" + address + ", emergency=" + emergency + "]";
	}

	
	
}
