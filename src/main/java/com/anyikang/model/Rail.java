package com.anyikang.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangwei
 * @date 2017年6月22日
 */
public class Rail {

	public Rail() {
	}

	private BigDecimal railId;
	private String railName;
	private BigDecimal deviceId;
	private Byte railType;
	private Float railLongitude;
	private Float railLatitude;
	private Float parameter1;
	private Float parameter2;
	private String startTime;
	private String endTime;
	private Boolean status;
	private Date railCreateTime;

	public BigDecimal getRailId() {
		return railId;
	}

	public void setRailId(BigDecimal railId) {
		this.railId = railId;
	}

	public String getRailName() {
		return railName;
	}

	public void setRailName(String railName) {
		this.railName = railName;
	}

	public BigDecimal getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(BigDecimal deviceId) {
		this.deviceId = deviceId;
	}

	public Byte getRailType() {
		return railType;
	}

	public void setRailType(Byte railType) {
		this.railType = railType;
	}

	public Float getRailLongitude() {
		return railLongitude;
	}

	public void setRailLongitude(Float railLongitude) {
		this.railLongitude = railLongitude;
	}

	public Float getRailLatitude() {
		return railLatitude;
	}

	public void setRailLatitude(Float railLatitude) {
		this.railLatitude = railLatitude;
	}

	public Float getParameter1() {
		return parameter1;
	}

	public void setParameter1(Float parameter1) {
		this.parameter1 = parameter1;
	}

	public Float getParameter2() {
		return parameter2;
	}

	public void setParameter2(Float parameter2) {
		this.parameter2 = parameter2;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Date getRailCreateTime() {
		return railCreateTime;
	}

	public void setRailCreateTime(Date railCreateTime) {
		this.railCreateTime = railCreateTime;
	}
}
