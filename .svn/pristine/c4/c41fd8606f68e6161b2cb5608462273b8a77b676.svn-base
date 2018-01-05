
 /**
 * @Title: ActivityTest.java
 * @Package com.qtb.test
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月14日
 * @version V1.0
 **/

package com.qbt.test;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.redis.RedisService;
import com.qbt.web.support.ActivitySupport;

/**
  * @ClassName: ActivityTest
  * @Description: TODO
  * @author win10 2016年8月14日
  * @modify win10 2016年8月14日
  */
@ContextConfiguration(locations={"classpath*:context/applicationContext*.xml"})
public class ActivityTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	private ActivitySupport activitySupport;
	
	@Resource
	private RedisService redisService;
	
//	@Test
//	public void addActivity(){
//		ActivityAddReqVo vo = new ActivityAddReqVo();
//		vo.setName("优惠活动1");
//		vo.setStartTime(new Date());
//		vo.setEndTime(DateUtil.str2Date("20160901", DateUtil.DATE_FORMAT_YYYYMMDD));
//		vo.setActivityStartTime(new Date());
//		vo.setActivityEndTime(DateUtil.str2Date("20160901", DateUtil.DATE_FORMAT_YYYYMMDD));
//		vo.setCode("123456");
//		vo.setMaxPerOne(1);
//		vo.setCouponCount(50);
//		vo.setCouponType(1);
//		vo.setAmount(10d);
//		try {
//			activitySupport.add(vo);
//		} catch (BusinessException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	@Test
	public void delActityRedis() {
//		List<Activity> list = activityMapper.findByCondition(new Activity());
//		for(Activity a : list) {
//			redisService.del(RedisKeyUtil.Activity_Code_Redis_Key(a.getCode()));
//		}
		Set<String> keys = redisService.keys("activity:*");
		for(String k : keys) {
			if(k.contains("activity:index") 
					|| k.contains("activity:index") 
					|| k.contains("activity:copuon")
					|| k.contains("activity:copuon:lock")) {
				System.out.println(k);
				System.out.println("~~~~~continune~~~~~");
				continue;
			}
			redisService.del(k);
		}
		System.out.println("============" + keys.size() + "============");
	}
	
}

