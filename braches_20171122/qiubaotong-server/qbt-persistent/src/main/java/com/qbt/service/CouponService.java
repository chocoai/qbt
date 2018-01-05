
 /**
 * @Title: UserCouponService.java
 * @Package com.qbt.service
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月10日
 * @version V1.0
 **/

package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.Coupon;

/**
  * @ClassName: UserCouponService
  * @Description: TODO
  * @author win10 2016年8月10日
  * @modify win10 2016年8月10日
  */

public interface CouponService {
	
	List<UserCouponActivity> selectUserCoupon(int userId, int status);
	
	int updateByCode(Coupon record);
	
	Coupon selectCouponByChildCode(String childCode);
	
	int selectCouponCountByUserId(int userId);
	
	List<Coupon> selectCouponByActivityId(int activityId);
	
	List<Coupon> selectCouponByCode(String code);
	
	int insert(Coupon coupon);
	
	int updateById(Coupon coupon);
	
	int updateUserById(Coupon coupon);
	
	int updateStatusById(int id,int status);
	
	Coupon findById(int id);
	
	List<UserCouponActivity> findByPageBoss(PageEntity<UserCouponActivity> pageEntity);
	
	int insertByBatch(List<Coupon> couponList);
	
	List<UserCouponActivity> findExpireCodesByDay(int day);
	
	List<Coupon> findAllCouponCode();

	Coupon getCoupon(Integer activityId);

	void deblockingCoupon(Integer orderId);

	void bindCoupon(Coupon coupon);
	
	UserCouponActivity findWinnerInfo(Integer orderId);
	
	boolean isWinner(Integer orderId);
	
	/**
	 * 
	 * getCouponCodeByActivity:(获取活动缓存中的指定优惠券码).
	 *
	 * @author huangyihao
	 * 2017年7月13日 上午11:06:56
	 * @param activityId
	 * @param couponCode
	 * @return
	 *
	 */
	Long getCouponCodeByActivity(int activityId, String couponCode);
	
	/**
	 * 
	 * getCouponCodeByActivity:(获取活动缓存中的优惠券码).
	 *
	 * @author huangyihao
	 * 2017年7月13日 上午11:07:19
	 * @param activityId
	 * @return
	 *
	 */
	String getCouponCodeByActivity(int activityId);
	
}
