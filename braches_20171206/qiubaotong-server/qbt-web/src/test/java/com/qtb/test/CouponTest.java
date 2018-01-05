
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
import java.io.File;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.service.CouponService;

/**
  * @ClassName: ActivityTest
  * @Description: TODO
  * @author win10 2016年8月14日
  * @modify win10 2016年8月14日
  */
@ContextConfiguration(locations={"classpath*:context/applicationContext*.xml"})
public class CouponTest extends AbstractJUnit4SpringContextTests{
	
	@Resource
	 private CouponService service;
	
	@Test
	public void test(){
		
		System.out.println("--->"+service.selectCouponByChildCode("123456").getChildCode());
		System.out.println("--->"+service.selectCouponCountByUserId(2));
		System.out.println("--->"+service.selectCouponByActivityId(1).size());
		System.out.println("--->"+service.selectCouponByCode("123456").size());
		
	}
	
	public static void main(String[] args) {
		File file = new File("/Volumes/life/qrcode_2");
		File[] files = file.listFiles();
		int i = 1;
		StringBuilder sb = new StringBuilder();
		for(File qrcode : files){
			sb.append(qrcode.getName().substring(0,qrcode.getName().lastIndexOf("."))).append(",");
			if(i%3 == 0){
				System.out.println(sb.toString().substring(0, sb.length()-1));
				sb.delete(0, sb.length());
			}
			i++;
		}
		System.out.println(sb.toString().substring(0, sb.length()-1));
	}

}

