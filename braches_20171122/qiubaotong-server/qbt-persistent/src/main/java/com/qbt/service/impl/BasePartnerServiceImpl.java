package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BasePartner;
import com.qbt.persistent.mapper.BasePartnerMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BasePartnerService;

@Service
public class BasePartnerServiceImpl implements BasePartnerService {
	
	@Resource
	private BasePartnerMapper basePartnerMapper;
	@Resource
	private RedisService redisService;
	
	@Override
	public List<BasePartner> findByCondition(BasePartner condition) {
		return basePartnerMapper.findByCondition(condition);
	}

	@Override
	public void insert(BasePartner basePartner) {
		basePartnerMapper.insert(basePartner);
		redisService.putMap(RedisKeyUtil.Base_partner_Redis_Key(basePartner.getId()), RedisUtil.hashsMap(basePartner));
	}

	@Override
	public List<BasePartner> findByPage(PageEntity<BasePartner> pageEntity) {
		return basePartnerMapper.findByPage(pageEntity);
	}

	@Override
	public void update(BasePartner basePartner) {
		basePartnerMapper.updateByPrimaryKeySelective(basePartner);
		redisService.putMap(RedisKeyUtil.Base_partner_Redis_Key(basePartner.getId()), RedisUtil.hashsMap(basePartner));
	}

	@Override
	public BasePartner findById(Integer id) {
		String key = RedisKeyUtil.Base_partner_Redis_Key(id);
		BasePartner basePartner= RedisUtil.getByRedis(redisService.getMap(key), BasePartner.class);
		if(Checker.isEmpty(basePartner)){
			basePartner = basePartnerMapper.findById(id);
			if(Checker.isNotEmpty(basePartner)){
				redisService.putMap(key, RedisUtil.hashsMap(basePartner));
			}
		}
		return basePartner;
	}

	@Override
	public void updateStatus(Integer id, int status) {
		basePartnerMapper.updateStatus(id, status);
		String key = RedisKeyUtil.Base_partner_Redis_Key(id);
		redisService.del(key);
		this.findById(id);
		
	}

	@Override
	public List<BasePartner> findAll(int type) {
		return basePartnerMapper.findAll(type);
	}

}
