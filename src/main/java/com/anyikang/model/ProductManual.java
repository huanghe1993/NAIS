package com.anyikang.model;

import java.sql.Timestamp;

/**
 * 产品说明类
 * @author LvXiaoxiong
 * @date 2017/11/25
 *
 */
public class ProductManual {

	private String manualId;
	private String manualName;
	private String softwareName;
	private String manualVersion;
	private String manualDevice;
	private String manualInstructions;
	private int updateTimes;
	private Timestamp createTime;
	private String remark;

	public ProductManual (){
		
	}

	public ProductManual(String manualId, String manualName, String softwareName, String manualVersion,
			String manualDevice, String manualInstructions, int updateTimes, Timestamp createTime, String remark) {
		super();
		this.manualId = manualId;
		this.manualName = manualName;
		this.softwareName = softwareName;
		this.manualVersion = manualVersion;
		this.manualDevice = manualDevice;
		this.manualInstructions = manualInstructions;
		this.updateTimes = updateTimes;
		this.createTime = createTime;
		this.remark = remark;
	}

	public String getManualId() {
		return manualId;
	}

	public void setManualId(String manualId) {
		this.manualId = manualId;
	}

	public String getManualName() {
		return manualName;
	}

	public void setManualName(String manualName) {
		this.manualName = manualName;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getManualVersion() {
		return manualVersion;
	}

	public void setManualVersion(String manualVersion) {
		this.manualVersion = manualVersion;
	}

	public String getManualDevice() {
		return manualDevice;
	}

	public void setManualDevice(String manualDevice) {
		this.manualDevice = manualDevice;
	}

	public String getManualInstructions() {
		return manualInstructions;
	}

	public void setManualInstructions(String manualInstructions) {
		this.manualInstructions = manualInstructions;
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
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((manualDevice == null) ? 0 : manualDevice.hashCode());
		result = prime * result + ((manualId == null) ? 0 : manualId.hashCode());
		result = prime * result + ((manualInstructions == null) ? 0 : manualInstructions.hashCode());
		result = prime * result + ((manualName == null) ? 0 : manualName.hashCode());
		result = prime * result + ((manualVersion == null) ? 0 : manualVersion.hashCode());
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
		ProductManual other = (ProductManual) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (manualDevice == null) {
			if (other.manualDevice != null)
				return false;
		} else if (!manualDevice.equals(other.manualDevice))
			return false;
		if (manualId == null) {
			if (other.manualId != null)
				return false;
		} else if (!manualId.equals(other.manualId))
			return false;
		if (manualInstructions == null) {
			if (other.manualInstructions != null)
				return false;
		} else if (!manualInstructions.equals(other.manualInstructions))
			return false;
		if (manualName == null) {
			if (other.manualName != null)
				return false;
		} else if (!manualName.equals(other.manualName))
			return false;
		if (manualVersion == null) {
			if (other.manualVersion != null)
				return false;
		} else if (!manualVersion.equals(other.manualVersion))
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
		return "ProductManual [manualId=" + manualId + ", manualName=" + manualName + ", softwareName=" + softwareName
				+ ", manualVersion=" + manualVersion + ", manualDevice=" + manualDevice + ", manualInstructions="
				+ manualInstructions + ", updateTimes=" + updateTimes + ", createTime=" + createTime + ", remark="
				+ remark + "]";
	}

	
	
}
