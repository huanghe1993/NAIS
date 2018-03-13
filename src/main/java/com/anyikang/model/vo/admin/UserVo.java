package com.anyikang.model.vo.admin;

import java.io.Serializable;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public class UserVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer usersId;
	private String userName;
	private String originalUserName;
	private String nickName;
	private String userPassword;
	private String roleDescription;
	private String roleId;
	private String originalRoleId;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getOriginalUserName() {
		return originalUserName;
	}

	public void setOriginalUserName(String originalUserName) {
		this.originalUserName = originalUserName;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getOriginalRoleId() {
		return originalRoleId;
	}

	public void setOriginalRoleId(String originalRoleId) {
		this.originalRoleId = originalRoleId;
	}



}
