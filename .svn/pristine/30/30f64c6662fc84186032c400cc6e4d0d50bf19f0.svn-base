package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.mapper.ActivityMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
	
	@Resource
	private ActivityMapper activityMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public List<Activity> findByPage(PageEntity<Activity> pageEntity) {
		return activityMapper.findByPage(pageEntity);
	}

	@Override
	public Activity findById(Integer id) {
		return activityMapper.selectById(id);
	}

	@Override
	public int insert(Activity activity) {
		int count = activityMapper.insert(activity);
		if(count > 0){
			redisService.putMap(RedisKeyUtil.Activity_Code_Redis_Key(activity.getCode()), RedisUtil.hashsMap(activity));
		}
		return activity.getId();
	}

	@Override
	public int update(Activity activity) {
		if(activity.getId() > 0){
			int count = activityMapper.updateById(activity);
			if(count > 0){
				redisService.putMap(RedisKeyUtil.Activity_Code_Redis_Key(activity.getCode()), RedisUtil.hashsMap(activity));
			}
			return count;
		}
		return 0;
	}

	@Override
	public List<Activity> findByCondition(Activity activity) {
		return activityMapper.findByCondition(activity);
	}

	@Override
	public int isExist(String name, String code) {
		return activityMapper.isExist(name, code);
	}

	@Override
	public Activity findByCode(String code) {
		Activity activity = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.Activity_Code_Redis_Key(code)), Activity.class);
		if(Checker.isEmpty(activity)){
			Activity condition = new Activity();
			condition.setCode(code);
			List<Activity> qryList = activityMapper.findByCondition(condition);
			if(Checker.isNotEmpty(qryList)){
				activity = qryList.get(0);
				redisService.putMap(RedisKeyUtil.Activity_Code_Redis_Key(activity.getCode()), RedisUtil.hashsMap(activity));
			}
		}
		return activity;
	}

	@Override
	public List<Activity> findCurrentCouponActivity(Integer type) {
		return activityMapper.findCurrentCouponActivity(type);
	}

}
