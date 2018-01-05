package com.qbt.web.support;

import com.qbt.persistent.entity.SysUser;

public interface TokenSupport {
	
	/**
	 * token验证
	 * @param token
	 * @param userId
	 */
	public SysUser tokenCheck(String token);
	
}
