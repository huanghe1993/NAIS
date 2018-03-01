package com.anyikang.service.impl;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyikang.dao.RescueProductMapper;
import com.anyikang.model.ProductAgreement;
import com.anyikang.model.ProductManual;
import com.anyikang.model.ProductVersion;
import com.anyikang.service.RescueProductService;



/**
 * 跌倒后台管理 信息查询业务处理
 * @author LvXiaoxiong 
 * @date 2017/11/29
 */
@Service
public class RescueProductServiceImpl implements RescueProductService {

	
	@Autowired
	private RescueProductMapper rescueProductMapper;
	
	@Override
	public int findVersionUpdateTimes(int versionDevice) {
		return rescueProductMapper.findVersionUpdateTimes(versionDevice);
	}



	@Override
	public boolean addProductVersion(ProductVersion pv) {
		int n =rescueProductMapper.addProductVersion(pv);
		return n==1;
	}



	@Override
	public List<Map<String,Object>> findVersion() {
		return rescueProductMapper.findVersion();
	}



	@Override
	public String findDownloadLink(String versionId) {
		return rescueProductMapper.findDownloadLink(versionId);
	}



	@Override
	public boolean addManual(ProductManual pm) {
		
		int n = rescueProductMapper.addManual(pm);
		return n==1;
	}



	@Override
	public boolean addAgreement(ProductAgreement pa) {
		int n = rescueProductMapper.addAgreement(pa);
		return n==1;
	}



	@Override
	public int findManualUpdateTimes(String manualDevice) {
		return rescueProductMapper.findManualUpdateTimes(manualDevice);
	}



	@Override
	public int findAgreementUpdateTimes(String agreementDevice) {
		return rescueProductMapper.findAgreementUpdateTimes(agreementDevice);
	}



	@Override
	public List<ProductManual> findManual() {
		List<ProductManual> list = rescueProductMapper.findManual();
		if(list==null||list.size()==0){
			return null;
		}
		return list;
	}



	@Override
	public List<ProductAgreement> findAgreement() {
		List<ProductAgreement> list = rescueProductMapper.findAgreement();
		if(list==null||list.size()==0){
			return null;
		}
		return list;
	}



	@Override
	public List<Map<String, Object>> findAppKinds() {
		return rescueProductMapper.findAppKinds();
	}
	
}
