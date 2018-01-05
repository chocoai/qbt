package com.qbt.web.support;

import java.util.List;
import java.util.Map;

import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.userOrderCountTime.UserOrderCountTimeRequest;
import com.qbt.web.pojo.userOrderCountTime.UserOrderCountTimeResponse;

public interface UserOrderCountTimeSupport {
	
	/**
	 * 导出
	 * @param sysUser
	 * @param title
	 * @param req
	 * @return
	 */
	public Map<String, Object> export(SysUser sysUser, UserOrderCountTimeRequest req);
	
	/**
	 * 分页查询
	 * @param req
	 * @return
	 */
	public List<UserOrderCountTimeResponse> findByPage(UserOrderCountTimeRequest req);
	
}
