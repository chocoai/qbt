package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleSubcripbeInfoDto;
import com.qbt.persistent.dto.SaleWeixinSubcripbeInfoDto;
import com.qbt.persistent.entity.SaleWeixinSubcripbeInfo;

public interface SaleWeixinSubcripbeInfoService {

	List<SaleWeixinSubcripbeInfo> findByPage(PageEntity<SaleWeixinSubcripbeInfo> pageEntity);
	
	int insert(SaleWeixinSubcripbeInfo saleWeixinSubcripbeInfo);

	List<SaleSubcripbeInfoDto> reportSubcripbeInfoPage(PageEntity<SaleSubcripbeInfoDto> pageEntity);
	
	SaleWeixinSubcripbeInfoDto settleAbleInfo(SaleWeixinSubcripbeInfoDto dto);
	
	int settleOrder(SaleWeixinSubcripbeInfoDto dto);

	List<SaleWeixinSubcripbeInfo> findByPageBySaleId(PageEntity<SaleWeixinSubcripbeInfoDto> pageEntity);
	
	List<SaleSubcripbeInfoDto> wechatUserSubcripbeList(SaleSubcripbeInfoDto dto);
	
}
