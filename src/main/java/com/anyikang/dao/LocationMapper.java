package com.anyikang.dao;

import java.util.List;

import com.anyikang.model.Location;
import com.anyikang.model.LocationCustom;

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
	
    //根据设备的id查询出定位的数据
    public List<Location> findLocationInfoByDeviceId(Integer deviceId);

    //根据设备的id和起始时间，终止时间查询
    public List<Location> findLocationByDeviceAndDateSection(LocationCustom locationCustom);

}
