package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderSettlement;
import com.qbt.persistent.entity.OrderSettlement;

public interface OrderSettlementMapper {
	
	int insert(OrderSettlement orderSettlement);
	
	int updateById(OrderSettlement orderSettlement);
	
	List<BossOrderSettlement> findByPageForBoss(PageEntity<BossOrderSettlement> pageEntity);

	int updateByOrderId(OrderSettlement orderSettlement);
	
	OrderSettlement findById(@Param("id")Integer id);
	
	int settlementByBatch(@Param("settlement")OrderSettlement settlement, @Param("condition")BossOrderSettlement condition);
	
	OrderSettlement findByOrderId(@Param("orderId")Integer orderId);
	
	List<BossOrderSettlement> findSettlementByBatch(@Param("condition")BossOrderSettlement condition);
}
