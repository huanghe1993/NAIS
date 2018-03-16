package com.anyikang.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

@TableName("pay")
public class Pay extends Model<Pay> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5999883407943621728L;

	@TableId(value = "id", type = IdType.UUID)
	private String id;

	@TableField(value = "order_id")
	private String orderId;

	@TableField(value = "pay_time")
	private Date payTime;

	@TableField(value = "is_pay")
	private Integer isPay;

	// 支付方式（0：阿里支付 1：微信支付）
	@TableField(value = "pay_method")
	private Integer payMethod;

	// 交易号
	@TableField(value = "trade_code")
	private String tradeCode;

	@TableField(value = "create_time")
	private Date createTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Integer getPayMethod() {
		return payMethod;
	}

	public void setPayMethod(Integer payMethod) {
		this.payMethod = payMethod;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
