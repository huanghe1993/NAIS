package com.anyikang.model;


public class RescueCount {

	private String rescueTeam;
	private int alarmNumber;
    private int  rescueNumber;
    private String rescueCenterId;
    private String rescueChargeName;
    private String chargeMobile;
    private String rescueCityCode;
    
    public RescueCount (){
    	
    }

	public RescueCount(String rescueTeam, int alarmNumber, int rescueNumber, String rescueCenterId,
			String rescueChargeName, String chargeMobile, String rescueCityCode) {
		super();
		this.rescueTeam = rescueTeam;
		this.alarmNumber = alarmNumber;
		this.rescueNumber = rescueNumber;
		this.rescueCenterId = rescueCenterId;
		this.rescueChargeName = rescueChargeName;
		this.chargeMobile = chargeMobile;
		this.rescueCityCode = rescueCityCode;
	}

	public String getRescueTeam() {
		return rescueTeam;
	}

	public void setRescueTeam(String rescueTeam) {
		this.rescueTeam = rescueTeam;
	}

	public int getAlarmNumber() {
		return alarmNumber;
	}

	public void setAlarmNumber(int alarmNumber) {
		this.alarmNumber = alarmNumber;
	}

	public int getRescueNumber() {
		return rescueNumber;
	}

	public void setRescueNumber(int rescueNumber) {
		this.rescueNumber = rescueNumber;
	}

	public String getRescueCenterId() {
		return rescueCenterId;
	}

	public void setRescueCenterId(String rescueCenterId) {
		this.rescueCenterId = rescueCenterId;
	}

	public String getRescueChargeName() {
		return rescueChargeName;
	}

	public void setRescueChargeName(String rescueChargeName) {
		this.rescueChargeName = rescueChargeName;
	}

	public String getChargeMobile() {
		return chargeMobile;
	}

	public void setChargeMobile(String chargeMobile) {
		this.chargeMobile = chargeMobile;
	}

	public String getRescueCityCode() {
		return rescueCityCode;
	}

	public void setRescueCityCode(String rescueCityCode) {
		this.rescueCityCode = rescueCityCode;
	}

	
	
    
}
