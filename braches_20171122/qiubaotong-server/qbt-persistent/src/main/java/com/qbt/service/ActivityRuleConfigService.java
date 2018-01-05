package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.ActivityRuleConfig;

public interface ActivityRuleConfigService {
	
	int insert(ActivityRuleConfig config);
	
	int insertByBatch(List<ActivityRuleConfig> configs);
	
	int updateById(ActivityRuleConfig config);
	
	ActivityRuleConfig findById(int id);
	
	List<ActivityRuleConfig> findByRuleId(int ruleId);
	
	int deleteByRuleId(int ruleId);
}
