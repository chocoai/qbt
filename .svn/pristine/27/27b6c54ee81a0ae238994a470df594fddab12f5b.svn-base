package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossBaseCourse;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.persistent.entity.UserCourse;

@Service
public interface BaseCourseMapper {
	
    int insert(BaseCourse record);

    int updateById(BaseCourse record);

	List<BaseCourse> findList(@Param("name")String name, @Param("area_id")int area_id, @Param("lon")float lon, @Param("lat")float lat, @Param("status")int status, @Param("isPractice")int isPractice);

	BaseCourse findById(Integer id);
	
	List<BossBaseCourse> findByPage(PageEntity<BaseCourse> pageEntity);
	
	List<BaseCourse> findByAreaId(@Param("areaId")Integer areaId);
	
	int deleteById(@Param("id")int id, @Param("isDelete")boolean isDelete);
	
	List<BaseCourse> findByCondition(BaseCourse condition);

	List<BaseCourse> list();
	
	List<BaseCourse> findCourseByUserId(@Param("userId")int userId,@Param("type")int type);

	List<BaseCourse> finByName(String name);
	
	List<BaseCourse> findByHotCourse();
	
	List<UserCourse> findUserCourseByUserId(@Param("userId")int userId);

	List<BaseCourse> findListByFirstLetter(@Param("name")String name, @Param("area_id")int area_id, @Param("lon")float lon, @Param("lat")float lat, @Param("status")int status, @Param("isPractice")int isPractice);
}