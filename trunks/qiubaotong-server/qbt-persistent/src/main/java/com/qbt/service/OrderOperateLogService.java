package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.OrderOperateLog;

public interface OrderOperateLogService {

	public int insert(OrderOperateLog log);
	
	public OrderOperateLog findById(Integer id);
	
	public List<OrderOperateLog> findByOrderId(Integer orderId);
	
	public int insertByBatch(List<OrderOperateLog> logs);
}
