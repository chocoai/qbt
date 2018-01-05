package com.qbt.web.support.impl;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.SysConfig;
import com.qbt.persistent.entity.SysUser;
import com.qbt.redis.RedisService;
import com.qbt.service.SysConfigService;
import com.qbt.web.support.SysConfigSupport;

@Service
public class SysConfigSupportImpl implements SysConfigSupport {
	
	@Resource
	private SysConfigService sysConfigService;
	
	@Resource
	private RedisService redisService;

	@Override
	public String findByCode(String code) {
		// TODO Auto-generated method stub
		String key = RedisKeyUtil.sys_config_code_key(code);
		String value = redisService.get(key);
		if(StringUtils.isEmpty(value)){
			SysConfig sysConfig = sysConfigService.findByCode(code);
			redisService.putString(key, sysConfig.getValue());
			return sysConfig.getValue();
		}else{
			return value;
		}
	}

	@Override
	public void updateByCode(String code,String value,SysUser sysUser) {
		SysConfig sysConifg = new SysConfig();
		sysConifg.setCode(code);
		sysConifg.setValue(value);
		sysConifg.setOperater(sysUser.getId());
		sysConifg.setOperaterName(sysUser.getName());
		
		sysConfigService.updateByCode(sysConifg);
		String key = RedisKeyUtil.sys_config_code_key(code);
		redisService.del(key);
		
	}
	
	
	
}
