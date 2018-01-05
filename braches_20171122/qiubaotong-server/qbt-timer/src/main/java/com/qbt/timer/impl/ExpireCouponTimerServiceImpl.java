package com.qbt.timer.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.bussiness.support.WechatMessageSupport;
import com.qbt.common.util.Checker;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.CouponService;
import com.qbt.service.UserWeixinService;
import com.qbt.timer.TimerService;

@Service("expireCouponTimerService")
public class ExpireCouponTimerServiceImpl extends TimerService {
	
	@Resource
	private CouponService couponService;
	
	@Resource
	private UserWeixinService userWeixinService;
	
	@Resource
	private WechatMessageSupport wechatMessageSupport;
	
	@Override
	public void process() {
		/**
		 * 优惠券还有7天过期,提醒客户
		 */
		List<UserCouponActivity> list = couponService.findExpireCodesByDay(7);
		if(Checker.isNotEmpty(list)){
			Map<Integer, String> userMap = new HashMap<Integer, String>();
			UserWeixin user = null;
			for(UserCouponActivity a : list){
				if(Checker.isNotEmpty(a.getUserId()) && !userMap.containsKey(a.getUserId())){
					user = userWeixinService.findById(a.getUserId());
					if(Checker.isNotEmpty(user)){
						userMap.put(user.getId(), user.getOpenid());
					}
				}
			}
			
			for(UserCouponActivity couponActivity : list){
				wechatMessageSupport.expireCouponNotify(couponActivity, userMap.get(couponActivity.getUserId()));
			}
			
		}
	}

}
