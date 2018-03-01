package com.anyikang.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.anyikang.model.ProductAgreement;
import com.anyikang.model.ProductManual;
import com.anyikang.model.ProductVersion;

/**
 * 跌倒后台管理系统 各种信息查询
 * @author LvXiaoxiong 2017/07/13
 *
 */
public interface RescueProductMapper {



	/**
	 * 查询版本更改次数
	 * @param versionDevice
	 * @return
	 */
	int findVersionUpdateTimes(int versionDevice);


	/**
	 * 添加版本信息
	 * @param pv
	 * @return
	 */
	int addProductVersion(ProductVersion pv);


	/**
	 * 查询最新版本信息
	 * @return
	 */
	List<Map<String,Object>> findVersion();


	/**
	 * 根据Id查询版本下载地址
	 * @param versionId
	 * @return
	 */
	String findDownloadLink(@Param(value="versionId") String versionId);


	/**
	 * 添加版本说明
	 * @param pm
	 * @return
	 */
	int addManual(ProductManual pm);


	/**
	 * 添加服务协议
	 * @param pa
	 * @return
	 */
	int addAgreement(ProductAgreement pa);


	/**
	 * 查询版本说明更新次数
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
	List<ProductManual> findManual();
	
	
	/**
	 * 查询最新产品说明
	 * @return
	 */
	List<ProductAgreement> findAgreement();


	/**
	 * 查询app类型
	 * @return
	 */
	List<Map<String, Object>> findAppKinds();
	
	
}
