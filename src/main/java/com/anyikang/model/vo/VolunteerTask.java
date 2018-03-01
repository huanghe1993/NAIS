package com.anyikang.model.vo;

/**
 * 救援任务-志愿者
 * @author Administrator
 *
 */
public class VolunteerTask {

	private String taskId;
	private String volunteerId;
	private int isReceive;
	
	public VolunteerTask(){
		
	}

	public VolunteerTask(String taskId, String volunteerId, int isReceive) {
		super();
		this.taskId = taskId;
		this.volunteerId = volunteerId;
		this.isReceive = isReceive;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(String volunteerId) {
		this.volunteerId = volunteerId;
	}

	public int getIsReceive() {
		return isReceive;
	}

	public void setIsReceive(int isReceive) {
		this.isReceive = isReceive;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isReceive;
		result = prime * result + ((taskId == null) ? 0 : taskId.hashCode());
		result = prime * result + ((volunteerId == null) ? 0 : volunteerId.hashCode());
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
		VolunteerTask other = (VolunteerTask) obj;
		if (isReceive != other.isReceive)
			return false;
		if (taskId == null) {
			if (other.taskId != null)
				return false;
		} else if (!taskId.equals(other.taskId))
			return false;
		if (volunteerId == null) {
			if (other.volunteerId != null)
				return false;
		} else if (!volunteerId.equals(other.volunteerId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VolunteerTask [taskId=" + taskId + ", volunteerId=" + volunteerId + ", isReceive=" + isReceive + "]";
	}
	
	
}
