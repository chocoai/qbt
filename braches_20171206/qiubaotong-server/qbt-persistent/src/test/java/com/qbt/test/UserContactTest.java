package com.qbt.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.qbt.redis.RedisService;

@ContextConfiguration(locations = {"classpath*:context/applicationContext*.xml"}) 
public class UserContactTest extends AbstractJUnit4SpringContextTests{
	
	@Resource(name="redisClusterService")
	private RedisService redisService;
	
	@Test  
    public void testAddUser() {
		for(int i=100 ; i < 1000 ; i++){
			redisService.set("test:key:"+i, i+"");
			System.out.println(redisService.get("test:key:"+i));
		}
	} 
	
//	@Test  
//    public void testgetUser() {  
//		
//       System.out.println(userContactService.findByMobile("18688151354").getName());
//    }
}
