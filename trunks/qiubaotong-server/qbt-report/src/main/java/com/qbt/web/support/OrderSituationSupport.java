package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderSituation.OrderSituationRequest;
import com.qbt.web.pojo.orderSituation.OrderSituationResponse;

public interface OrderSituationSupport {

	public List<OrderSituationResponse> findByPage(OrderSituationRequest req);

	public Map<String, Object> export(SysUser sysUser, String title, OrderSituationRequest req);
	
}
