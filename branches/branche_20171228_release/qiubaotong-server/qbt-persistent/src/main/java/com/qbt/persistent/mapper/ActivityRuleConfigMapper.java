package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.ActivityRuleConfig;

public interface ActivityRuleConfigMapper {
	
	int insert(ActivityRuleConfig config);
	
	int insertByBatch(@Param("configs")List<ActivityRuleConfig> configs);
	
	int updateById(ActivityRuleConfig config);
	
	ActivityRuleConfig findById(@Param("id")int id);
	
	List<ActivityRuleConfig> findByRuleId(@Param("ruleId")int ruleId);
	
	int deleteByRuleId(@Param("ruleId")int ruleId);
}
