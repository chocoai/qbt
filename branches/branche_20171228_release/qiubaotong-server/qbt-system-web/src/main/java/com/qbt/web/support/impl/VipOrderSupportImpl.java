package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.VipOrder;
import com.qbt.service.VipOrderService;
import com.qbt.service.VipPaymentService;
import com.qbt.web.pojo.vipOrder.VipOrderPageReqVo;
import com.qbt.web.pojo.vipOrder.VipOrderVo;
import com.qbt.web.support.VipOrderSupport;

@Service
public class VipOrderSupportImpl implements VipOrderSupport{

	@Resource
	private VipOrderService vipOrderService; 
	
	@Resource
	private VipPaymentService vipPaymentService;
	
	@Override
	public List<VipOrderVo> findByPage(VipOrderPageReqVo reqVo) {
		PageEntity<VipOrder> pageEntity = BeanUtil.pageConvert(reqVo, VipOrder.class);
		VipOrder condition = pageEntity.getCondition();
		condition.setCardSellStatus(1);//除了未售出的
		List<VipOrder> list = vipOrderService.findByPage(pageEntity);
		List<VipOrderVo> voList =  BeanUtil.list2list(list, VipOrderVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public VipOrderVo findById(Integer id) {
		VipOrder vipType =  vipOrderService.findById(id);
		return BeanUtil.a2b(vipType, VipOrderVo.class);
	}

	
	 /**
	  * @Title: upOrderSettlement
	  * @Description: TODO
	  * @author: chenxiaocong 2016年11月5日
	  * @modify: chenxiaocong 2016年11月5日
	  * @param id
	  * @return
	  * @see com.qbt.web.support.VipOrderSupport#upOrderSettlement(java.lang.Integer)
	  */
	
	@Override
	public boolean upOrderSettlement(Integer id) {
		VipOrder vipOrder =  vipOrderService.findById(id);
		
		boolean v = true;
		//更新订单
		vipOrder.setSettlementStatus(1);
		v = vipOrderService.updateById(vipOrder)>0?true:false;
		return v;
	}

}
