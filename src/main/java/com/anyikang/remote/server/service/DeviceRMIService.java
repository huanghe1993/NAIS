/**
 * 
 */
package com.anyikang.remote.server.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.anyikang.model.Device;

/**
 * @author wangwei
 * @date 2017年4月17日
 */
public interface DeviceRMIService extends Remote{

	public List<Device> getDevices() throws RemoteException;
}
