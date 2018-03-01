package com.anyikang.model.vo;

import java.sql.Timestamp;

/**
 * 救助任务单实体类
 * @author LvXiaoxiong
 * @date  2017/07/25
 *
 */
public class RescueTask {

	private String taskId;
	private String address;
	private String alarmId;
	private int status;
	private String regionNumber;//所属区域
	private Timestamp createTime;
	private Timestamp receiveTime;
	
	public RescueTask(){
		
	}

	public RescueTask(String taskId, String address, String alarmId, int status, String regionNumber,
			Timestamp createTime, Timestamp receiveTime) {
		super();
		this.taskId = taskId;
		this.address = address;
		this.alarmId = alarmId;
		this.status = status;
		this.regionNumber = regionNumber;
		this.createTime = createTime;
		this.receiveTime = receiveTime;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAlarmId() {
		return alarmId;
	}

	public void setAlarmId(String alarmId) {
		this.alarmId = alarmId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRegionNumber() {
		return regionNumber;
	}

	public void setRegionNumber(String regionNumber) {
		this.regionNumber = regionNumber;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getReceiveTime() {
		return receiveTime;
	}

	public void setReceiveTime(Timestamp receiveTime) {
		this.receiveTime = receiveTime;
	}

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((alarmId == null) ? 0 : alarmId.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((receiveTime == null) ? 0 : receiveTime.hashCode());
		result = prime * result + ((regionNumber == null) ? 0 : regionNumber.hashCode());
		result = prime * result + status;
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
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
		RescueTask other = (RescueTask) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (alarmId == null) {
			if (other.alarmId != null)
				return false;
		} else if (!alarmId.equals(other.alarmId))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (receiveTime == null) {
			if (other.receiveTime != null)
				return false;
		} else if (!receiveTime.equals(other.receiveTime))
			return false;
		if (regionNumber == null) {
			if (other.regionNumber != null)
				return false;
		} else if (!regionNumber.equals(other.regionNumber))
			return false;
		if (status != other.status)
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RescueTask [taskId=" + taskId + ", address=" + address + ", alarmId=" + alarmId + ", status=" + status
				+ ", regionNumber=" + regionNumber + ", createTime=" + createTime + ", receiveTime=" + receiveTime
				+ "]";
	}

	

	
	
	
}
