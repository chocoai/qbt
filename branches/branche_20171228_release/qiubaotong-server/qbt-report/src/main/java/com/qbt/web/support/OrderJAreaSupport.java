package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderJArea.OrderJAreaRequest;
import com.qbt.web.pojo.orderJArea.OrderJAreaResponse;

public interface OrderJAreaSupport {
	
	/**
	 * 寄件人地域汇总导出	 
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderJAreaRequest req);
	
	/**
	 * 寄件人地域汇总分页查询
	 * @param req
	 * @return
	 */
	public List<OrderJAreaResponse> findByPage(OrderJAreaRequest req);
	
}
