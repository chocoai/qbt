package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityRule;

public interface ActivityRuleService {
	
	int insert(ActivityRule rule);
	
	int updateById(ActivityRule rule);
	
	ActivityRule findById(int id);
	
	List<ActivityRule> findAllByStatus(Integer status);
	
	List<ActivityRule> findByPage(PageEntity<ActivityRule> pageEntity);
	
	List<ActivityRule> findAll();
}
