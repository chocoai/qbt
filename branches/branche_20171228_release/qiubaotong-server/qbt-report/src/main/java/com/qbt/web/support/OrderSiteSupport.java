package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderSite.OrderSiteRequest;
import com.qbt.web.pojo.orderSite.OrderSiteResponse;

public interface OrderSiteSupport {
	
	/**
	 * 根据地域/球场汇总报表导出	 
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderSiteRequest req);
	
	/**
	 * 根据地域/球场汇总报表分页查询
	 * @param req
	 * @return
	 */
	public List<OrderSiteResponse> findByPage(OrderSiteRequest req);
}
