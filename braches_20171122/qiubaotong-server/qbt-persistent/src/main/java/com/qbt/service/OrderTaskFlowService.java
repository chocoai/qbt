package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.OrderTaskFlow;

public interface OrderTaskFlowService {
	
	int insert(OrderTaskFlow taskFlow);
	
	int deleteById(Integer id);
	
	List<OrderTaskFlow> findByType(Integer type);
	
	int deleteByDay(int day);
}
