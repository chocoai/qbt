package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.ActivityOffConfig;
import com.qbt.persistent.mapper.ActivityOffConfigMapper;
import com.qbt.service.ActivityOffConfigService;

@Service
public class ActivityOffConfigServiceImpl implements ActivityOffConfigService {

	@Resource
	private ActivityOffConfigMapper activityOffConfigMapper;
	
	@Override
	public int deleteByActivityId(int activityId) {
		return activityOffConfigMapper.deleteByActivityId(activityId);
	}

	@Override
	public int insert(ActivityOffConfig activityOffConfig) {
		activityOffConfigMapper.insert(activityOffConfig);
		return activityOffConfig.getId();
	}

	@Override
	public List<ActivityOffConfig> findByActivityId(int activityId) {
		return activityOffConfigMapper.findByActivityId(activityId);
	}

	@Override
	public int insertByBatch(List<ActivityOffConfig> configs) {
		return activityOffConfigMapper.insertByBatch(configs);
	}

	@Override
	public List<ActivityOffConfig> findScopeIdByCourse() {
		// TODO Auto-generated method stub
		return activityOffConfigMapper.findScopeIdByCourse();
	}
	
}
