package com.qbt.service;


import com.qbt.persistent.entity.SysConfig;

public interface SysConfigService {
	SysConfig findByCode(String code);
	void updateByCode(SysConfig sysConifg);
}
