package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityOff;

public interface ActivityOffService {
	
int insert(ActivityOff activityOff);
	
	int updateById(ActivityOff activityOff);
	
	int deleteById(Integer id);
	
	ActivityOff findById(Integer id);
	
	List<ActivityOff> findByPage(PageEntity<ActivityOff> pageEntity);
	
	ActivityOff checkActivityId(int scope,int scopeId);

	List<ActivityOff> list(int type);
}
