package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.SysConfig;
import com.qbt.persistent.mapper.SysConfigMapper;
import com.qbt.service.SysConfigService;

@Service
public class SysConfigServiceImpl implements SysConfigService {
	@Resource
	private SysConfigMapper mapper;

	@Override
	public SysConfig findByCode(String code) {
		// TODO Auto-generated method stub
		return mapper.findByCode(code);
	}

	@Override
	public void updateByCode(SysConfig sysConifg) {
		// TODO Auto-generated method stub
		mapper.updateByCode(sysConifg);
		
	}

}
