package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleQrcodeCreateInfoDto;
import com.qbt.persistent.entity.SaleQrcodeCreateInfo;

public interface SaleQrcodeCreateInfoMapper {
	
	int insert(SaleQrcodeCreateInfo record);

    SaleQrcodeCreateInfo selectById(Integer id);

    int updateById(SaleQrcodeCreateInfo record);

	List<SaleQrcodeCreateInfo> findByPage(PageEntity<SaleQrcodeCreateInfoDto> pageEntity);

	List<SaleQrcodeCreateInfo> findByCondition(SaleQrcodeCreateInfo condition);

	Integer getAutoMaxNawmeNumber();
}