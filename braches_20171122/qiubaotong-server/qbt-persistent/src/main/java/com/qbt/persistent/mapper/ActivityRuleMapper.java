package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityRule;

public interface ActivityRuleMapper {
	
	int insert(ActivityRule rule);
	
	int updateById(ActivityRule rule);
	
	ActivityRule findById(@Param("id")int id);
	
	List<ActivityRule> findAllByStatus(@Param("status")Integer status);
	
	List<ActivityRule> findByPage(PageEntity<ActivityRule> pageEntity);
	
	List<ActivityRule> findAll();
}
