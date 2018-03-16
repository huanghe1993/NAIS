package com.anyikang.model;

import java.util.Date;

/**
 * 
 * @author LvXiaoxiong
 * @date  2018/03/13
 *
 */
public class PayStatus {

	public String oldManId;
	public String wearerName;
	public String sex;
	public int age;
	public String deviceIMEI;
	public Date serviceExpirationTime;
	
	public PayStatus(){
		
	}

	public PayStatus(String oldManId, String wearerName, String sex, int age, String deviceIMEI,
			Date serviceExpirationTime) {
		super();
		this.oldManId = oldManId;
		this.wearerName = wearerName;
		this.sex = sex;
		this.age = age;
		this.deviceIMEI = deviceIMEI;
		this.serviceExpirationTime = serviceExpirationTime;
	}

	public String getOldManId() {
		return oldManId;
	}

	public void setOldManId(String oldManId) {
		this.oldManId = oldManId;
	}

	public String getWearerName() {
		return wearerName;
	}

	public void setWearerName(String wearerName) {
		this.wearerName = wearerName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDeviceIMEI() {
		return deviceIMEI;
	}

	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}

	public Date getServiceExpirationTime() {
		return serviceExpirationTime;
	}

	public void setServiceExpirationTime(Date serviceExpirationTime) {
		this.serviceExpirationTime = serviceExpirationTime;
	}
	
}
