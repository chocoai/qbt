package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SaleQrcodeInfo;

public interface SaleQrcodeInfoService {

	public int getMaxId();
	
	List<SaleQrcodeInfo> findByPage(PageEntity<SaleQrcodeInfo> pageEntity);
	
	List<SaleQrcodeInfo> findList();
	
	//批量插入
	int insertByBatch(List<SaleQrcodeInfo> infos);
	
	SaleQrcodeInfo findByCode(String salesmanCode);
	
	int updateById(SaleQrcodeInfo saleQrcodeInfo);

	public List<String> findNoApplySalesmanCode();
	
	String getSysSalemanCode();
}
