package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderFirst.OrderFirstRequest;
import com.qbt.web.pojo.orderFirst.OrderFirstResponse;

public interface OrderFirstSupport {

	public List<OrderFirstResponse> findByPage(OrderFirstRequest req);

	public Map<String, Object> export(SysUser sysUser, String title, OrderFirstRequest req);
	
}
