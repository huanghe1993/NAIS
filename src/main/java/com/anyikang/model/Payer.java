package com.anyikang.model;

import java.util.Date;

public class Payer {

	private int   userId;
	private String mobile;
	private String password;
	private Date createTime;
	
	public Payer(){
		
	}

	public Payer(int userId, String mobile, String password, Date createTime) {
		super();
		this.userId = userId;
		this.mobile = mobile;
		this.password = password;
		this.createTime = createTime;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	
	
}
