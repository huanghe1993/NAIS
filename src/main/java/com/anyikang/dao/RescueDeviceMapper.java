package com.anyikang.dao;


import java.util.Map;

import com.anyikang.model.Device;
import com.anyikang.model.vo.RescueDevice;


/**
 * 
 * @author LvXiaoxiong
 * @date 2017/07/13
 *
 */
public interface RescueDeviceMapper {

	
	
	/**
	 * 根据Imei号获取到设备表的主键值deviceId的值,作为报警信息、定位信息外键值
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
