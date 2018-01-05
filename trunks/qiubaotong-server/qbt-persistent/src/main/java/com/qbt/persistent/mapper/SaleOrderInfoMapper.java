package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.entity.SaleOrderInfo;

public interface SaleOrderInfoMapper {
	
    int insert(SaleOrderInfo record);

    SaleOrderInfo findById(Integer id);

    int update(SaleOrderInfo record);

	void updateStatus(@Param("orderId")int orderId, @Param("status")int status);
    
	List<SaleOrderInfoDto> reportOrderInfoPage(PageEntity<SaleOrderInfoDto> pageEntity);
	
	SaleOrderInfoDto settleAbleInfo(SaleOrderInfoDto dto);
	
	int settleOrder(SaleOrderInfoDto dto);

	List<SaleOrderInfo> findByPageBySaleId(PageEntity<SaleOrderInfoDto> pageEntity);
	
	List<SaleOrderInfoDto> wechatUserOrderList(SaleOrderInfoDto dto);
}