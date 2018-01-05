package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.OrderOperateTypeEnum;
import com.qbt.common.enums.SettlementStatusEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.BossOrderSettlement;
import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.persistent.entity.OrderSettlement;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.OrderOperateLogService;
import com.qbt.service.OrderSettlementService;
import com.qbt.web.pojo.thirdOrder.ThirdOrderPageReqVo;
import com.qbt.web.pojo.thirdOrder.ThirdOrderVo;
import com.qbt.web.support.ThirdOrderSupport;

@Service
public class ThirdOrderSupportSupportImpl implements ThirdOrderSupport {
	
	@Resource
	private OrderSettlementService orderSettlementService;
	
	@Resource
	private OrderOperateLogService orderOperateLogService;
	
	@Override
	public List<ThirdOrderVo> findByPage(ThirdOrderPageReqVo reqVo) {
		PageEntity<BossOrderSettlement> pageEntity = BeanUtil.pageConvert(reqVo, BossOrderSettlement.class);
		BossOrderSettlement condition = pageEntity.getCondition();
		condition.setThirdType(2);////1-普通用户  2-合作旅行社
		List<BossOrderSettlement> list = orderSettlementService.findByPageForBoss(pageEntity);
		List<ThirdOrderVo> voList = BeanUtil.list2list(list, ThirdOrderVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public Boolean settlement(ThirdOrderVo vo) {
		OrderSettlement query = orderSettlementService.findById(vo.getId());
		if(Checker.isEmpty(query) || query.getSettleState() == SettlementStatusEnum.invalid_settlement.getCode()){
			throw new BusinessException("无效结算记录");
		}
		vo.setSettleState(SettlementStatusEnum.suc_settlement.getCode());
		OrderSettlement orderSettlement = BeanUtil.a2b(vo, OrderSettlement.class);
		int result1 = orderSettlementService.updateById(orderSettlement);
		
		//插入订单操作流水
		OrderOperateLog log = new OrderOperateLog();
		log.setOperatorType(OrderOperateTypeEnum.sys_kf.getCode());
		log.setOperatorId(vo.getSysUserId());
		log.setOperatorName(vo.getSysUserName());
		log.setOrderId(query.getOrderId());
		log.setAction("结算");
		log.setDescription("客服结算订单");
		int result2 = orderOperateLogService.insert(log);
		
		return result1 + result2 > 0;
	}

	@Override
	public Boolean settlementBatch(ThirdOrderPageReqVo vo, SysUser sysUser) {
		BossOrderSettlement condition = conbineSettlementBatchCondition(vo);
		List<BossOrderSettlement> queryList = orderSettlementService.findSettlementByBatch(condition);
		if(Checker.isEmpty(queryList)){
			return false;
		}
		
		OrderSettlement settlement = new OrderSettlement();
		settlement.setSettleState(SettlementStatusEnum.suc_settlement.getCode());
		settlement.setSysUserId(sysUser.getId());
		settlement.setSysUserName(sysUser.getName());
		settlement.setRemark(vo.getRemark());
		int result1 = orderSettlementService.settlementByBatch(settlement, condition);
		
		OrderOperateLog log = null;
		List<OrderOperateLog> logs = new ArrayList<OrderOperateLog>();
		for(BossOrderSettlement b : queryList){
			log = new OrderOperateLog();
			log.setOperatorType(OrderOperateTypeEnum.sys_kf.getCode());
			log.setOperatorId(sysUser.getId());
			log.setOperatorName(sysUser.getName());
			log.setOrderId(b.getOrderId());
			log.setAction("结算");
			log.setDescription("客服批量结算订单");
			logs.add(log);
		}
		int result2 = 0;
		if(Checker.isNotEmpty(logs)){
			result2 = orderOperateLogService.insertByBatch(logs);
		}
		
		return result1 + result2 > 0;
	}

	@Override
	public Boolean findSettlementBatch(ThirdOrderPageReqVo vo) {
		BossOrderSettlement condition = conbineSettlementBatchCondition(vo);
		List<BossOrderSettlement> queryList = orderSettlementService.findSettlementByBatch(condition);
		return Checker.isNotEmpty(queryList);
	}
	
	private BossOrderSettlement conbineSettlementBatchCondition(ThirdOrderPageReqVo vo){
		BossOrderSettlement condition = new BossOrderSettlement();
		condition.setStartDate(vo.getStartDate());
		condition.setEndDate(vo.getEndDate());
		condition.setThirdType(2);////1-普通用户  2-合作旅行社
		condition.setOrderNumber(vo.getOrderNumber());
		condition.setOrderStatus(vo.getOrderStatus());
		condition.setSettleModel(vo.getSettleModel());
		condition.setSettleState(SettlementStatusEnum.un_settlement.getCode());//未结算
		condition.setUserName(vo.getUserName());
		condition.setThirdId(vo.getThirdId());
		return condition;
	}
	
}
