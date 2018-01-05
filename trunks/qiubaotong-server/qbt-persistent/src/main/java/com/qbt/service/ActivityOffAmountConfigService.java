package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.ActivityOffAmountConfig;

public interface ActivityOffAmountConfigService {
	
	int deleteByActivityId(int activityId);
	
	int insert(ActivityOffAmountConfig activityOffConfig);
	
	List<ActivityOffAmountConfig> findByActivityId(int activityId);
	
	int insertByBatch(List<ActivityOffAmountConfig> configs);
	
}
