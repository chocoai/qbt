package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityOff;
import com.qbt.persistent.mapper.ActivityOffMapper;
import com.qbt.service.ActivityOffService;

@Service
public class ActivityOffServiceImpl implements ActivityOffService {
	
	@Resource
	private ActivityOffMapper activityOffMapper;
	
	@Override
	public int insert(ActivityOff activityOff) {
		activityOffMapper.insert(activityOff);
		return activityOff.getId();
	}

	@Override
	public int updateById(ActivityOff activityOff) {
		return activityOffMapper.updateById(activityOff);
	}

	@Override
	public int deleteById(Integer id) {
		return activityOffMapper.deleteById(id);
	}

	@Override
	public ActivityOff findById(Integer id) {
		return activityOffMapper.selectById(id);
	}

	@Override
	public List<ActivityOff> findByPage(PageEntity<ActivityOff> pageEntity) {
		return activityOffMapper.findByPage(pageEntity);
	}

	@Override
	public ActivityOff checkActivityId(int scope, int scopeId) {
		// TODO Auto-generated method stub
		return activityOffMapper.checkActivityId(scope,scopeId);
	}

	@Override
	public List<ActivityOff> list(int type) {
		// TODO Auto-generated method stub
		return activityOffMapper.list(type);
	}

}
