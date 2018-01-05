package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderDetail.OrderDetailRequest;
import com.qbt.web.pojo.orderDetail.OrderDetailResponse;

public interface OrderDetailSupport {
	
	/**
	 * 订单明细查询报表导出
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderDetailRequest req);
	
	/**
	 * 订单明细查询报表分页查询
	 * @param req
	 * @return
	 */
	public List<OrderDetailResponse> findByPage(OrderDetailRequest req);
	
}
