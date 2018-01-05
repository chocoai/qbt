package com.qbt.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderMemo;
import com.qbt.persistent.mapper.OrderMemoMapper;
import com.qbt.service.OrderMemoService;

@Service
public class OrderMemoServiceImpl implements OrderMemoService {
	
	@Resource
	private OrderMemoMapper orderMemoMapper;
	
	@Override
	public int insert(OrderMemo memo) {
		orderMemoMapper.insert(memo);
		return memo.getId();
	}

	@Override
	public OrderMemo findById(Integer id) {
		return orderMemoMapper.selectById(id);
	}

	@Override
	public int updateById(OrderMemo memo) {
		return orderMemoMapper.updateById(memo);
	}

	@Override
	public List<OrderMemo> findByOrderId(Integer orderId) {
		return orderMemoMapper.selectByOrderId(orderId);
	}

	@Override
	public List<OrderMemo> findMemoByOrderDate(Date startDate, Date endDate) {
		return orderMemoMapper.findMemoByOrderDate(startDate, endDate);
	}

}
