package com.anyikang.dao;


import com.anyikang.model.Location;

/**
 * Created by huanghe on 2017/3/30.
 */
public interface LocationMapper {
	/**
	 * 存储定位数据
	 * @param location
	 * @return
	 */
	public int addLocationMessage(Location location);
	

}
