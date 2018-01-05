package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.SaleOrderInfoDto;
import com.qbt.persistent.entity.SaleOrderInfo;

public interface SaleOrderInfoService {

	List<SaleOrderInfo> findByPage(PageEntity<SaleOrderInfo> pageEntity);
	
	int insert(SaleOrderInfo saleOrderInfo);

	void updateStatus(int orderId, int status);

	List<SaleOrderInfoDto> reportOrderInfoPage(PageEntity<SaleOrderInfoDto> pageEntity);
	
	SaleOrderInfoDto settleAbleInfo(SaleOrderInfoDto dto);
	
	int settleOrder(SaleOrderInfoDto dto);

	List<SaleOrderInfo> findByPageBySaleId(PageEntity<SaleOrderInfoDto> pageEntity);
	
	List<SaleOrderInfoDto> wechatUserOrderList(SaleOrderInfoDto dto);
}
