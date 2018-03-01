package com.anyikang.model;

import java.sql.Timestamp;

/**
 * 产品版本类
 * @author LvXiaoxiong
 * @date  2017/11/23
 */
public class ProductVersion {

	private String versionId;//id
	private String softwareName;//软件名称
	private String versionName;//版本名称
	private int versionNumber;//版本号
	private int versionDevice;//应用app
	private int updateTimes;//更新次数
	private Timestamp createTime;//创建时间
	private String downloadLink;//下载地址
	private String remark;//备注
	
	public ProductVersion(){
		
	}

	public ProductVersion(String versionId, String softwareName, String versionName, int versionNumber,
			int versionDevice, int updateTimes, Timestamp createTime, String downloadLink, String remark) {
		super();
		this.versionId = versionId;
		this.softwareName = softwareName;
		this.versionName = versionName;
		this.versionNumber = versionNumber;
		this.versionDevice = versionDevice;
		this.updateTimes = updateTimes;
		this.createTime = createTime;
		this.downloadLink = downloadLink;
		this.remark = remark;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
	}

	public String getSoftwareName() {
		return softwareName;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public int getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}

	public int getVersionDevice() {
		return versionDevice;
	}

	public void setVersionDevice(int versionDevice) {
		this.versionDevice = versionDevice;
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

	public String getDownloadLink() {
		return downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
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
		result = prime * result + ((downloadLink == null) ? 0 : downloadLink.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((softwareName == null) ? 0 : softwareName.hashCode());
		result = prime * result + updateTimes;
		result = prime * result + versionDevice;
		result = prime * result + ((versionId == null) ? 0 : versionId.hashCode());
		result = prime * result + ((versionName == null) ? 0 : versionName.hashCode());
		result = prime * result + versionNumber;
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
		ProductVersion other = (ProductVersion) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (downloadLink == null) {
			if (other.downloadLink != null)
				return false;
		} else if (!downloadLink.equals(other.downloadLink))
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
		if (versionDevice != other.versionDevice)
			return false;
		if (versionId == null) {
			if (other.versionId != null)
				return false;
		} else if (!versionId.equals(other.versionId))
			return false;
		if (versionName == null) {
			if (other.versionName != null)
				return false;
		} else if (!versionName.equals(other.versionName))
			return false;
		if (versionNumber != other.versionNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProductVersion [versionId=" + versionId + ", softwareName=" + softwareName + ", versionName="
				+ versionName + ", versionNumber=" + versionNumber + ", versionDevice=" + versionDevice
				+ ", updateTimes=" + updateTimes + ", createTime=" + createTime + ", downloadLink=" + downloadLink
				+ ", remark=" + remark + "]";
	}

	
	
	
}
