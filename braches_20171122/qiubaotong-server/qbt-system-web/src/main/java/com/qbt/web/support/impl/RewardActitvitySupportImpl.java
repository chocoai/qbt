package com.qbt.web.support.impl;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.Coupon;
import com.qbt.persistent.entity.OrderInfo;
import com.qbt.persistent.entity.RewardActitvity;
import com.qbt.persistent.entity.WinnerList;
import com.qbt.redis.RedisService;
import com.qbt.service.ActivityService;
import com.qbt.service.CouponService;
import com.qbt.service.RewardActitvityService;
import com.qbt.service.WinnerListService;
import com.qbt.web.pojo.activity.ActivityVo;
import com.qbt.web.pojo.rewardActitvity.RewardActitvityPageReqVo;
import com.qbt.web.pojo.rewardActitvity.RewardActitvityVo;
import com.qbt.web.pojo.rewardActitvity.WinnerListPageReqVo;
import com.qbt.web.pojo.rewardActitvity.WinnerListVo;
import com.qbt.web.support.RewardActitvitySupport;

@Service
public class RewardActitvitySupportImpl implements RewardActitvitySupport {
	
	@Resource
	private RewardActitvityService service;
	
	@Resource
	private RedisService redisServer;
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private WinnerListService winnerService;
	
	@Resource
	private ActivityService activityService;

	@Override
	public boolean insert(RewardActitvityVo vo) throws Exception {
		RewardActitvity entity = BeanUtil.a2b(vo, RewardActitvity.class);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		entity.setStartDate(sdf2.parse(sdf1.format(vo.getStartDate())+" 00:00:00"));
		entity.setEndDate(sdf2.parse(sdf1.format(vo.getEndDate())+" 23:59:59"));

		List<Integer> num = service.timeValidate(entity);
		if(num.size()>0){
			return false;
		}
		service.insert(entity);
		return true;
	}

	@Override
	public boolean updateById(RewardActitvityVo vo) throws Exception {
		RewardActitvity entity = BeanUtil.a2b(vo, RewardActitvity.class);
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		entity.setStartDate(sdf2.parse(sdf1.format(vo.getStartDate())+" 00:00:00"));
		entity.setEndDate(sdf2.parse(sdf1.format(vo.getEndDate())+" 23:59:59"));
		
		List<Integer> num = service.timeValidate(entity);
		if(num.size()>0){
			return false;
		}
		service.updateById(entity);
		return true;
	}

	@Override
	public void deleteById(RewardActitvityVo vo) {
		RewardActitvity entity = BeanUtil.a2b(vo, RewardActitvity.class);
		service.deleteById(entity);
	}

	@Override
	public List<RewardActitvityVo> list(RewardActitvityPageReqVo vo) {
		PageEntity<RewardActitvity> pageEntity = BeanUtil.pageConvert(vo, RewardActitvity.class);
		List<RewardActitvity> list = service.list(pageEntity);
		List<RewardActitvityVo> voList = BeanUtil.list2list(list, RewardActitvityVo.class);
		vo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public RewardActitvityVo findById(Integer id) {
		RewardActitvity entity	= service.findById(id);
		RewardActitvityVo vo = BeanUtil.a2b(entity, RewardActitvityVo.class);
		if(Checker.isNotEmpty(vo)) {
			vo.setSd(DateUtil.formatDate(entity.getStartDate(), DateUtil.DATE_FORMAT_01));
			vo.setEd(DateUtil.formatDate(entity.getEndDate(), DateUtil.DATE_FORMAT_01));
			if(vo.getRewardType() == 1) { //优惠券类型
				Activity activity = activityService.findById(Integer.parseInt(entity.getPrize()));
				if(Checker.isNotEmpty(activity)) {
					vo.setPrizeName(activity.getName());
					vo.setPrizeType(String.valueOf(activity.getType()));
				}
			}
		}
		return vo;
	}

	@Override
	public List<ActivityVo> findCurrentCoupon(Integer type) {
		List<Activity> activityList = activityService.findCurrentCouponActivity(type);
		List<ActivityVo> voList = BeanUtil.list2list(activityList, ActivityVo.class);
		return voList;
	}
	
	public void reward(OrderInfo orderInfo){
		//先查看当前是否有进行中的活动
		RewardActitvity ra = service.findCurrentRewardActitvity();
		if(null!=ra){
			String key = RedisKeyUtil.reward_actitvity_key(ra.getActitvityType(), ra.getId());
			System.out.println("*********"+key+"*********");
			Map<String, String> map=redisServer.getMap(key);
			int numerator=0,denominator=0;
			if(map==null||map.keySet().size()==0){
				map = new HashMap<String, String>();
				numerator = ra.getProbability();
				denominator = 10000;
			}else{
				numerator = Integer.parseInt(map.get("numerator"));
				denominator = Integer.parseInt(map.get("denominator"));
			}
			Random random = new Random();
			int value =random.nextInt(denominator);
			
			if(value<numerator){//中奖
				numerator--;
				if(ra.getActitvityType()==1){
					Coupon coupon = couponService.getCoupon(Integer.parseInt(ra.getPrize()));
					if(coupon!=null){
						String code= coupon.getCode();
						// 将此 奖券Code下的子奖券人绑定为该用户
//						Map<String, Object> params = new HashMap<String, Object>();
//						params.put("code", code);
//						params.put("userId", orderInfo.getUserId());
//						params.put("orderId", orderInfo.getOrderId());
						
						Coupon params = new Coupon();
						params.setCode(coupon.getCode());
						params.setUserId(orderInfo.getUserId());
						params.setOrderId(orderInfo.getOrderId());
						
						couponService.bindCoupon(params);
						LogCvt.info(orderInfo.getUserId()+"中奖，奖券code为"+code);
						
						WinnerList winnerList = new WinnerList();
						winnerList.setOrderId(orderInfo.getId());
						winnerList.setStatus(0);
						winnerList.setUserId(orderInfo.getUserId());
						winnerList.setUserInfo("蛋蛋");
						winnerList.setRewardActivityId(ra.getId());
						winnerList.setRewardActivityInfo(coupon.getCode());
						
						winnerService.insert(winnerList);
						
						couponService.getCouponCodeByActivity(coupon.getActivityId(), coupon.getCode());
					}
				}
				
			}
			denominator--;
			
			map.put("numerator", numerator+"");
			map.put("denominator", denominator+"");
			
			redisServer.putMap(key, map);
		}
		
	}

	@Override
	public void deblockingCoupon(Integer orderId) {
		couponService.deblockingCoupon(orderId);
	}

	@Override
	public boolean isWinner(Integer orderId) {
		return couponService.isWinner(orderId);
	}

	@Override
	public List<WinnerListVo> findWinnerListByPage(WinnerListPageReqVo vo) {
		PageEntity<WinnerList> pageEntity = BeanUtil.pageConvert(vo, WinnerList.class);
		List<WinnerList> list = winnerService.findByPage(pageEntity);
		List<WinnerListVo> voList =  BeanUtil.list2list(list, WinnerListVo.class);
		vo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
