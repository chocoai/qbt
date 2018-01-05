
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

package com.qtb.test;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.common.util.DateUtil;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.Activity;
import com.qbt.redis.impl.RedisManager;

/**
  * @ClassName: ActivityTest
  * @Description: TODO
  * @author win10 2016年8月14日
  * @modify win10 2016年8月14日
  */
@ContextConfiguration(locations={"classpath*:context/applicationContext*.xml"})
public class ActivityTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	 private RedisManager redis;
	
	@Test
	public void loadActivity(){
		
		
		String key=RedisKeyUtil.Activity_Code_Redis_Key("12345");
		Activity activity=new Activity();
		activity.setId(1);
		activity.setCreateTime(new Date());
		activity.setName("券码200");
		activity.setStartTime(new Date());
		activity.setEndTime(DateUtil.str2Date(DateUtil.dateCalculate(new Date(), 2),DateUtil.DATE_FORMAT_01));
		activity.setCode("12345");
		activity.setDesc("测试");
		activity.setMaxPerOne(1);
		activity.setStatus(1);
		System.out.println(RedisUtil.hashsMap(activity));
		redis.putMap(key, RedisUtil.hashsMap(activity));
		
		String Listkey=RedisKeyUtil.Activity_Coupon_Redis_Key(1);
		
		ArrayList<String> xx=new ArrayList<String>();
		xx.add("123456");
		
		redis.putList(Listkey, xx);
		
	}

}

