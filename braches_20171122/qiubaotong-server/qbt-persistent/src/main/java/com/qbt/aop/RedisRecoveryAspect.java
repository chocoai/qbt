/**
 * Project Name:qbt-persistent
 * File Name:RedisRecoveryAspect.java
 * Package Name:com.qbt.aop
 * Date:2017年7月13日上午10:00:15
 *
*/

package com.qbt.aop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.redis.RedisService;

/**
 * ClassName:RedisRecoveryAspect
 * Reason:	 TODO ADD REASON.
 * Date:     2017年7月13日 上午10:00:15
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Aspect
@Component
public class RedisRecoveryAspect {
	
	@Resource
	private RedisService redisService;
	
	@Resource(name = "couponCodeDataSearch")
	private DataColletionSearch couponCodeDataSearch;
	
	@Resource(name = "vipNoDataSearch")
	private DataColletionSearch vipNoDataSearch;
	
	@Resource(name = "channelQrcodeCodeDataSearch")
	private DataColletionSearch channelQrcodeCodeDataSearch;
	
	@Resource(name = "activityCouponCodeDataSearch")
	private DataColletionSearch activityCouponCodeDataSearch;
	
	@Resource(name = "sysSalesmanCodeDataSearch")
	private DataColletionSearch sysSalesmanCodeDataSearch;
	
	@Resource(name = "supLanguageMobileDataSearch")
	private DataColletionSearch supLanguageMobileDataSearch;
	
	/**
	 * 
	 * redisSetRecovery:(set集合数据恢复).
	 *
	 * @author huangyihao
	 * 2017年7月13日 上午10:02:44
	 * @param key
	 * @param data
	 *
	 */
	private void redisSetRecovery(String key, DataColletionSearch dataSearch, Object[] args) {
		Long count = redisService.scard(key);
		if(count == 0) {
			Set<String> data = new HashSet<String>(dataSearch.searchData(args));
			if(Checker.isNotEmpty(data)) {
				redisService.putSet(key, data);
			}
		}
	}
	
	/**
	 * 
	 * redisListRecovery:(list集合数据恢复).
	 *
	 * @author huangyihao
	 * 2017年7月13日 上午10:03:07
	 * @param key
	 * @param data
	 *
	 */
	private void redisListRecovery(String key, DataColletionSearch dataSearch, Object[] args) {
		Long count = redisService.llen(key);
		if(count == 0) {
			List<String> data = new ArrayList<String>(dataSearch.searchData(args));
			if(Checker.isNotEmpty(data)) {
				redisService.putList(key, data);
			}
		}
	}
	
	// 优惠券码redis数据恢复
	@Pointcut("execution(* com.qbt.service.CommonService.createCouponCode(..))")
	public void couponCodeAspect(){}
	
	@Before(value = "couponCodeAspect()")
	public void couponCodeRecovery(JoinPoint joinPoint){
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		String key = RedisKeyUtil.qbt_coupon_key();
		redisSetRecovery(key, couponCodeDataSearch, args);
	}
	
	// vip会员编号数据恢复
	@Pointcut("execution(* com.qbt.service.CommonService.createVipNo(..))")
	public void vipNoAspect(){}
	
	@Before(value = "vipNoAspect()")
	public void vipNoRecovery(JoinPoint joinPoint){
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		String key = RedisKeyUtil.qbt_vip_no_key();
		redisSetRecovery(key, vipNoDataSearch, args);
	}
	
	// 渠道二维码数据恢复
	@Pointcut("execution(* com.qbt.service.CommonService.createChannelQrcodeCode(..))")
	public void channelQrcodeCodeAspect(){}
	
	@Before(value = "channelQrcodeCodeAspect()")
	public void channelQrcodeCodeRecovery(JoinPoint joinPoint){
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		String key = RedisKeyUtil.qbt_channel_qrcode_code_key();
		redisSetRecovery(key, channelQrcodeCodeDataSearch, args);
	}
	
	// 活动优惠券码数据恢复
	@Pointcut("execution(* com.qbt.service.CouponService.getCouponCodeByActivity(..))")
	public void activityCouponCodeAspect() {}

	@Before(value = "activityCouponCodeAspect()")
	public void activityCouponCodeRecovery(JoinPoint joinPoint) {
		// 获取请求参数
		Object[] args = joinPoint.getArgs();
		int activityId = (Integer)args[0];
		String key = RedisKeyUtil.Activity_Coupon_Redis_Key(activityId);
		redisListRecovery(key, activityCouponCodeDataSearch, args);
	}

	// 系统生成销售二维码数据恢复
	@Pointcut("execution(* com.qbt.service.SaleQrcodeInfoService.getSysSalemanCode(..))")
	public void sysSalemanCodeAspect() {}

	@Before(value = "sysSalemanCodeAspect()")
	public void sysSalemanCodeRecovery(JoinPoint joinPoint) {
		// 获取请求参数
		Object[] args = joinPoint.getArgs();
		String key = RedisKeyUtil.salesman_code_key();
		redisListRecovery(key, sysSalesmanCodeDataSearch, args);
	}
	
	// 外语手机号缓存数据恢复
	@Pointcut("execution(* com.qbt.service.SupLanguageMobileService.exists(..))")
	public void supLanguageMobileAspect(){}
		
	@Before(value = "supLanguageMobileAspect()")
	public void supLanguageMobileRecovery(JoinPoint joinPoint){
		//获取请求参数
		Object[] args = joinPoint.getArgs();
		String key = RedisKeyUtil.language_mobile_key();
		redisSetRecovery(key, supLanguageMobileDataSearch, args);
	}
	
}
