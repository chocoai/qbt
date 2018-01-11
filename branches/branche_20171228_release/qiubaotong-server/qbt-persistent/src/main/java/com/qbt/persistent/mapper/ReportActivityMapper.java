package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.ReportActivity;
import com.qbt.persistent.entity.Activity;

public interface ReportActivityMapper {
	
	List<ReportActivity> findByPage(PageEntity<Activity> pageEntity);
	
	List<ReportActivity> findAll(Activity pageEntity);
}
