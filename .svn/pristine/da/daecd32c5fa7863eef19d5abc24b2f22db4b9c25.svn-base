
 /**
 * @Title: UserCouponActivity.java
 * @Package com.qbt.web.support
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月10日
 * @version V1.0
 **/

package com.qbt.web.support;

import java.util.List;

import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.coupon.CouponActivity;
import com.qbt.web.pojo.coupon.CouponActivityV2;
import com.qbt.web.pojo.coupon.CouponCode;
import com.qbt.web.pojo.coupon.MyCouponsCount;

/**
  * @ClassName: UserCouponActivity
  * @Description: 我的优惠券查询
  * @author win10 2016年8月10日
  * @modify win10 2016年8月10日
  */
public interface MyCoupon {
	
	public List<CouponActivity> findMyCoupon(int userId);
	
	public CouponActivity  getCouponCode(UserWeixin user, CouponCode couponCode);

	public double validCouponCode(int userId, String childCode,double amount);

	public Integer validCount(Integer userId);
	
	/**
	 * <b>方法名：</b>：findMyCoupos2<br>
	 * <b>功能说明：</b>：我的优惠券信息查询<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年4月11日 上午10:55:13
	 * @param userId
	 * @return
	 */
	public List<CouponActivityV2> findMyCoupos2(int userId, int status);
	
	/**
	 * 
	 * <b>方法名：</b>：doCountUserCoupnsByUser<br>
	 * <b>功能说明：</b>：更具类型统计用户优惠券数量<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年4月11日 上午11:55:23
	 * @param userId
	 * @return
	 */
	public MyCouponsCount doCountUserCoupnsByUser(int userId);
	
}
