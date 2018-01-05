package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderArea.OrderAreaRequest;
import com.qbt.web.pojo.orderArea.OrderAreaResponse;

public interface OrderAreaSupport {
	
	/**
	 * 根据地域汇总报表导出	 
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderAreaRequest req);
	
	/**
	 * 根据地域汇总报表分页查询
	 * @param req
	 * @return
	 */
	public List<OrderAreaResponse> findByPage(OrderAreaRequest req);
	
}
