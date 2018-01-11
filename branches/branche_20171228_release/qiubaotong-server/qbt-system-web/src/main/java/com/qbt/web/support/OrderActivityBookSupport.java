package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.orderactivitybook.OrderActivityBookPageReqVo;
import com.qbt.web.pojo.orderactivitybook.OrderActivityBookVo;

public interface OrderActivityBookSupport {
	
	List<OrderActivityBookVo> findByPage(OrderActivityBookPageReqVo reqVo);
	
}
