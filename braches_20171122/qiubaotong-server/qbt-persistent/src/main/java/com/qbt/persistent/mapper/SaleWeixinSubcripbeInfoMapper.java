package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleSubcripbeInfoDto;
import com.qbt.persistent.dto.SaleWeixinSubcripbeInfoDto;
import com.qbt.persistent.entity.SaleWeixinSubcripbeInfo;

public interface SaleWeixinSubcripbeInfoMapper {
	
    int insert(SaleWeixinSubcripbeInfo record);

    SaleWeixinSubcripbeInfo findById(Integer id);

    int update(SaleWeixinSubcripbeInfo record);
    
	List<SaleSubcripbeInfoDto> reportSubcripbeInfoPage(PageEntity<SaleSubcripbeInfoDto> pageEntity);
   
	int updateById(SaleWeixinSubcripbeInfo record);
    
    SaleWeixinSubcripbeInfoDto settleAbleInfo(SaleWeixinSubcripbeInfoDto dto);
	
	int settleOrder(SaleWeixinSubcripbeInfoDto dto);

	List<SaleWeixinSubcripbeInfo> findByPageBySaleId(PageEntity<SaleWeixinSubcripbeInfoDto> pageEntity);
	
	List<SaleSubcripbeInfoDto> wechatUserSubcripbeList(SaleSubcripbeInfoDto dto);
}