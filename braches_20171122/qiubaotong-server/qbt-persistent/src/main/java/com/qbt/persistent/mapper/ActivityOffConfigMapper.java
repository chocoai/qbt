package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.ActivityOffConfig;

public interface ActivityOffConfigMapper {

	int insert(ActivityOffConfig activityOffConfig);
	
	int deleteByActivityId(@Param("activityId")int acrtivityId);

	List<ActivityOffConfig> findByActivityId(@Param("activityId")int activityId);
	
	int insertByBatch(@Param("configs")List<ActivityOffConfig> configs);

	List<ActivityOffConfig> findScopeIdByCourse();
	
}
