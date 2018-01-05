package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderOperateLog;
import com.qbt.persistent.mapper.OrderOperateLogMapper;
import com.qbt.service.OrderOperateLogService;

@Service
public class OrderOperateLogServiceImpl implements OrderOperateLogService {

	@Resource
	private OrderOperateLogMapper orderOperateLogMapper;
	
	@Override
	public int insert(OrderOperateLog log) {
		orderOperateLogMapper.insert(log);
		return log.getId();
	}

	@Override
	public OrderOperateLog findById(Integer id) {
		return orderOperateLogMapper.findById(id);
	}

	@Override
	public List<OrderOperateLog> findByOrderId(Integer orderId) {
		return orderOperateLogMapper.findByOrderId(orderId);
	}

	@Override
	public int insertByBatch(List<OrderOperateLog> logs) {
		return orderOperateLogMapper.insertByBatch(logs);
	}

}
