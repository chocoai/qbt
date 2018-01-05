package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.OrderWaybill;

public interface OrderWaybillMapper {
	
    int insert(OrderWaybill info);

    OrderWaybill findById(Integer id);

    int updateById(OrderWaybill record);
    
    List<OrderWaybill> findByOrderId(Integer orderId);

	int exists(String sfid);
    
}