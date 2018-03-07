package com.anyikang.model;

import java.util.Date;

public class OldManMsg {

	private String oldManId;
	private int deviceId;
	private String surname;
	private String name;
	private int sex;
	private int age;
	private String mobile;
	private String address;
	private Date createTime;
	
	public OldManMsg(){
		
	}

	public OldManMsg(String oldManId, int deviceId, String surname, String name, int sex, int age, String mobile,
			String address, Date createTime) {
		super();
		this.oldManId = oldManId;
		this.deviceId = deviceId;
		this.surname = surname;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
		this.createTime = createTime;
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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	
}
