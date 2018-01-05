package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.Arith;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.ActivityOffConfig;
import com.qbt.persistent.entity.BaseCourse;
import com.qbt.service.ActivityOffConfigService;
import com.qbt.service.BaseCourseService;
import com.qbt.web.pojo.base.SiteModel;
import com.qbt.web.pojo.comm.BaseCourseResp;
import com.qbt.web.support.BaseCourseSupport;

@Service
public class BaseCourseSupportImpl implements BaseCourseSupport {
	
	@Resource
	private BaseCourseService baseCourseService;
	
	@Resource
	private ActivityOffConfigService activityOffConfigService;
	
	@Override
	public List<SiteModel> findList(String name,int area_id,float lon,float lat,int status,int isPractice) {
		// 查询活动球场ID
		List<ActivityOffConfig> courseList = activityOffConfigService.findScopeIdByCourse();
		Set<String> courseSet = new HashSet<String>();
		for(ActivityOffConfig config : courseList){
			courseSet.add(String.valueOf(config.getScopeId()));
		}
		
		List<BaseCourse> baseCourseList = baseCourseService.findList(name,area_id, lon, lat,status,isPractice);
		List<SiteModel> siteModelList =  new ArrayList<SiteModel>();
		for (BaseCourse baseCourse : baseCourseList) {
			SiteModel sitemodel = new SiteModel();
			sitemodel.setId(baseCourse.getId());
			sitemodel.setAddress(baseCourse.getAddress());
			sitemodel.setName(baseCourse.getName());
			sitemodel.setJuli(baseCourse.getJuli());
			sitemodel.setStatus(baseCourse.getStatus());
			sitemodel.setAreaId(baseCourse.getAreaId());
			double juli = Arith.div(baseCourse.getJuli(), 1000, 2);
			if(juli<1){
				sitemodel.setJuliStr((int)baseCourse.getJuli()+"米");
			}else{
				sitemodel.setJuliStr((int)juli+"公里");
			}
			// 满减活动标签
			if(courseSet.contains(String.valueOf(baseCourse.getId()))){
				sitemodel.setActivityType(1);
			}
			// 偏远球场信息
			sitemodel.setIsOutRange(baseCourse.getIsOutRange());
			sitemodel.setOutRangeTime(baseCourse.getOutRangeTime());
			sitemodel.setOutRangePrice(baseCourse.getOutRangePrice());
			// 微信提示信息
			sitemodel.setIsTip(baseCourse.getIsTip());
			sitemodel.setWechatTip(baseCourse.getWechatTip());
			siteModelList.add(sitemodel);
		}
		return siteModelList;
	}

	/**
	 *  查询用户常用球场
	  * @Title: findCourseByUserId
	  * @Description: TODO
	  * @author: share 2016年9月23日
	  * @modify: share 2016年9月23日
	  * @param id
	  * @return
	  * @see com.qbt.web.support.BaseCourseSupport#findCourseByUserId(java.lang.Integer)
	 */
	@Override
	public List<SiteModel> findCourseByUserId(Integer id, Integer type) {
		List<BaseCourse> baseCourseList = baseCourseService.findCourseByUserId(id,type);
		List<SiteModel> siteModelList =  new ArrayList<SiteModel>();
		for (BaseCourse baseCourse : baseCourseList) {
			SiteModel sitemodel = new SiteModel();
			sitemodel.setId(baseCourse.getId());
			sitemodel.setAddress(baseCourse.getAddress());
			sitemodel.setName(baseCourse.getName());
			sitemodel.setJuli(baseCourse.getJuli());
			sitemodel.setStatus(baseCourse.getStatus());
			sitemodel.setAreaId(baseCourse.getAreaId());
			sitemodel.setIsOutRange(baseCourse.getIsOutRange());
			sitemodel.setOutRangeTime(baseCourse.getOutRangeTime());
			sitemodel.setOutRangePrice(baseCourse.getOutRangePrice());
			sitemodel.setIsTip(baseCourse.getIsTip());
			sitemodel.setWechatTip(baseCourse.getWechatTip());
			siteModelList.add(sitemodel);
		}
		return siteModelList;
	}

	/**
	 * 获取最热门的几个球场
	  * @Title: findByHotCourse
	  * @Description: TODO
	  * @author: chenxiaocong 2017年3月6日
	  * @modify: chenxiaocong 2017年3月6日
	  * @return
	 */
	public List<BaseCourseResp> findByHotCourse(){
		
		List<BaseCourse> list =  baseCourseService.findByHotCourse();
		List<BaseCourseResp> voList = BeanUtil.list2list(list, BaseCourseResp.class);
		return voList;
	}
	
}
