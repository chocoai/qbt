package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.ActivityOffAmountConfig;

public interface ActivityOffAmountConfigMapper {

	int insert(ActivityOffAmountConfig activityOffAmountConfig);
	
	int deleteByActivityId(@Param("activityId")int acrtivityId);

	List<ActivityOffAmountConfig> findByActivityId(@Param("activityId")int activityId);
	
	int insertByBatch(@Param("configs")List<ActivityOffAmountConfig> configs);
	
}
