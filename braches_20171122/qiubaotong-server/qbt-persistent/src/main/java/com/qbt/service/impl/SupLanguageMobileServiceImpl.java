package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.SupLanguageMobile;
import com.qbt.persistent.mapper.SupLanguageMobileMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.SupLanguageMobileService;

@Service
public class SupLanguageMobileServiceImpl implements SupLanguageMobileService {

	@Resource
	private SupLanguageMobileMapper supLanguageMobileMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public int insert(SupLanguageMobile mobile) {
		int flag = supLanguageMobileMapper.insert(mobile);
		if(flag > 0){
			redisService.putSet(RedisKeyUtil.language_mobile_key(), mobile.getMobile());
		}
		return mobile.getId();	
	}

	@Override
	public int delete(String mobile) {
		int flag = supLanguageMobileMapper.delete(mobile);
		if(flag > 0){
			redisService.srem(RedisKeyUtil.language_mobile_key(), mobile);
		}
		
		return flag;
	}

	@Override
	public List<SupLanguageMobile> findByPage(PageEntity<SupLanguageMobile> page) {
		return supLanguageMobileMapper.findByPage(page);
	}

	@Override
	public boolean exists(String mobile) {
		return redisService.sismember(RedisKeyUtil.language_mobile_key(), mobile);
	}

	@Override
	public List<String> findAllMobile() {
		return supLanguageMobileMapper.findAllMobile();
	}
	
}
