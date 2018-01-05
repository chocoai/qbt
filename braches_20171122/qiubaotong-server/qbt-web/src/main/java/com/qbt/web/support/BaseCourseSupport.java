package com.qbt.web.support;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qbt.web.pojo.base.SiteModel;
import com.qbt.web.pojo.comm.BaseCourseResp;
@Service
public interface BaseCourseSupport {
	
	public List<SiteModel> findList(String name,int area_id,float lon,float lat,int status,int isPractice);

	public List<SiteModel> findCourseByUserId(Integer id,Integer type);
	
	/**
	 * 获取最热门的几个球场
	  * @Title: findByHotCourse
	  * @Description: TODO
	  * @author: chenxiaocong 2017年3月6日
	  * @modify: chenxiaocong 2017年3月6日
	  * @return
	 */
	public List<BaseCourseResp> findByHotCourse();
}
