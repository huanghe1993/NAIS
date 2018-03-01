package com.anyikang.service;

import java.util.List;
import java.util.Map;

import com.anyikang.model.ProductAgreement;
import com.anyikang.model.ProductManual;
import com.anyikang.model.ProductVersion;
import com.anyikang.model.vo.LocatorDeviceMessage;
import com.anyikang.model.vo.LocatorDeviceStatus;


/**
 * 跌倒后台管理系统业务处理接口
 * @author Administrator
 *
 */
public interface RescueProductService {



	/**
	 * 查询版本更新次数
	 * @param versionDevice
	 * @return
	 */
	int findVersionUpdateTimes(int versionDevice);


	/**
	 * 添加版本信息
	 * @param pv
	 * @return
	 */
	boolean addProductVersion(ProductVersion pv);


	/**
	 * 查询最新版本信息
	 * @return
	 */
	List<Map<String,Object>> findVersion();


	/**
	 * 查询该版本的下载地址
	 * @param versionId
	 * @return
	 */
	String findDownloadLink(String versionId);


	/**
	 * 更新版本说明内容
	 * @param pm
	 * @return
	 */
	boolean addManual(ProductManual pm);


	/**
	 * 更新服务协议内容
	 * @param pa
	 * @return
	 */
	boolean addAgreement(ProductAgreement pa);


	/**
	 * 查询说明文档更新次数
	 * @param manualDevice
	 * @return
	 */
	int findManualUpdateTimes(String manualDevice);


	/**
	 * 查询服务协议更新次数
	 * @param agreementDevice
	 * @return
	 */
	int findAgreementUpdateTimes(String agreementDevice);


	/**
	 * 查询最新产品说明
	 * @return
	 */
	List<ProductManual>  findManual();


	/**
	 * 查询最新服务协议
	 * @return
	 */
	List<ProductAgreement> findAgreement();


	/**
	 * 查找app类型
	 * @return
	 */
	List<Map<String, Object>> findAppKinds();



	
}
