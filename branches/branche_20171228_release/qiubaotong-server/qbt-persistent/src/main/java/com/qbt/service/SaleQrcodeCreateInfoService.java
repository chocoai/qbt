package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleQrcodeCreateInfoDto;
import com.qbt.persistent.entity.SaleQrcodeCreateInfo;

public interface SaleQrcodeCreateInfoService {

	int insert(SaleQrcodeCreateInfo vo);

	List<SaleQrcodeCreateInfo> findByPage(PageEntity<SaleQrcodeCreateInfoDto> pageEntity);

	List<SaleQrcodeCreateInfo> findByCondition(SaleQrcodeCreateInfo condition);

	SaleQrcodeCreateInfo findById(Integer id);
	
	int updateById(SaleQrcodeCreateInfo createInfo);

	Integer getAutoMaxNawmeNumber();
}
