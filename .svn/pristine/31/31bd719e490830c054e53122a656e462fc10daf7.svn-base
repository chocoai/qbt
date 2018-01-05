package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.dto.BossOrderRefund;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.OrderRefund;
import com.qbt.service.OrderInfoService;
import com.qbt.service.OrderRefundService;
import com.qbt.web.pojo.refund.OrderRefundVo;
import com.qbt.web.pojo.refund.RefundPageReqVo;
import com.qbt.web.support.OrderRefundSupport;

@Service
public class OrderRefundSupportImpl implements OrderRefundSupport {
	
	@Resource
	private OrderRefundService orderRefundService;
	
	@Resource
	private OrderInfoService orderInfoService;
	
	@Override
	public List<OrderRefundVo> findByPage(RefundPageReqVo reqVo) {
		PageEntity<BossOrderRefund> pageEntity = BeanUtil.pageConvert(reqVo, BossOrderRefund.class);
		List<BossOrderRefund> list = orderRefundService.findByPage(pageEntity);
		List<OrderRefundVo> voList = BeanUtil.list2list(list, OrderRefundVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public OrderRefundVo findById(Integer id) {
		OrderRefund refund = orderRefundService.findById(id);
		OrderRefundVo vo = BeanUtil.a2b(refund, OrderRefundVo.class);
		OrderInfo order = orderInfoService.findById(refund.getOrderId());
		vo.setOrderNumber(order.getNumber());
		return vo;
	}

	@Override
	public boolean update(OrderRefundVo vo) {
		//更新退款表状态
		OrderRefund refund = new OrderRefund();
		refund.setId(vo.getId());
		refund.setStatus(2);//1-待处理 2-已处理
		refund.setKfName(vo.getKfName());
		refund.setKfMobile(vo.getKfMobile());
		int c1 = orderRefundService.updateById(refund);
		
		//更新订单表状态
		OrderRefund query = orderRefundService.findById(vo.getId());
		OrderInfo orderInfo = orderInfoService.findById(query.getOrderId());
		orderInfo.setRefundStatus(4);//退款状态： 1-正常状态 2-待退款 3-退款中 4-退款完成 5-退款失败
		int c2 = orderInfoService.updateById(orderInfo);
		
		return c1 + c2 > 0;
	}

}
