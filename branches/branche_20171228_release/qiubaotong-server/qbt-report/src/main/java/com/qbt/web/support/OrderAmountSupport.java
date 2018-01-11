package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderAmount.OrderAmountRequest;
import com.qbt.web.pojo.orderAmount.OrderAmountResponse;

public interface OrderAmountSupport {
	
	/**
	 * 订单金额明细查询报表导出
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderAmountRequest req);
	
	/**
	 * 订单金额明细查询报表分页查询
	 * @param req
	 * @return
	 */
	public List<OrderAmountResponse> findByPage(OrderAmountRequest req);
	
}
