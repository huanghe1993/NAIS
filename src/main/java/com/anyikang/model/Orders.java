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
@TableName("orders")
public class Orders extends Model<Orders> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6002905339326793982L;
	/** orders_id */
	@TableId(value = "id", type = IdType.UUID)
	private Integer ordersId;
	/** user_id */
	@TableField(value = "user_id")
	private Integer userId;
	/** orders_code */
	@TableField(value = "orders_code")
	private String ordersCode;
	/** name */
	@TableField(value = "name")
	private String name;
	/** device_id */
	@TableField(value = "device_id")
	private String deviceId;
	/** price */
	@TableField(value = "price")
	private String price;
	/** description */
	@TableField(value = "description")
	private String description;
	/** create_time */
	@TableField(value = "create_time")
	private Date createTime;

	/**
	 * 获取 ordersId
	 *
	 * @return: Integer orders_id
	 */
	public Integer getOrdersId() {
		return this.ordersId;
	}

	/**
	 * 设置 ordersId
	 *
	 * @param: ordersId orders_id
	 */
	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	/**
	 * 获取 userId
	 *
	 * @return: Integer user_id
	 */
	public Integer getUserId() {
		return this.userId;
	}

	/**
	 * 设置 userId
	 *
	 * @param: userId user_id
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * 获取 ordersCode
	 *
	 * @return: String orders_code
	 */
	public String getOrdersCode() {
		return this.ordersCode;
	}

	/**
	 * 设置 ordersCode
	 *
	 * @param: ordersCode orders_code
	 */
	public void setOrdersCode(String ordersCode) {
		this.ordersCode = ordersCode;
	}

	/**
	 * 获取 name
	 *
	 * @return: String name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 设置 name
	 *
	 * @param: name name
	 */
	public void setName(String name) {
		this.name = name;
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

	/**
	 * 获取 price
	 *
	 * @return: String price
	 */
	public String getPrice() {
		return this.price;
	}

	/**
	 * 设置 price
	 *
	 * @param: price price
	 */
	public void setPrice(String price) {
		this.price = price;
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
		return this.ordersId;
	}

}
