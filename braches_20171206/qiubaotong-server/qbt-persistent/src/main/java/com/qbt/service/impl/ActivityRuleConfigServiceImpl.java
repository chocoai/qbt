package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.ActivityRuleConfig;
import com.qbt.persistent.mapper.ActivityRuleConfigMapper;
import com.qbt.service.ActivityRuleConfigService;

@Service
public class ActivityRuleConfigServiceImpl implements ActivityRuleConfigService {
	
	@Resource
	private ActivityRuleConfigMapper activityRuleConfigMapper;
	
	@Override
	public int insert(ActivityRuleConfig config) {
		activityRuleConfigMapper.insert(config);
		return config.getId();
	}

	@Override
	public int insertByBatch(List<ActivityRuleConfig> configs) {
		return activityRuleConfigMapper.insertByBatch(configs);
	}

	@Override
	public int updateById(ActivityRuleConfig config) {
		return activityRuleConfigMapper.updateById(config);
	}

	@Override
	public ActivityRuleConfig findById(int id) {
		return activityRuleConfigMapper.findById(id);
	}

	@Override
	public List<ActivityRuleConfig> findByRuleId(int ruleId) {
		return activityRuleConfigMapper.findByRuleId(ruleId);
	}

	@Override
	public int deleteByRuleId(int ruleId) {
		return activityRuleConfigMapper.deleteByRuleId(ruleId);
	}

}
