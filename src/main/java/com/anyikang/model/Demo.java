package com.anyikang.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @author wangwei
 * @date 2017年8月25日
 */
@TableName("demo")
public class Demo extends Model<Demo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8408829111775883998L;

	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	private String name;
	private String password;

	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}
}
