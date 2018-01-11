package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.SysUser;
import com.qbt.service.SysUserService;
import com.qbt.web.support.TokenSupport;

@Service
public class TokenSupportImpl implements TokenSupport {
	
	@Resource
	private SysUserService sysUserService;
	
	@Override
	public SysUser tokenCheck(String token) {
		return sysUserService.tokenCheck(token);
	}


}
