package com.anyikang.model;

import java.util.Date;

/**
 * 
 * @author LvXiaoxiong
 * @date 2018/03/13
 *
 */
public class PayList {

	public int orderId;
	public String payMobile;
	public String deviceIMEI;
	public String wearerName;
	public double totalAmount;
	public Date orderCreateTime;
	public Date payTime;
	
	public PayList(){
		
	}

	public PayList(int orderId, String payMobile, String deviceIMEI, String wearerName, double totalAmount,
			Date orderCreateTime, Date payTime) {
		super();
		this.orderId = orderId;
		this.payMobile = payMobile;
		this.deviceIMEI = deviceIMEI;
		this.wearerName = wearerName;
		this.totalAmount = totalAmount;
		this.orderCreateTime = orderCreateTime;
		this.payTime = payTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getPayMobile() {
		return payMobile;
	}

	public void setPayMobile(String payMobile) {
		this.payMobile = payMobile;
	}

	public String getDeviceIMEI() {
		return deviceIMEI;
	}

	public void setDeviceIMEI(String deviceIMEI) {
		this.deviceIMEI = deviceIMEI;
	}

	public String getWearerName() {
		return wearerName;
	}

	public void setWearerName(String wearerName) {
		this.wearerName = wearerName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderCreateTime() {
		return orderCreateTime;
	}

	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	
}
