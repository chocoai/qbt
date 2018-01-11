package com.qbt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseArea;
import com.qbt.persistent.mapper.BaseAreaMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseAreaService;


/**
 * 地区信息服务
 * @author share
 *
 */
@Service
public class BaseAreaServiceImpl implements BaseAreaService {

	@Resource
	private RedisService redisService;
	@Resource
	private BaseAreaMapper baseAreaMapper;
	
	
	@Override
	public void insert(BaseArea area) {
		baseAreaMapper.insert(area);
		// 保存Redis
		Map<String,String> reidsmap = RedisUtil.hashsMap(area);
		redisService.putMap(RedisKeyUtil.Area_Id_Redis_Key(area.getId()), reidsmap);
		redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(area.getName()), reidsmap);
	}

	@Override
	public BaseArea findById(int id) {
		BaseArea area = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.Area_Id_Redis_Key(id)), BaseArea.class);
		if(area == null){
			area = baseAreaMapper.findById(id);
			if(area !=null){
				redisService.putMap(RedisKeyUtil.Area_Id_Redis_Key(area.getId()), RedisUtil.hashsMap(area));
			}
		}
		return area;
	}

	@Override
	public List<BaseArea> findBySuperId(int superId) {
		return baseAreaMapper.findBySupperId(superId);
	}

	@Override
	public int update(BaseArea area) {
		int result = baseAreaMapper.updateById(area);
		if(result > 0){
			area = baseAreaMapper.findById(area.getId());
			// 保存Redis
			Map<String,String> reidsmap = RedisUtil.hashsMap(area);
			redisService.putMap(RedisKeyUtil.Area_Id_Redis_Key(area.getId()), reidsmap);
			redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(area.getName()), reidsmap);
		}
		return result;
	}

	@Override
	public BaseArea findByName(String name) {
		BaseArea area = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.Area_Name_Redis_Key(name)),BaseArea.class);
		if(area == null){
			area = baseAreaMapper.findByName(name);
			if(area !=null){
				redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(name), RedisUtil.hashsMap(area));
			}
		}
		return area;
	}

	@Override
	public List<BaseArea> findByLevel(int level) {
		return baseAreaMapper.findByLevel(level);
	}

	@Override
	public BaseArea findByName(String city, String district) {
		BaseArea area = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.Area_Name_Redis_Key(city+district)), BaseArea.class);
		if(area == null){
			area = baseAreaMapper.findByDistrict(city,district);
			if(area !=null){
				redisService.putMap(RedisKeyUtil.Area_Name_Redis_Key(city+district), RedisUtil.hashsMap(area));
			}
		}
		return area;
	}

}
