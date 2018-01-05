package com.qbt.service;

import java.util.Date;
import java.util.List;

import com.qbt.persistent.entity.OrderMemo;

public interface OrderMemoService {
	
	int insert(OrderMemo memo);

    OrderMemo findById(Integer id);

    int updateById(OrderMemo memo);
    
    List<OrderMemo> findByOrderId(Integer orderId);
    
    List<OrderMemo> findMemoByOrderDate(Date startDate, Date endDate);
}
