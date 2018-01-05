package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.OrderMemo;
import com.qbt.service.OrderMemoService;
import com.qbt.web.pojo.order.OrderMemoVo;
import com.qbt.web.support.OrderMemoSupport;

@Service
public class OrderMemoSupportImpl implements OrderMemoSupport {
	
	@Resource
	private OrderMemoService orderMemoService;
	
	@Override
	public List<OrderMemoVo> findByOrderId(Integer orderId) {
		List<OrderMemo> list = orderMemoService.findByOrderId(orderId);
		List<OrderMemoVo> voList = BeanUtil.list2list(list, OrderMemoVo.class);
		return voList;
	}

	@Override
	public int add(OrderMemoVo vo) {
		OrderMemo memo = BeanUtil.a2b(vo, OrderMemo.class);
		return orderMemoService.insert(memo);
	}

}
