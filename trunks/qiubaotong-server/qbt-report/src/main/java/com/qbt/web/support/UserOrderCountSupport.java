package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.userOrderCount.UserOrderCountRequest;
import com.qbt.web.pojo.userOrderCount.UserOrderCountResponse;

public interface UserOrderCountSupport {
	
	/**
	 * 导出
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, UserOrderCountRequest req);
	
	/**
	 * 分页查询
	 * @param req
	 * @return
	 */
	public List<UserOrderCountResponse> findByPage(UserOrderCountRequest req);
	
}
