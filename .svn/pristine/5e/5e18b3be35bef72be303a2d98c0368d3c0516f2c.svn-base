package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderJCourse.OrderJCourseRequest;
import com.qbt.web.pojo.orderJCourse.OrderJCourseResponse;

public interface OrderJCourseSupport {
	
	/**
	 * 寄件人球场汇总导出	 
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderJCourseRequest req);
	
	/**
	 * 寄件人球场汇总分页查询
	 * @param req
	 * @return
	 */
	public List<OrderJCourseResponse> findByPage(OrderJCourseRequest req);
	
}
