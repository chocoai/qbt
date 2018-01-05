package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.CouponTypeEnum;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.ReportActivity;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.CouponService;
import com.qbt.service.ReportActivityService;
import com.qbt.web.pojo.activity.ActivityRequest;
import com.qbt.web.pojo.activity.ActivityResponse;
import com.qbt.web.support.ActivitySupport;

@Service
public class ActivitySupportImpl implements ActivitySupport {
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private ReportActivityService reportActivityService;
	
	@Override
	public Map<String, Object> exportCoupon(Integer activityId, SysUser sysUser) {
		UserCouponActivity condition = new UserCouponActivity();
		condition.setActivityId(activityId);
		PageEntity<UserCouponActivity> pageEntity = new PageEntity<UserCouponActivity>();
		pageEntity.setCondition(condition);
		
		int pageNo = 0;
		int pageSize = 5000;
		pageEntity.setPageSize(pageSize);
		String activityName = "";
		List<Map<String, String>> listMap = new ArrayList<Map<String,String>>();
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<UserCouponActivity> list = couponService.findByPageBoss(pageEntity);
			if(Checker.isNotEmpty(list)){
				Map<String, String> data = null;
				for(UserCouponActivity u : list){
					data = new HashMap<String, String>();
					activityName = u.getName();
					data.put("activityName", activityName);
					String couponTime = String.format("%s到%s", DateUtil.formatDate(u.getStartTime(), DateUtil.DATE_FORMAT_01), DateUtil.formatDate(u.getEndTime(), DateUtil.DATE_FORMAT_01));
					data.put("couponTime", couponTime);
					String activityTime = String.format("%s到%s", DateUtil.formatDate(u.getActivityStartTime(), DateUtil.DATE_FORMAT_01), DateUtil.formatDate(u.getActivityEndTime(), DateUtil.DATE_FORMAT_01));
					data.put("activityTime", activityTime);
					data.put("type", CouponTypeEnum.getByType(u.getType()).getDesc());
					data.put("code", u.getCode());
					data.put("amount", Utils.formatNumberByDecimal(u.getAmount()));
					data.put("childCode", u.getChildCode());
					data.put("childAmount", Utils.formatNumberByDecimal(u.getChildAmount()));
					data.put("status", u.getStatus() == 1 ? "未使用" : "已使用");
					data.put("claimType", u.getClaimType() == 0 ? "未领取" : "已领取");
					data.put("userName", u.getUserName());
					listMap.add(data);
				}
			}
		} while (pageNo < pageEntity.getPageCount());
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("operator", sysUser != null ? sysUser.getName() : "");
		String currentDay = DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02);
		map.put("title", activityName + "_优惠券_" + currentDay);
		map.put("list", listMap);
		
		return map;
	}

	/**
	 *  现金券活动导出
	  * @Title: exportActivity
	  * @Description: TODO
	  * @author: share 2016年9月26日
	  * @modify: share 2016年9月26日
	  * @param activityRequest
	  * @param sysUser
	  * @return
	  * @see com.qbt.web.support.ActivitySupport#exportActivity(com.qbt.web.pojo.activity.ActivityRequest, com.qbt.persistent.entity.SysUser)
	 */
	@Override
	public Map<String, Object> exportActivity(ActivityRequest activityRequest, SysUser sysUser) {
		Activity activity = new Activity();
		activity.setName(activityRequest.getName());
		activity.setStartTime(activityRequest.getStartDate());
		activity.setEndTime(activityRequest.getEndDate());
		List<ReportActivity> datas = reportActivityService.findAll(activity);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("params", activityRequest);
		map.put("operatorName", sysUser.getName());
		map.put("datas", datas);
		map.put("titleDate", DateUtil.formatDate(new Date(), DateUtil.DATE_FORMAT_02));
		return map;
	}

	/**
	 *  现金券分页查询
	  * @Title: findByPage
	  * @Description: TODO
	  * @author: share 2016年9月26日
	  * @modify: share 2016年9月26日
	  * @param req
	  * @return
	  * @see com.qbt.web.support.ActivitySupport#findByPage(com.qbt.web.pojo.activity.ActivityRequest)
	 */
	@Override
	public List<ActivityResponse> findByPage(ActivityRequest req) {
		Activity activity = new Activity();
		activity.setName(req.getName());
		activity.setStartTime(req.getStartDate());
		activity.setEndTime(req.getEndDate());
		
		PageEntity<Activity> pageEntity = new PageEntity<Activity>();
		pageEntity.setCondition(activity);
		pageEntity.setPageNumber(req.getPageNo());
		pageEntity.setPageSize(req.getPageSize());
		
		List<ReportActivity> list = reportActivityService.findByPage(pageEntity);
		List<ActivityResponse> toList = BeanUtil.list2list(list, ActivityResponse.class);
		req.setTotalCount(pageEntity.getTotalCount());
		return toList;
	}

}
