package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ActivityOff;

public interface ActivityOffMapper {
	
	int insert(ActivityOff activityOff);
	
	int updateById(ActivityOff activityOff);
	
	int deleteById(@Param("id")Integer id);
	
	ActivityOff selectById(@Param("id")Integer id);
	
	List<ActivityOff> findByPage(PageEntity<ActivityOff> pageEntity);

	ActivityOff checkActivityId(@Param("scope")int scope,@Param("scopeId")  int scopeId);

	List<ActivityOff> list(@Param("type")int type);
}
