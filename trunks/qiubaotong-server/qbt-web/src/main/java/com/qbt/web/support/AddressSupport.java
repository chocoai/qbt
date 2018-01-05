package com.qbt.web.support;



import java.util.List;

import com.qbt.web.pojo.address.CourseAddressInfoVo;
import com.qbt.web.pojo.address.CourseAddressVo;


public interface AddressSupport {
	
	CourseAddressInfoVo listCourseAddressesInfo(Integer userId,float lon, float lat);

	List<CourseAddressVo> listCourseAddressesInfoByCityId(int id,float lon, float lat);

}
