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

	@TableId(value = "pay_id", type = IdType.UUID)
	private String payId;

	@TableField(value = "order_id")
	private Integer orderId;

	@TableField(value = "pay_type")
	private String payType;

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

	

	

	public String getPayId() {
		return payId;
	}

	public void setPayId(String payId) {
		this.payId = payId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
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

	@Override
	protected Serializable pkVal() {
		return this.payId;
	}
}
