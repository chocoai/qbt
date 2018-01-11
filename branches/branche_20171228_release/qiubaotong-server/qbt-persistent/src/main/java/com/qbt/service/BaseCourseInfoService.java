package com.qbt.service;

import com.qbt.persistent.entity.BaseCourseInfo;

public interface BaseCourseInfoService {
	
	int insert(BaseCourseInfo info);
	
	BaseCourseInfo selectByCourseId(Integer courseId);
	
	BaseCourseInfo findByQyCourseId(Integer courseId);
	
	int updateByCourseId(BaseCourseInfo info);
	
	int deleteByCourseId(Integer courseId);
}
