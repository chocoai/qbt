package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderTaskFlow;
import com.qbt.persistent.mapper.OrderTaskFlowMapper;
import com.qbt.service.OrderTaskFlowService;

@Service
public class OrderTaskFlowServiceImpl implements OrderTaskFlowService {
	
	@Resource
	private OrderTaskFlowMapper orderTaskFlowMapper;
	
	@Override
	public int insert(OrderTaskFlow taskFlow) {
		orderTaskFlowMapper.insert(taskFlow);
		return taskFlow.getId();
	}

	@Override
	public int deleteById(Integer id) {
		return orderTaskFlowMapper.deleteById(id);
	}

	@Override
	public List<OrderTaskFlow> findByType(Integer type) {
		return orderTaskFlowMapper.findByType(type);
	}

	@Override
	public int deleteByDay(int day) {
		return orderTaskFlowMapper.deleteByDay(day);
	}

}
