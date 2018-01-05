
 /**
 * @Title: UserCouponServiceImpl.java
 * @Package com.qbt.service.impl
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月10日
 * @version V1.0
 **/

package com.qbt.service.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.Checker;
import com.qbt.common.util.CollectionsUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.Coupon;
import com.qbt.persistent.mapper.CouponMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.CouponService;

/**
  * @ClassName: UserCouponServiceImpl
  * @Description: 用户优惠券查询
  * @author win10 2016年8月10日
  * @modify win10 2016年8月10日
  */
@Service
public class CouponServiceImpl implements CouponService {
	
	@Resource
	private CouponMapper couponMapper;
	
	@Resource
	private RedisService redisService;
	
	/**
	  * @Title: selectUserCoupon
	  * @Description: 根据用户id查询用户优惠券
	  * 			  1-未使用
	  * 			  2-已使用
	  * 			  3-已过期
	  * @author: win10 2016年8月10日
	  * @modify: win10 2016年8月10日
	  * @param userId
	  * @return
	 */
	public List<UserCouponActivity> selectUserCoupon(int userId, int status){
		List<UserCouponActivity> list=couponMapper.selectUserCouponByUserId(userId, status);
		return list;
	}

	
	 /**
	  * @Title: updateByCode
	  * @Description: TODO
	  * @author: win10 2016年8月14日
	  * @modify: win10 2016年8月14日
	  * @param record
	  * @return
	  * @see com.qbt.service.CouponService#updateByCode(com.qbt.persistent.entity.Coupon)
	  */
	@Override
	public int updateByCode(Coupon record) {
		return couponMapper.updateByCode(record);
	}


	
	 /**
	  * @Title: selectCouponByChildCode
	  * @Description: 根据子券码查询券码信息
	  * @author: win10 2016年8月14日
	  * @modify: win10 2016年8月14日
	  * @param childCode
	  * @return
	  * @see com.qbt.service.CouponService#selectCouponByChildCode(java.lang.String)
	  */
	@Override
	public Coupon selectCouponByChildCode(String childCode) {
		return couponMapper.selectByChildCode(childCode);
	}


	
	 /**
	  * @Title: selectCouponCountByUserId
	  * @Description: 根据用户查询可用券码
	  * @author: win10 2016年8月14日
	  * @modify: win10 2016年8月14日
	  * @param userId
	  * @return
	  * @see com.qbt.service.CouponService#selectCouponCountByUserId(int)
	  */
	@Override
	public int selectCouponCountByUserId(int userId) {
		return couponMapper.selectCouponCountByUserId(userId);
	}


	
	 /**
	  * @Title: selectCouponByActivityId
	  * @Description: TODO
	  * @author: win10 2016年8月14日
	  * @modify: win10 2016年8月14日
	  * @param activityId
	  * @return
	  * @see com.qbt.service.CouponService#selectCouponByActivityId(int)
	  */
	
	@Override
	public List<Coupon> selectCouponByActivityId(int activityId) {
		return couponMapper.selectCouponByActivityId(activityId);
	}


	
	 /**
	  * @Title: selectCouponByCode
	  * @Description: TODO
	  * @author: win10 2016年8月14日
	  * @modify: win10 2016年8月14日
	  * @param code
	  * @return
	  * @see com.qbt.service.CouponService#selectCouponByCode(java.lang.String)
	  */
	
	@Override
	public List<Coupon> selectCouponByCode(String code) {
		return couponMapper.selectCouponByCode(code);
	}


	@Override
	public int insert(Coupon coupon) {
		couponMapper.insert(coupon);
		if(coupon.getId() > 0 
				&& coupon.getActivityId() != null
				&& coupon.getClaimType() == 0){//未领取
			String key = RedisKeyUtil.Activity_Coupon_Redis_Key(coupon.getActivityId());
			List<String> codeList = redisService.lrange(key, 0, -1);
			if((Checker.isNotEmpty(codeList) && !codeList.contains(coupon.getCode()))
					|| Checker.isEmpty(codeList)){
				redisService.lpush(key, coupon.getCode());
			}
			return coupon.getId();
		}
		return 0;
	}


	@Override
	public List<UserCouponActivity> findByPageBoss(PageEntity<UserCouponActivity> pageEntity) {
		return couponMapper.findByPageBoss(pageEntity);
	}


	@Override
	public int updateById(Coupon coupon) {
		return couponMapper.updateById(coupon);
	}


	@Override
	public Coupon findById(int id) {
		return couponMapper.selectById(id);
	}


	@Override
	public int insertByBatch(List<Coupon> couponList) {
		List<List<Coupon>> splitList = CollectionsUtil.splitList(couponList, 500);
		int count = 0;
		Map<Integer, Set<String>> map = new HashMap<Integer, Set<String>>();
		Set<String> codeSet = null;
		for(List<Coupon> list : splitList){
			count += couponMapper.insertByBatch(list);
			if(count > 0){
				for(Coupon c : list){
					if(c.getClaimType() == 0){//未领取
						List<String> codeList = redisService.lrange(RedisKeyUtil.Activity_Coupon_Redis_Key(c.getActivityId()), 0, -1);
						if((Checker.isNotEmpty(codeList) && !codeList.contains(c.getCode()))
								|| Checker.isEmpty(codeList)){
							codeSet = map.containsKey(c.getActivityId()) ? map.get(c.getActivityId()) : new HashSet<String>();
							codeSet.add(c.getCode());
							map.put(c.getActivityId(), codeSet);
						}
					}
				}
			}
		}
		for(Integer activityId : map.keySet()){
			codeSet = map.get(activityId);
			redisService.lpush(RedisKeyUtil.Activity_Coupon_Redis_Key(activityId), codeSet.toArray(new String[codeSet.size()]));
		}
		return count;
	}

	/**
	 *  根据ID更新状态
	  * @Title: updateStatusById
	  * @Description: TODO
	  * @author: share 2016年8月26日
	  * @modify: share 2016年8月26日
	  * @param id
	  * @return
	  * @see com.qbt.service.CouponService#updateByOrderCancel(int)
	 */
	@Override
	public int updateStatusById(int id,int status) {
		return couponMapper.updateStatusById(id,status);
	}


	@Override
	public List<UserCouponActivity> findExpireCodesByDay(int day) {
		return couponMapper.findExpireCodesByDay(day);
	}


	@Override
	public int updateUserById(Coupon coupon) {
		return couponMapper.updateUserIdById(coupon);
	}


	@Override
	public List<Coupon> findAllCouponCode() {
		return couponMapper.findAllCouponCode();
	}
	

	@Override
	public Coupon getCoupon(Integer activityId) {
		return couponMapper.getCoupon(activityId);
	}

	@Override
	public void deblockingCoupon(Integer orderId) {
		couponMapper.deblockingCoupon(orderId);
		
	}

	@Override
	public void bindCoupon(Coupon coupon) {
		couponMapper.bindCoupon(coupon);
		
	}


	@Override
	public boolean isWinner(Integer orderId) {
		int result = couponMapper.isWinner(orderId);
		if(result>0){
			return true;
		}
		return false;
	}


	@Override
	public UserCouponActivity findWinnerInfo(Integer orderId) {
		return couponMapper.findWinnerInfo(orderId);
	}


	@Override
	public Long getCouponCodeByActivity(int activityId, String couponCode) {
		return redisService.lrem(RedisKeyUtil.Activity_Coupon_Redis_Key(activityId), 0, couponCode);
	}


	@Override
	public String getCouponCodeByActivity(int activityId) {
		return redisService.rpop(RedisKeyUtil.Activity_Coupon_Redis_Key(activityId));
	}

}
