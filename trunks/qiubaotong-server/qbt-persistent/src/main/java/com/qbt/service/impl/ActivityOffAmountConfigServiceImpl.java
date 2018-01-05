package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.ActivityOffAmountConfig;
import com.qbt.persistent.mapper.ActivityOffAmountConfigMapper;
import com.qbt.service.ActivityOffAmountConfigService;

/**
 *  满减活动限额规则配置
  * @ClassName: ActivityOffAmountConfigServiceImpl
  * @Description: TODO
  * @author share 2016年9月9日
  * @modify share 2016年9月9日
 */
@Service
public class ActivityOffAmountConfigServiceImpl implements ActivityOffAmountConfigService {

	@Resource
	private ActivityOffAmountConfigMapper activityOffAmountConfigMapper;
	
	@Override
	public int deleteByActivityId(int activityId) {
		return activityOffAmountConfigMapper.deleteByActivityId(activityId);
	}

	@Override
	public int insert(ActivityOffAmountConfig activityOffConfig) {
		activityOffAmountConfigMapper.insert(activityOffConfig);
		return activityOffConfig.getId();
	}

	@Override
	public List<ActivityOffAmountConfig> findByActivityId(int activityId) {
		return activityOffAmountConfigMapper.findByActivityId(activityId);
	}

	@Override
	public int insertByBatch(List<ActivityOffAmountConfig> configs) {
		return activityOffAmountConfigMapper.insertByBatch(configs);
	}
	
}
