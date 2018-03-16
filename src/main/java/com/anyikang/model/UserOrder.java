package com.anyikang.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 * @author wangwei
 * @date 2018年3月7日
 */
@TableName("user_order")
public class UserOrder extends Model<UserOrder> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6002905339326793982L;
	/** id */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** user_id */
	@TableField(value = "user_id")
	private String userId;
	@TableField(value = "order_code")
	private String orderCode;
	@TableField(value = "order_name")
	private String orderName;
	/** device_id */
	@TableField(value = "device_id")
	private String deviceId;
	/** total_amount */
	@TableField("total_amount")
	private Double totalAmount;// 订单总金额
	/** description */
	@TableField(value = "description")
	private String description;
	/** create_time */
	@TableField(value = "create_time")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * 获取 deviceId
	 *
	 * @return: String device_id
	 */
	public String getDeviceId() {
		return this.deviceId;
	}

	/**
	 * 设置 deviceId
	 *
	 * @param: deviceId device_id
	 */
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * 获取 description
	 *
	 * @return: String description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 设置 description
	 *
	 * @param: description description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取 createTime
	 *
	 * @return: Date create_time
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 设置 createTime
	 *
	 * @param: createTime create_time
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baomidou.mybatisplus.activerecord.Model#pkVal()
	 */
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.id;
	}

}
