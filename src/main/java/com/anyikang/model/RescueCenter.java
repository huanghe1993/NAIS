package com.anyikang.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 救援中心实体类
 * @author LvXiaoxiong
 * @date 2017/11/17
 *
 */
@TableName("rescue_center")
public class RescueCenter extends Model<RescueCenter>{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@TableId(value = "rescue_center_id")
	private String rescueCenterId;
	@TableField(value = "rescue_center_name")
	private String rescueCenterName;
	@TableField(value = "rescue_charge_name")
	private String rescueChargeName;
	@TableField(value = "rescue_parent_code")
	private String rescueParentCode;
	@TableField(value = "rescue_city_code")
	private String code;
	@TableField(value = "charge_mobile")
	private String chargeMobile;
	private String address;
	@TableField(value ="create_time")
	private Timestamp createTime;
	private String mark;
	
	
	
	public RescueCenter(){
		
	}
    
	public RescueCenter(String rescueCenterId, String rescueCenterName, String rescueChargeName,
			String rescueParentCode, String code, String chargeMobile, String address, Timestamp createTime,
			String mark) {
		super();
		this.rescueCenterId = rescueCenterId;
		this.rescueCenterName = rescueCenterName;
		this.rescueChargeName = rescueChargeName;
		this.rescueParentCode = rescueParentCode;
		this.code = code;
		this.chargeMobile = chargeMobile;
		this.address = address;
		this.createTime = createTime;
		this.mark = mark;
	}

	public String getRescueCenterId() {
		return rescueCenterId;
	}

	public void setRescueCenterId(String rescueCenterId) {
		this.rescueCenterId = rescueCenterId;
	}

	public String getRescueCenterName() {
		return rescueCenterName;
	}

	public void setRescueCenterName(String rescueCenterName) {
		this.rescueCenterName = rescueCenterName;
	}

	public String getRescueChargeName() {
		return rescueChargeName;
	}

	public void setRescueChargeName(String rescueChargeName) {
		this.rescueChargeName = rescueChargeName;
	}

	public String getRescueParentCode() {
		return rescueParentCode;
	}

	public void setRescueParentCode(String rescueParentCode) {
		this.rescueParentCode = rescueParentCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getChargeMobile() {
		return chargeMobile;
	}

	public void setChargeMobile(String chargeMobile) {
		this.chargeMobile = chargeMobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((chargeMobile == null) ? 0 : chargeMobile.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((mark == null) ? 0 : mark.hashCode());
		result = prime * result + ((rescueCenterId == null) ? 0 : rescueCenterId.hashCode());
		result = prime * result + ((rescueCenterName == null) ? 0 : rescueCenterName.hashCode());
		result = prime * result + ((rescueChargeName == null) ? 0 : rescueChargeName.hashCode());
		result = prime * result + ((rescueParentCode == null) ? 0 : rescueParentCode.hashCode());
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
		RescueCenter other = (RescueCenter) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (chargeMobile == null) {
			if (other.chargeMobile != null)
				return false;
		} else if (!chargeMobile.equals(other.chargeMobile))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (mark == null) {
			if (other.mark != null)
				return false;
		} else if (!mark.equals(other.mark))
			return false;
		if (rescueCenterId == null) {
			if (other.rescueCenterId != null)
				return false;
		} else if (!rescueCenterId.equals(other.rescueCenterId))
			return false;
		if (rescueCenterName == null) {
			if (other.rescueCenterName != null)
				return false;
		} else if (!rescueCenterName.equals(other.rescueCenterName))
			return false;
		if (rescueChargeName == null) {
			if (other.rescueChargeName != null)
				return false;
		} else if (!rescueChargeName.equals(other.rescueChargeName))
			return false;
		if (rescueParentCode == null) {
			if (other.rescueParentCode != null)
				return false;
		} else if (!rescueParentCode.equals(other.rescueParentCode))
			return false;
		return true;
	}
	

	@Override
	protected Serializable pkVal() {
		return this.rescueCenterId;
	}

	
	
	
}
