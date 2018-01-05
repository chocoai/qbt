package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.CourseAddress;

public interface CourseAddressMapper {
	
	List<CourseAddress> findCourseAddress(@Param("lon") float lon,@Param("lat") float lat);

	List<CourseAddress>	findCourseAddressByCityId(@Param("id") int id,@Param("lon")float lon, @Param("lat")float lat);
}
