package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseBspAreaConfig;
import com.qbt.persistent.mapper.BaseBspAreaConfigMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseBspAreaConfigService;

@Service
public class BaseBspAreaConfigServiceImpl implements BaseBspAreaConfigService {
	
	@Resource
	private BaseBspAreaConfigMapper baseBspAreaConfigMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public int insert(BaseBspAreaConfig config) {
		baseBspAreaConfigMapper.insert(config);
		if(config.getId() > 0){
			String key = RedisKeyUtil.base_sf_bsp_area_config_areaname_key(config.getSrcCity(), config.getSrcCountry());
			redisService.putMap(key, RedisUtil.hashsMap(config));
		}
		return config.getId();
	}

	@Override
	public int deleteById(Integer id) {
		BaseBspAreaConfig config = this.findById(id);
		if(Checker.isNotEmpty(config)){
			String key = RedisKeyUtil.base_sf_bsp_area_config_areaname_key(config.getSrcCity(), config.getSrcCountry());
			redisService.del(key);
		}
		return baseBspAreaConfigMapper.deleteById(id);
	}

	@Override
	public List<BaseBspAreaConfig> findByPage(PageEntity<BaseBspAreaConfig> pageEntity) {
		return baseBspAreaConfigMapper.findByPage(pageEntity);
	}

	@Override
	public BaseBspAreaConfig findById(Integer id) {
		return baseBspAreaConfigMapper.findById(id);
	}

	@Override
	public BaseBspAreaConfig findBySrcArea(String srcCity, String srcCountry) {
		String key = RedisKeyUtil.base_sf_bsp_area_config_areaname_key(srcCity, srcCountry);
		BaseBspAreaConfig config = RedisUtil.getByRedis(redisService.getMap(key), BaseBspAreaConfig.class);
		if(Checker.isEmpty(config)){
			List<BaseBspAreaConfig> list = baseBspAreaConfigMapper.findBySrcArea(srcCity, srcCountry);
			if(Checker.isNotEmpty(list)){
				config = list.get(list.size() - 1);//取最新的一个
				redisService.putMap(key, RedisUtil.hashsMap(config));
			}
		}
		return config;
	}

}
