package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossBaseCourse;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.UserCourse;

public interface BaseCourseService {
	
	public List<BaseCourse> findList(String name,int area_id,float lon,float lat,int status,int isPractice);
	
	public BaseCourse findById(Integer id);
	
	public List<BossBaseCourse> findByPage(PageEntity<BaseCourse> pageEntity);
	
	public int insert(BaseCourse baseCourse);
	
	public int updateById(BaseCourse baseCourse);
	
	public List<BaseCourse> findByAreaId(Integer areaId);
	
	public int deleteById(int id, boolean isDelete);
	
	public List<BaseCourse> findByCondition(BaseCourse condition);

	public List<BaseCourse> list();
	
	public List<BaseCourse> findCourseByUserId(int userId,int type);
	
	public List<BaseCourse> findByHotCourse();
	
	List<UserCourse> findUserCourseByUserId(int userId);
}
