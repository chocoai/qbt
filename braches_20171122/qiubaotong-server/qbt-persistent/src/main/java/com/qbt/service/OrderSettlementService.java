package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderSettlement;
import com.qbt.persistent.entity.OrderSettlement;

public interface OrderSettlementService {
	
	int insert(OrderSettlement orderSettlement);
	
	int updateById(OrderSettlement orderSettlement);
	
	int updateByOrderId(OrderSettlement orderSettlement);
	
	List<BossOrderSettlement> findByPageForBoss(PageEntity<BossOrderSettlement> pageEntity);
	
	OrderSettlement findById(Integer id);
	
	int settlementByBatch(OrderSettlement settlement, BossOrderSettlement condition);
	
	OrderSettlement findByOrderId(Integer orderId);
	
	List<BossOrderSettlement> findSettlementByBatch(BossOrderSettlement condition);
	
}
