package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseSfSite;
import com.qbt.persistent.mapper.BaseSfSiteMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseSfSiteService;
@Service
public class BaseSfSiteServiceImpl implements BaseSfSiteService{
	
	@Resource
	private BaseSfSiteMapper baseSfSiteMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public List<BaseSfSite> findList() {
		return baseSfSiteMapper.findList();
	}

	@Override
	public BaseSfSite findById(int id) {
		String key = RedisKeyUtil.base_sf_site_id_key(id);
		BaseSfSite baseSfSite = RedisUtil.getByRedis(redisService.getMap(key), BaseSfSite.class);
		if(Checker.isEmpty(baseSfSite)){
			baseSfSite = baseSfSiteMapper.findById(id);
			if(Checker.isNotEmpty(baseSfSite)){
				redisService.putMap(key, RedisUtil.hashsMap(baseSfSite));
			}
		}
		return baseSfSite;
	}

	@Override
	public List<BaseSfSite> findByPage(PageEntity<BaseSfSite> pageEntity) {
		return baseSfSiteMapper.findByPage(pageEntity);
	}

	@Override
	public void update(BaseSfSite baseSfSite) {
		baseSfSiteMapper.updateById(baseSfSite);
		redisService.del(RedisKeyUtil.base_sf_site_id_key(baseSfSite.getId()));
		this.findById(baseSfSite.getId());
	}

	@Override
	public void add(BaseSfSite baseSfSite) {
		baseSfSiteMapper.insert(baseSfSite);
		if(baseSfSite.getId() > 0){
			String key = RedisKeyUtil.base_sf_site_id_key(baseSfSite.getId());
			redisService.putMap(key, RedisUtil.hashsMap(baseSfSite));
		}
	}

	@Override
	public List<BaseSfSite> findByCondition(BaseSfSite condition) {
		return baseSfSiteMapper.findByCondition(condition);
	}

	@Override
	public List<BaseSfSite> list() {
		return baseSfSiteMapper.list();
	}

	@Override
	public void deleteById(Integer id) {
		baseSfSiteMapper.deleteById(id);
	}

	@Override
	public int deleteById2(Integer id, Boolean isDelete) {
		int result = baseSfSiteMapper.deleteById2(id, isDelete);
		if(result > 0){
			redisService.del(RedisKeyUtil.base_sf_site_id_key(id));
			this.findById(id);
		}
		return result;
		
	}
	
}
