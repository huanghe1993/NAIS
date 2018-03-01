package com.anyikang.model.vo.admin;

import java.io.Serializable;

/**
 * 
 * @author wangwei
 * @date 2017年6月29日
 */
public class RoleVo implements Serializable {
	private Integer roleId;
	private String originalRoleName;
	private String roleName;
	private String roleDescription;
	private String addId;// 需添加的权限ID
	private String delId;// 需删除的权限ID

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getAddId() {
		return addId;
	}

	public void setAddId(String addId) {
		this.addId = addId;
	}

	public String getDelId() {
		return delId;
	}

	public void setDelId(String delId) {
		this.delId = delId;
	}

	public String getOriginalRoleName() {
		return originalRoleName;
	}

	public void setOriginalRoleName(String originalRoleName) {
		this.originalRoleName = originalRoleName;
	}

}
