package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossOrderSettlement;
import com.qbt.persistent.entity.OrderSettlement;
import com.qbt.persistent.mapper.OrderSettlementMapper;
import com.qbt.service.OrderSettlementService;

@Service
public class OrderSettlementServiceImpl implements OrderSettlementService {
	
	@Resource
	private OrderSettlementMapper orderSettlementMapper;
	
	@Override
	public int insert(OrderSettlement orderSettlement) {
		orderSettlementMapper.insert(orderSettlement);
		return orderSettlement.getId();
	}

	@Override
	public int updateById(OrderSettlement orderSettlement) {
		return orderSettlementMapper.updateById(orderSettlement);
	}

	@Override
	public List<BossOrderSettlement> findByPageForBoss(PageEntity<BossOrderSettlement> pageEntity) {
		return orderSettlementMapper.findByPageForBoss(pageEntity);
	}

	@Override
	public int updateByOrderId(OrderSettlement orderSettlement) {
		return orderSettlementMapper.updateByOrderId(orderSettlement);
	}
	
	public OrderSettlement findById(Integer id) {
		return orderSettlementMapper.findById(id);
	}

	@Override
	public int settlementByBatch(OrderSettlement settlement, BossOrderSettlement condition) {
		return orderSettlementMapper.settlementByBatch(settlement, condition);
	}

	@Override
	public OrderSettlement findByOrderId(Integer orderId) {
		return orderSettlementMapper.findByOrderId(orderId);
	}

	@Override
	public List<BossOrderSettlement> findSettlementByBatch(BossOrderSettlement condition) {
		return orderSettlementMapper.findSettlementByBatch(condition);
	}

}
