package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.CouponTypeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.Utils;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.Coupon;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.redis.RedisService;
import com.qbt.scp.upload.service.CsvService;
import com.qbt.service.ActivityService;
import com.qbt.service.CouponService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.coupon.CouponPageReqVo;
import com.qbt.web.pojo.coupon.CouponVo;
import com.qbt.web.support.CouponSupport;

@Service
public class CouponSupportImpl implements CouponSupport {
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private ActivityService activityService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private RedisService redisService;
	
	@Resource
	private CsvService csvService;
	
	@Override
	public List<CouponVo> findByPage(CouponPageReqVo reqVo) {
		PageEntity<UserCouponActivity> pageEntity = BeanUtil.pageConvert(reqVo, UserCouponActivity.class);
		UserCouponActivity condition = pageEntity.getCondition();
		condition.setName(reqVo.getActivityName());
		List<UserCouponActivity> list = couponService.findByPageBoss(pageEntity);
		List<CouponVo> voList = BeanUtil.list2list(list, CouponVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public String exportCoupon(CouponPageReqVo reqVo) throws Exception {
		UserCouponActivity condition = new UserCouponActivity();
		condition.setActivityId(reqVo.getActivityId());
		PageEntity<UserCouponActivity> pageEntity = new PageEntity<UserCouponActivity>();
		pageEntity.setCondition(condition);
		
		List<String> header = new ArrayList<String>();
		header.add("活动名称");
		header.add("领券时间");
		header.add("活动时间");
		header.add("类型");
		header.add("优惠码");
		header.add("券金额");
		header.add("子优惠码");
		header.add("子券金额");
		header.add("是否可用");
		header.add("领取状态");
		header.add("领取人");
		
		int pageNo = 0;
		int pageSize = 5000;
		pageEntity.setPageSize(pageSize);
		
		do {
			pageNo++;
			pageEntity.setPageNumber(pageNo);
			List<UserCouponActivity> list = couponService.findByPageBoss(pageEntity);
			
			List<List<String>> dataList = new ArrayList<List<String>>();
			String activityName = "";
			if(Checker.isNotEmpty(list)){
				List<String> rowList = null;
				for(UserCouponActivity u : list){
					rowList = new ArrayList<String>();
					activityName = u.getName();
					rowList.add(activityName);//活动名称
					String couponTime = String.format("%s到%s", DateUtil.formatDate(u.getStartTime(), DateUtil.DATE_FORMAT_01), DateUtil.formatDate(u.getEndTime(), DateUtil.DATE_FORMAT_01));
					rowList.add(couponTime);//领券时间
					String activityTime = String.format("%s到%s", DateUtil.formatDate(u.getActivityStartTime(), DateUtil.DATE_FORMAT_01), DateUtil.formatDate(u.getActivityEndTime(), DateUtil.DATE_FORMAT_01));
					rowList.add(activityTime);//活动时间
					rowList.add(CouponTypeEnum.getByType(u.getType()).getDesc());//类型
					rowList.add(u.getCode());//优惠码
					rowList.add(Utils.formatNumberByDecimal(u.getAmount()));//券金额
					rowList.add(u.getChildCode());//子优惠码
					rowList.add(Utils.formatNumberByDecimal(u.getChildAmount()));//子券金额
					rowList.add(u.getStatus() == 1 ? "未使用" : "已使用");//是否可用
					String claimTypeName = "";
					if(u.getClaimType() == 0){
						claimTypeName = "未领取";
					}else{
						claimTypeName = "已领取";
					}
					rowList.add(claimTypeName);//领取状态
					rowList.add(u.getUserName());//领取人
					
					dataList.add(rowList);
				}
			}
			
			csvService.writeCsv(header, dataList, activityName + "_优惠券");
		} while (pageNo < pageEntity.getPageCount());
		
		String url = csvService.uploadCsv();
		return url;
	}

	@Override
	public boolean update(CouponVo vo)  throws BusinessException {
		Coupon coupon = couponService.findById(vo.getId());
		if(coupon  == null){
			throw new BusinessException("8001", "无效优惠券");
		}
		//=================活动状态检查=================
		Activity activity = activityService.findById(coupon.getActivityId());
		if(activity  == null){
			throw new BusinessException("8001", "查无此活动");
		}
		//活动失效
		if (activity.getStatus() == 2) {
			throw new BusinessException("8001", "活动已失效");
		}
		if (activity.getMaxPerOne() <= 0) {
			throw new BusinessException("8001", "活动无效，无法领用券码");
		}
		// 领券时间已截止
		if (DateUtil.compareDate(new Date(), activity.getEndTime())) {
			throw new BusinessException("8001", "活动领券时间已截止,无法领用券码");
		}
		//检查个人是否超额领券
		String user_key = RedisKeyUtil.Activity_UserId_Redis_key(activity.getId(), vo.getUserId());
		// 检查名额是否存在
		if (redisService.setnx(user_key, "1") == 0) {// 名额值存在
			int i = Integer.parseInt(redisService.get(user_key));
			if (i < activity.getMaxPerOne()) {
				redisService.incr(user_key);
			} else {
				throw new BusinessException("8001", "该用户领券名额已使用完");
			}
		}
		//检查券是否已被领取
		if(couponService.getCouponCodeByActivity(activity.getId(), coupon.getCode()) == 0){
			throw new BusinessException("8001", "该券已被领取");
		}
		
		Coupon update = new Coupon();
		update.setCode(coupon.getCode());
		update.setClaimType(2);//2-后台分发
		update.setClaimTime(new Date());
		update.setUserId(vo.getUserId());
		UserWeixin user = userWeixinService.findById(vo.getUserId());
		update.setUserName(Checker.isNotEmpty(user) ? user.getNickname() : "");
		return couponService.updateByCode(update) > 0;
	}
	
}
