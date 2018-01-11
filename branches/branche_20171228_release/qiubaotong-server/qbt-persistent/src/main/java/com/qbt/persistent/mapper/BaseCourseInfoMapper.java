package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.BaseCourseInfo;

public interface BaseCourseInfoMapper {
	
    int insert(BaseCourseInfo info);
    
    BaseCourseInfo selectByCourseId(Integer courseId);
    
    int updateByCourseId(BaseCourseInfo info);
    
    int deleteByCourseId(Integer courseId);

	BaseCourseInfo findByQyCourseId(Integer courseId);
}