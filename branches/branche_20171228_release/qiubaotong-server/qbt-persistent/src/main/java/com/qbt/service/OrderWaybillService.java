package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.OrderWaybill;

public interface OrderWaybillService {
	
	List<OrderWaybill> findByOrderId(Integer orderId);
	
	int insert(OrderWaybill orderWaybill);
	
	public int exists(String sfid);
}
