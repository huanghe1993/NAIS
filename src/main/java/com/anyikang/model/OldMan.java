package com.anyikang.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**   
 * @Title: oldman
 * @Description: oldman
 * @author jeeweb
 * @date 2017-07-31 16:53:26
 * @version V1.0   
 *
 */
@TableName("old_man")
public class OldMan extends Model<OldMan> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1041463737463754682L;
	/**mobile*/
    @TableField(value = "mobile")
	private String mobile;
    /**deviceId*/
    @TableField(value = "deviceid")
	private Integer deviceid;
    /**name*/
    @TableField(value = "name")
	private String name;
    /**address*/
    @TableField(value = "address")
	private String address;
    /**old_man_id*/
    @TableId(value = "id", type = IdType.UUID)
	private Integer oldManId;
    /**age*/
    @TableField(value = "age")
	private Integer age;
    /**sex*/
    @TableField(value = "sex")
	private Integer sex;
	
	/**
	 * 获取  mobile
	 *@return: String  mobile
	 */
	public String getMobile(){
		return this.mobile;
	}

	/**
	 * 设置  mobile
	 *@param: mobile  mobile
	 */
	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	/**
	 * 获取  deviceid
	 *@return: Integer  deviceId
	 */
	public Integer getDeviceid(){
		return this.deviceid;
	}

	/**
	 * 设置  deviceid
	 *@param: deviceid  deviceId
	 */
	public void setDeviceid(Integer deviceid){
		this.deviceid = deviceid;
	}
	/**
	 * 获取  name
	 *@return: String  name
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  name
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  address
	 *@return: String  address
	 */
	public String getAddress(){
		return this.address;
	}

	/**
	 * 设置  address
	 *@param: address  address
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * 获取  oldManId
	 *@return: Integer  old_man_id
	 */
	public Integer getOldManId(){
		return this.oldManId;
	}

	/**
	 * 设置  oldManId
	 *@param: oldManId  old_man_id
	 */
	public void setOldManId(Integer oldManId){
		this.oldManId = oldManId;
	}
	/**
	 * 获取  age
	 *@return: Integer  age
	 */
	public Integer getAge(){
		return this.age;
	}

	/**
	 * 设置  age
	 *@param: age  age
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	/**
	 * 获取  sex
	 *@return: Integer  sex
	 */
	public Integer getSex(){
		return this.sex;
	}

	/**
	 * 设置  sex
	 *@param: sex  sex
	 */
	public void setSex(Integer sex){
		this.sex = sex;
	}

	/* (non-Javadoc)
	 * @see com.baomidou.mybatisplus.activerecord.Model#pkVal()
	 */
	@Override
	protected Serializable pkVal() {
		// TODO Auto-generated method stub
		return this.oldManId;
	}
	
}
