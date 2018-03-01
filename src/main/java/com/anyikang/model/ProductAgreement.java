package com.anyikang.model;

import java.sql.Timestamp;

/**
 * 
 * @author LvXiaoxiong
 * @date 2017/11/27
 *
 */
public class ProductAgreement {

	private String agreementId;
	private String softwareName;
	private String agreementName;
	private String agreementVersion;
	private String agreementDevice;
	private String agreementInstructions;
	private int updateTimes;
	private Timestamp createTime;
	private String remark;
	
	
	public ProductAgreement(){
		
	}


	public ProductAgreement(String agreementId, String softwareName, String agreementName, String agreementVersion,
			String agreementDevice, String agreementInstructions, int updateTimes, Timestamp createTime,
			String remark) {
		super();
		this.agreementId = agreementId;
		this.softwareName = softwareName;
		this.agreementName = agreementName;
		this.agreementVersion = agreementVersion;
		this.agreementDevice = agreementDevice;
		this.agreementInstructions = agreementInstructions;
		this.updateTimes = updateTimes;
		this.createTime = createTime;
		this.remark = remark;
	}


	public String getAgreementId() {
		return agreementId;
	}


	public void setAgreementId(String agreementId) {
		this.agreementId = agreementId;
	}


	public String getSoftwareName() {
		return softwareName;
	}


	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}


	public String getAgreementName() {
		return agreementName;
	}


	public void setAgreementName(String agreementName) {
		this.agreementName = agreementName;
	}


	public String getAgreementVersion() {
		return agreementVersion;
	}


	public void setAgreementVersion(String agreementVersion) {
		this.agreementVersion = agreementVersion;
	}


	public String getAgreementDevice() {
		return agreementDevice;
	}


	public void setAgreementDevice(String agreementDevice) {
		this.agreementDevice = agreementDevice;
	}


	public String getAgreementInstructions() {
		return agreementInstructions;
	}


	public void setAgreementInstructions(String agreementInstructions) {
		this.agreementInstructions = agreementInstructions;
	}


	public int getUpdateTimes() {
		return updateTimes;
	}


	public void setUpdateTimes(int updateTimes) {
		this.updateTimes = updateTimes;
	}


	public Timestamp getCreateTime() {
		return createTime;
	}


	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agreementDevice == null) ? 0 : agreementDevice.hashCode());
		result = prime * result + ((agreementId == null) ? 0 : agreementId.hashCode());
		result = prime * result + ((agreementInstructions == null) ? 0 : agreementInstructions.hashCode());
		result = prime * result + ((agreementName == null) ? 0 : agreementName.hashCode());
		result = prime * result + ((agreementVersion == null) ? 0 : agreementVersion.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((softwareName == null) ? 0 : softwareName.hashCode());
		result = prime * result + updateTimes;
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
		ProductAgreement other = (ProductAgreement) obj;
		if (agreementDevice == null) {
			if (other.agreementDevice != null)
				return false;
		} else if (!agreementDevice.equals(other.agreementDevice))
			return false;
		if (agreementId == null) {
			if (other.agreementId != null)
				return false;
		} else if (!agreementId.equals(other.agreementId))
			return false;
		if (agreementInstructions == null) {
			if (other.agreementInstructions != null)
				return false;
		} else if (!agreementInstructions.equals(other.agreementInstructions))
			return false;
		if (agreementName == null) {
			if (other.agreementName != null)
				return false;
		} else if (!agreementName.equals(other.agreementName))
			return false;
		if (agreementVersion == null) {
			if (other.agreementVersion != null)
				return false;
		} else if (!agreementVersion.equals(other.agreementVersion))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (softwareName == null) {
			if (other.softwareName != null)
				return false;
		} else if (!softwareName.equals(other.softwareName))
			return false;
		if (updateTimes != other.updateTimes)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProductAgreement [agreementId=" + agreementId + ", softwareName=" + softwareName + ", agreementName="
				+ agreementName + ", agreementVersion=" + agreementVersion + ", agreementDevice=" + agreementDevice
				+ ", agreementInstructions=" + agreementInstructions + ", updateTimes=" + updateTimes + ", createTime="
				+ createTime + ", remark=" + remark + "]";
	}

    
	
	
	
}
