package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.orderexception.OrderExceptionBookVo;
import com.qbt.web.pojo.orderexception.OrderExceptionPageReqVo;

public interface OrderExceptionSupport {
	
	List<OrderExceptionBookVo> findByPage(OrderExceptionPageReqVo reqVo);
	
	boolean dealOrderException(OrderExceptionBookVo vo);
	
}
