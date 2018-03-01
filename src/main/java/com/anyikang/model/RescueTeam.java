package com.anyikang.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @author wangwei
 * @date 2017年7月27日
 */
@TableName("rescue_team")
public class RescueTeam extends Model<RescueTeam> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@TableId(value = "rescue_team_id")
	private String rescueTeamId;

	private String name;

	private String addr;

	private String remark;

	public String getRescueTeamId() {
		return rescueTeamId;
	}

	public void setRescueTeamId(String rescueTeamId) {
		this.rescueTeamId = rescueTeamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	protected Serializable pkVal() {
		return this.rescueTeamId;
	}

}
