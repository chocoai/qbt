package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderPartner.OrderPartnerRequest;
import com.qbt.web.pojo.orderPartner.OrderPartnerResponse;

public interface OrderPartnerSupport {
	
	/**
	 * 合作方订单导出
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderPartnerRequest req);
	
	/**
	 * 合作方订单分页查询
	 * @param req
	 * @return
	 */
	public List<OrderPartnerResponse> findByPage(OrderPartnerRequest req);

}
