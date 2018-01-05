
/**
* @Title: MyCouponSupportImpl.java
* @Package com.qbt.web.support.impl
* @Description: TODO
* Copyright:2016 qiubaotong All Rights Reserved   
* Company:www.qiubaotong.com
* 
* @creater win10 2016年8月10日
* @version V1.0
**/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.common.util.Md5;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.dto.UserCouponActivity;
import com.qbt.persistent.entity.Activity;
import com.qbt.persistent.entity.Coupon;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.redis.RedisService;
import com.qbt.service.ActivityService;
import com.qbt.service.CouponService;
import com.qbt.sms.api.service.SmsCodeService;
import com.qbt.web.pojo.coupon.CouponActivity;
import com.qbt.web.pojo.coupon.CouponActivityV2;
import com.qbt.web.pojo.coupon.CouponCode;
import com.qbt.web.pojo.coupon.MyCouponsCount;
import com.qbt.web.support.MyCoupon;

/**
 * @ClassName: MyCouponSupportImpl
 * @Description: 优惠券查询
 * @author win10 2016年8月10日
 * @modify win10 2016年8月10日
 */
@Service
public class MyCouponSupportImpl implements MyCoupon {
	@Resource
	private CouponService couponService;

	@Resource
	private SmsCodeService smsCodeService;

	@Resource
	private RedisService redisManager;
	
	@Resource
	private ActivityService activityService;
	
	/**
	 * @Title: findMyCoupon
	 * @Description: 我的优惠券查询
	 * @author: win10 2016年8月10日
	 * @modify: win10 2016年8月10日
	 * @param userId
	 * @return
	 * @see com.qbt.web.support.MyCoupon#findMyCoupon(int)
	 */

	@Override
	public List<CouponActivity> findMyCoupon(int userId) {
		List<UserCouponActivity> list = couponService.selectUserCoupon(userId, 0);
		List<CouponActivity> result = new ArrayList<CouponActivity>();
		Map<String, CouponActivity> map = new LinkedHashMap<String, CouponActivity>();
		List<String> childs = null;
		CouponActivity couponActivity = null;
		for (UserCouponActivity userCouponActivity : list) {
			String key = Md5.MD5Encode("" + userCouponActivity.getType() + userCouponActivity.getStartTime() + userCouponActivity.getEndTime() + userCouponActivity.getStatus() + userCouponActivity.getChildAmount() + userCouponActivity.getLimitAmount());
			couponActivity = map.get(key);
			if(Checker.isEmpty(couponActivity)){
				couponActivity = new CouponActivity();
				couponActivity.setName(userCouponActivity.getName());
				couponActivity.setStartTime(userCouponActivity.getStartTime());
				couponActivity.setEndTime(userCouponActivity.getEndTime());
				couponActivity.setStatus(userCouponActivity.getStatus());
				couponActivity.setType(userCouponActivity.getType());
				couponActivity.setChlidAmount(userCouponActivity.getChildAmount());
				couponActivity.setLimitAmount(userCouponActivity.getLimitAmount());
				childs = new ArrayList<String>();
				childs.add(userCouponActivity.getChildCode());
				couponActivity.setChildCodes(childs);
				couponActivity.setCouponCount(1);
				map.put(key, couponActivity);
			}else{
				childs = couponActivity.getChildCodes();
				childs.add(userCouponActivity.getChildCode());
				couponActivity.setCouponCount(childs.size());
				map.put(key, couponActivity);
			}
		}
		
		for(String key : map.keySet()){
			couponActivity = map.get(key);
			result.add(couponActivity);
		}
		return result;
	}

	/**
	  * @Title: getCouponCode
	  * @Description: 获取优惠券码
	  * 1.校验短信验证码
	  * 2.根据暗码查询活动 活动不存在进行活动加载
	  *   根据活动id,查询券码List，如果没有进行加载券码List,list为空 券码已经领完
	  *   查询redis,是否有领券，如果有进行判断，如果没有，进行数据库查询，
	  * @author: win10 2016年8月11日
	  * @modify: win10 2016年8月11日
	  * @param userId
	  * @param code
	  * @param mobile
	  * @param smsCode
	  * @return
	 */
	public CouponActivity getCouponCode(UserWeixin user, CouponCode couponCode){
		CouponActivity couponActivity =null;
		String code=couponCode.getCode();
		
		Activity activity=activityService.findByCode(code);
		if(activity  == null){
			throw new WechatException("8001", "暗码无对应的活动");
		}
		
		//活动失效
		if(activity.getStatus()==2){
			throw new WechatException("8001", "活动已失效,无法用暗码领券。");
		}
		
		if(activity.getMaxPerOne()<=0){
			throw new WechatException("8001", "活动无效，无法领用券码。");
		}
			
		//领券时间已截止
		
		if(DateUtil.compareDate(new Date(),activity.getEndTime())){
			throw new WechatException("8001", "活动领券时间已截止,无法用暗码领券。");
		}
			
		//检查个人是否超额领券
		String user_key=RedisKeyUtil.Activity_UserId_Redis_key(activity.getId(),user.getId());
			
		//检查名额是否存在
		if(redisManager.setnx(user_key, "1")==0){//名额值存在
			int i=Integer.parseInt(redisManager.get(user_key));
			if(i<activity.getMaxPerOne()){
				redisManager.incr(user_key);
			}else{
				throw new WechatException("8001", "您的领券名额已使用完，下次在来吧");
			}
		}
		
		//获取券码
		String couponId=couponService.getCouponCodeByActivity(activity.getId());
		if(couponId==null){
			throw new WechatException("8001", "活动券已领取完毕，下次早点来哦");
		}
		
		//更新值数据库关系
		Coupon coupon=new Coupon();
		
		coupon.setCode(couponId);
		coupon.setUserId(user.getId());
		coupon.setUserName(user.getNickname());
		coupon.setClaimType(1);
		coupon.setClaimTime(new Date());
		couponService.updateByCode(coupon);
		
		couponActivity=new CouponActivity();
		couponActivity.setName(activity.getName());
		couponActivity.setDescription(activity.getDesc());
		couponActivity.setEndTime(activity.getEndTime());
		couponActivity.setStartTime(activity.getStartTime());
		
		return couponActivity;
	}

