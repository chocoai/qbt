package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityRule;
import com.qbt.persistent.mapper.ActivityRuleMapper;
import com.qbt.service.ActivityRuleService;

@Service
public class ActivityRuleServiceImpl implements ActivityRuleService {
	
	@Resource
	private ActivityRuleMapper activityRuleMapper;
	
	@Override
	public int insert(ActivityRule rule) {
		activityRuleMapper.insert(rule);
		return rule.getId();
	}

	@Override
	public int updateById(ActivityRule rule) {
		return activityRuleMapper.updateById(rule);
	}

	@Override
	public ActivityRule findById(int id) {
		return activityRuleMapper.findById(id);
	}

	@Override
	public List<ActivityRule> findAllByStatus(Integer status) {
		return activityRuleMapper.findAllByStatus(status);
	}

	@Override
	public List<ActivityRule> findByPage(PageEntity<ActivityRule> pageEntity) {
		return activityRuleMapper.findByPage(pageEntity);
	}

	@Override
	public List<ActivityRule> findAll() {
		return activityRuleMapper.findAll();
	}

}
