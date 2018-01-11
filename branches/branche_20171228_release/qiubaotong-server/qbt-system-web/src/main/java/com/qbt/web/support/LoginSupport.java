package com.qbt.web.support;

import com.qbt.common.exception.BusinessException;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.login.LoginReqVo;
import com.qbt.web.pojo.login.LoginRespVo;

public interface LoginSupport {
	
	/**
	 * token验证
	 * @param token
	 * @param userId
	 */
	public SysUser tokenCheck(String token);
	
	/**
	 * 后台用户登出
	 * @param token
	 */
	public void logout(String token);
	
	/**
	 * 后台用户登录
	 * @param reqVo
	 * @return
	 */
	public LoginRespVo login(LoginReqVo reqVo)throws BusinessException, Exception;
	
}
