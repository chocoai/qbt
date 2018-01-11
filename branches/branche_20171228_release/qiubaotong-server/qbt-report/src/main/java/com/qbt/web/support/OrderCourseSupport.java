package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.orderCourse.OrderCourseRequest;
import com.qbt.web.pojo.orderCourse.OrderCourseResponse;

public interface OrderCourseSupport {
	
	/**
	 * 球场汇总导出	 
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, String title, OrderCourseRequest req);
	
	/**
	 * 球场汇总分页查询
	 * @param req
	 * @return
	 */
	public List<OrderCourseResponse> findByPage(OrderCourseRequest req);
	
}