	/**
	 *  纸质券码输入-券码校验接口
	  * @Title: valid_coupon_code
	  * @Description: TODO
	  * @author: share 2016年8月17日
	  * @modify: share 2016年8月17日
	  * @param userId
	  * @param child_code
	  * @return
	  * @see com.qbt.web.support.MyCoupon#valid_coupon_code(int, java.lang.String)
	 */
	@Override
	public double validCouponCode(int userId, String childCode, double amount) {
		Coupon coupon = couponService.selectCouponByChildCode(childCode);
		double discount = 0d;
		// 检查券号是否锁定
		String lockKey = RedisKeyUtil.Coupon_Pay_Lock_Redis_Key(childCode);
		boolean flag  = redisManager.exists(lockKey);
		if(flag){
			// 检查是否本人锁定定的券码
			int lockUserId = Integer.parseInt(redisManager.get(lockKey));
			if(lockUserId != userId){
				throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券码已被他人锁定，在支付使用中");
			}
		}
		// 券状态校验
		if(coupon == null || coupon.getStatus() != 1){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效券码或已使用");
		}
		// 用户输入点子券信息，检查电子券是否被别人绑定
		if(coupon.getUserId() != 0 && userId != coupon.getUserId()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "无法使用他人领用券");
		}
		// 订单未达到使用券限额
		if(amount < coupon.getLimitAmount()){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "此订单未达到使用券限额");
		}
		// 券有效期校验
		int status = coupon.getStatus() == 1 && DateUtil.getDiffDaysForDay(new Date(), coupon.getEndTime()) < 0 ? 3 : coupon.getStatus();
		if(status == 3){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券已失效");
		}
		if(DateUtil.getDiffDaysForDay(new Date(), coupon.getStartTime()) > 0){
			throw new WechatException(ErrorCodeEnum.ERROR_VALID_FAIL, "券无法提前使用");
		}
		discount = coupon.getChildAmount();
		return discount;
	}

	/**
	 *  校验用户有效券码的个数
	  * @Title: validCount
	  * @Description: TODO
	  * @author: share 2016年8月22日
	  * @modify: share 2016年8月22日
	  * @param userId
	  * @return
	  * @see com.qbt.web.support.MyCoupon#validCount(java.lang.Integer)
	 */
	@Override
	public Integer validCount(Integer userId) {
		return couponService.selectCouponCountByUserId(userId);
	}
	
	/**
	 * 
	 * <b>方法名：</b>：findMyCoupos2<br>
	 * <b>功能说明：</b>：我的优惠券查询<br>
	 * @see com.qbt.web.support.MyCoupon#findMyCoupos2(int)
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年4月11日 上午10:56:19
	 * @param userId
	 * @return
	 */
	@Override
	public List<CouponActivityV2> findMyCoupos2(int userId, int status){
		List<UserCouponActivity> list = couponService.selectUserCoupon(userId, status);
		List<CouponActivityV2> result = new ArrayList<CouponActivityV2>();
		CouponActivityV2 couponActivity = null;
		for (UserCouponActivity userCouponActivity : list) {
			couponActivity = new CouponActivityV2();
			couponActivity.setName(userCouponActivity.getName());
			couponActivity.setStartTime(userCouponActivity.getStartTime());
			couponActivity.setEndTime(userCouponActivity.getEndTime());
			couponActivity.setStatus(userCouponActivity.getStatus());
			couponActivity.setType(userCouponActivity.getType());
			couponActivity.setChlidAmount(userCouponActivity.getChildAmount());
			couponActivity.setLimitAmount(userCouponActivity.getLimitAmount());
			couponActivity.setChildCode(userCouponActivity.getChildCode());
			result.add(couponActivity);
		}
		return result;
	}

	/**
	 * 
	 * <b>方法名：</b>：doCountUserCoupnsByUser<br>
	 * <b>功能说明：</b>：统计优惠券数量<br>
	 * @see com.qbt.web.support.MyCoupon#doCountUserCoupnsByUser(int, int)
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年4月11日 下午12:00:15
	 * @param userId
	 * @param type
	 * @return
	 */
	@Override
	public MyCouponsCount doCountUserCoupnsByUser(int userId) {
		List<UserCouponActivity> list = couponService.selectUserCoupon(userId, 0);//用户优惠券
		int unusedCount = 0;//未使用
		int usedCount = 0;//已使用
		int overdueCount = 0;//已过期
		for (UserCouponActivity userCouponActivity : list) {
			//未使用并且 结束时间比现在小 == 3 已过期  ；  2  已使用过  1  未使用
//			int status = userCouponActivity.getStatus() == 1 && userCouponActivity.getEndTime().getTime() <= System.currentTimeMillis() ? 3 : userCouponActivity.getStatus();
			if (userCouponActivity.getStatus() == 1) {
				unusedCount++;
			}else if(userCouponActivity.getStatus() == 2){
				usedCount++;
			}else{
				overdueCount++;
			}
		}
		MyCouponsCount countInfo = new MyCouponsCount();
		countInfo.setUnusedCount(unusedCount);
		countInfo.setUsedCount(usedCount);
		countInfo.setOverdueCount(overdueCount);
		return countInfo;
	}
	
}
