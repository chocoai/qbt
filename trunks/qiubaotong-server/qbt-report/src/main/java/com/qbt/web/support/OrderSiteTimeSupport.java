package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderSiteTime.OrderSiteTimeRequest;
import com.qbt.web.pojo.orderSiteTime.OrderSiteTimeResponse;

public interface OrderSiteTimeSupport {
	
	/**
	 * 根据地域/球场取包时间汇总报表导出	 
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderSiteTimeRequest req);
	
	/**
	 * 根据地域/球场取包时间汇总报表分页查询
	 * @param req
	 * @return
	 */
	public List<OrderSiteTimeResponse> findByPage(OrderSiteTimeRequest req);
}
