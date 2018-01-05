package com.qbt.web.support;

import com.qbt.persistent.entity.SysUser;

public interface SysConfigSupport {
	
	String findByCode(String code);
	void updateByCode(String code,String value,SysUser sysUser);
}
