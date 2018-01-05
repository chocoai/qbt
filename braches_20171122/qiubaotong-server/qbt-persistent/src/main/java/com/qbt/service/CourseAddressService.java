package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.CourseAddress;

public interface CourseAddressService {
	
	List<CourseAddress> listCourseAddressesInfo(float lon,float lat);
	
	List<CourseAddress> listCourseAddressByCityId(int id,float lon, float lat);

}
