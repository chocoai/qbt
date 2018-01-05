package com.qbt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseSfArea;
import com.qbt.persistent.mapper.BaseSfAreaMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseSfAreaService;

@Service
public class BaseSfAreaServiceImpl implements BaseSfAreaService{

	@Resource
	private BaseSfAreaMapper baseSfAreaMapper;
	@Resource
	private RedisService redisService;
	
	@Override
	public void add(BaseSfArea baseSfArea) {
		baseSfAreaMapper.insert(baseSfArea);
		Map<String,String> reidsmap = RedisUtil.hashsMap(baseSfArea);
		redisService.putMap(RedisKeyUtil.Area_Id_Redis_Key(baseSfArea.getId()), reidsmap);
		redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(baseSfArea.getName()), reidsmap);
	}

	@Override
	public List<BaseSfArea> findByCondition(BaseSfArea condition) {
		return baseSfAreaMapper.findByCondition(condition);
	}

	@Override
	public BaseSfArea findById(int id) {
		BaseSfArea baseSfArea = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.Area_Id_Redis_Key(id)), BaseSfArea.class);
		if(baseSfArea == null){
			baseSfArea = baseSfAreaMapper.findById(id);
			if(baseSfArea !=null){
				redisService.putMap(RedisKeyUtil.Area_Id_Redis_Key(baseSfArea.getId()), RedisUtil.hashsMap(baseSfArea));
			}
		}
		return baseSfArea;
		
	}

	@Override
	public List<BaseSfArea> findByParentId(int parentId, Boolean status) {
		return baseSfAreaMapper.findByParentId(parentId, status);
	}

	@Override
	public int update(BaseSfArea baseSfArea) {
		int result = baseSfAreaMapper.updateById(baseSfArea);
		if(result > 0){
			baseSfArea = baseSfAreaMapper.findById(baseSfArea.getId());
			// 保存Redis
			Map<String,String> reidsmap = RedisUtil.hashsMap(baseSfArea);
			redisService.putMap(RedisKeyUtil.Area_Id_Redis_Key(baseSfArea.getId()), reidsmap);
			redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(baseSfArea.getName()), reidsmap);
		}
		return result;
	}

	@Override
	public BaseSfArea findByName(String name, Boolean status) {
		BaseSfArea baseSfArea = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.Area_Name_Redis_Key(name)), BaseSfArea.class);
		if(baseSfArea == null){
			baseSfArea = baseSfAreaMapper.findByName(name, status);
			if(baseSfArea !=null){
				redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(name), RedisUtil.hashsMap(baseSfArea));
			}
		}
		return baseSfArea;
	}

	@Override
	public BaseSfArea findByDistrict(String name, String district) {
		BaseSfArea baseSfArea = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.Area_Name_Redis_Key(name+district)), BaseSfArea.class);
		if(baseSfArea == null){
			baseSfArea = baseSfAreaMapper.findByDistrict(name,district);
			if(baseSfArea !=null){
				redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(name+district), RedisUtil.hashsMap(baseSfArea));
			}
		}
		return baseSfArea;
	}

	@Override
	public List<BaseSfArea> findByLevel(int level) {
		return baseSfAreaMapper.findByLevel(level);
	}

	@Override
	public List<BaseSfArea> list() {
		return baseSfAreaMapper.list();
	}

	@Override
	public List<BaseSfArea> findByLevelCourse(int level) {
		return baseSfAreaMapper.findByLevelCourse(level);
	}

	@Override
	public List<BaseSfArea> findDistrictById(int id) {
		// TODO Auto-generated method stub
		return baseSfAreaMapper.findDistrictById(id);
	}

}
