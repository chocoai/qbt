package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.ActivityOffConfig;

public interface ActivityOffConfigService {
	
	int deleteByActivityId(int activityId);
	
	int insert(ActivityOffConfig activityOffConfig);
	
	List<ActivityOffConfig> findByActivityId(int activityId);
	
	int insertByBatch(List<ActivityOffConfig> configs);
	
	/**
	 *  查询正在满减活动的球场ID
	  * @Title: findScopeIdByCourse
	  * @Description: TODO
	  * @author: share 2016年9月19日
	  * @modify: share 2016年9月19日
	  * @return
	 */
	List<ActivityOffConfig> findScopeIdByCourse();
}
