package com.anyikang.model;

import java.util.Date;

public class Team {
    private long teamId;
    private String   teamName;
    private String   address;
    private long  teamOwnerID;
    private Date     teamCreateTime;
    private String groupId;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    

    public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTeamOwnerID() {
        return teamOwnerID;
    }

    public void setTeamOwnerID(long teamOwnerID) {
        this.teamOwnerID = teamOwnerID;
    }

    public Date getTeamCreateTime() {
        return teamCreateTime;
    }

    public void setTeamCreateTime(Date teamCreateTime) {
        this.teamCreateTime = teamCreateTime;
    }
}
