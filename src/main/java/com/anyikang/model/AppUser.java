package com.anyikang.model;

import java.util.Date;

import com.anyikang.utils.TokenProcessor;

/**
 * @author wangwei
 * @date 2017年6月22日
 */
public class AppUser {
	private long userId;

	private String mobile;

	private String name;

	private String password;

	private String email;

	private String token;

	private String avatar;

	private Date userCreateTime;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getToken() {
		return token;
	}

	public String updateToken() {
		String tokenn = TokenProcessor.getInstance().generateToken(
				this.userId + this.name, true);
		this.token = tokenn;
		return tokenn;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Date getUserCreateTime() {
		return userCreateTime;
	}

	public void setUserCreateTime(Date userCreateTime) {
		this.userCreateTime = userCreateTime;
	}

	public AppUser() {
		// 默认跟新token
		// updateToken();
		// setUserCreateTime(new Date(System.currentTimeMillis()));
	}
}
