package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseAirport;
import com.qbt.persistent.mapper.BaseAirportMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseAirportService;

@Service
public class BaseAirportServiceImpl implements BaseAirportService{
	
	@Resource
	private BaseAirportMapper baseAirportMapper; 
	
	@Resource
	private RedisService redisService;
	
	@Override
	public List<BaseAirport> findList() {
		return baseAirportMapper.findList();
	}

	@Override
	public BaseAirport findById(int id) {
		String key = RedisKeyUtil.base_airport_id_key(id);
		BaseAirport baseAirport = RedisUtil.getByRedis(redisService.getMap(key), BaseAirport.class);
		if(Checker.isEmpty(baseAirport)){
			baseAirport = baseAirportMapper.findById(id);
			if(Checker.isNotEmpty(baseAirport)){
				redisService.putMap(key, RedisUtil.hashsMap(baseAirport));
			}
		}
		return baseAirport;
	}

	@Override
	public int insert(BaseAirport baseAirport) {
		baseAirportMapper.insert(baseAirport);
		if(baseAirport.getId() > 0){
			redisService.putMap(RedisKeyUtil.base_airport_id_key(baseAirport.getId()), RedisUtil.hashsMap(baseAirport));
		}
		return baseAirport.getId();
	}

	@Override
	public int update(BaseAirport baseAirport) {
		if(baseAirport.getId() > 0){
			int count = baseAirportMapper.updateById(baseAirport);
			if(count > 0){
				redisService.del(RedisKeyUtil.base_airport_id_key(baseAirport.getId()));
				this.findById(baseAirport.getId());
			}
			return count;
		}
		return 0;
	}

	@Override
	public List<BaseAirport> findByPage(PageEntity<BaseAirport> pageEntity) {
		return baseAirportMapper.findByPage(pageEntity);
	}

	@Override
	public List<BaseAirport> findByCondition(BaseAirport baseAirport) {
		return baseAirportMapper.findByCondition(baseAirport);
	}

	@Override
	public int deleteById(Integer id) {
		int count = baseAirportMapper.deleteById(id);
		if(count > 0){
			redisService.del(RedisKeyUtil.base_airport_id_key(id));
		}
		return count;
	}

	@Override
	public List<BaseAirport> list() {
		return baseAirportMapper.list();
	}

	@Override
	public int delete(Integer id, Boolean isDelete) {
		int result = baseAirportMapper.delete(id, isDelete);
		if(result > 0){
			redisService.del(RedisKeyUtil.base_airport_id_key(id));
			this.findById(id);
		}
		return result;
	}
	
}
