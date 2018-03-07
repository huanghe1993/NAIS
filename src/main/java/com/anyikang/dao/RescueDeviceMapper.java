package com.anyikang.dao;


import java.util.Map;

import com.anyikang.model.vo.RescueDevice;


/**
 * 
 * @author LvXiaoxiong
 * @date 2017/07/13
 *
 */
public interface RescueDeviceMapper {

	
	
	/**
	 * 判断设备是否存在
	 * @param deviceIMEI
	 * @return
	 */
	public Map<String,Object> findDeviceByImei(String deviceIMEI );
	
    /**
     * 根据Imei号查询
     * @param deviceIMEI
     * @return
     */
    public RescueDevice findByDeviceNumber(String deviceIMEI);

    /**
     * 更新设备信息
     * @param device
     */
	public void modifyDevice(RescueDevice device);

	/**
	 * 更新设备信息（BLE）
	 * @param device
	 */
	public void modifyDeviceOfBle(RescueDevice device);

  
}
