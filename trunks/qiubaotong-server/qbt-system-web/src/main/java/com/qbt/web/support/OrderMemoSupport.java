package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.order.OrderMemoVo;

public interface OrderMemoSupport {
	
	List<OrderMemoVo> findByOrderId(Integer orderId);
	
	int add(OrderMemoVo vo);
}
