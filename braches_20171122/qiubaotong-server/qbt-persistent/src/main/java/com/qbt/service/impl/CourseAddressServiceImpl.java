package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.CourseAddress;
import com.qbt.persistent.mapper.CourseAddressMapper;
import com.qbt.service.CourseAddressService;

@Service
public class CourseAddressServiceImpl implements CourseAddressService{

	@Resource
	private CourseAddressMapper courseAddressMapper;

	@Override
	public List<CourseAddress> listCourseAddressesInfo(float lon, float lat) {
		
		return courseAddressMapper.findCourseAddress(lon, lat);
	}

	@Override
	public List<CourseAddress> listCourseAddressByCityId(int id,float lon, float lat) {
		
		return courseAddressMapper.findCourseAddressByCityId(id,lon, lat);
	}

}
