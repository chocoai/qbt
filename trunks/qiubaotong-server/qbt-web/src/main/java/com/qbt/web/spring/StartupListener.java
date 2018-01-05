package com.qbt.web.spring;
import java.net.InetAddress;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.qbt.common.enums.MqTypeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.spring.SpringContextHolder;
import com.qbt.common.util.Config;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.redis.RedisService;
import com.qbt.web.mq.RedisMQService;
import com.qbt.web.mq.impl.RedisMQServiceImpl;
import com.qbt.web.mq.impl.RedisMQThread;
import com.qbt.web.mq.process.AbstractProcessService;
 
@Component
public class StartupListener implements ApplicationContextAware{
 
	
	/**
	 *  启动初始化数据业务
	  * @Title: setApplicationContext
	  * @Description: TODO
	  * @author: share 2016年8月15日
	  * @modify: share 2016年8月15日
	  * @param ctx
	  * @throws BeansException
	  * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        RedisMQService redisMqService = new RedisMQServiceImpl();
        
        RedisService redisService = SpringContextHolder.getBean("redisManager");
        String bspGateWay = redisService.get(RedisKeyUtil.sf_bsp_order_getaway_key());
        AbstractProcessService orderProcess = null;
        AbstractProcessService orderModifyProcess = null;
//        if(bspGateWay == null || "1".equalsIgnoreCase(bspGateWay)){
        	orderProcess = SpringContextHolder.getBean("orderProcessServiceImpl");
        	orderModifyProcess = SpringContextHolder.getBean("orderModifyProcessServiceImpl");
//        }else if("2".equalsIgnoreCase(bspGateWay)){
//        	orderProcess = SpringContextHolder.getBean("orderForwardProcessServiceImpl");
//        	orderModifyProcess = SpringContextHolder.getBean("orderModifyForwardProcessServiceImpl");
//        }
       
        AbstractProcessService messageProcess = SpringContextHolder.getBean("messageProcessServiceImpl");
        
        RedisMQThread orderThread = new RedisMQThread(RedisKeyUtil.mq_order_pay_sucess_redis_key(MqTypeEnum.order_pay_sucess.getType()), orderProcess);
        orderThread.setRedisService(redisService);
        redisMqService.registerMQService(orderThread);
        
        RedisMQThread orderModifyThread = new RedisMQThread(RedisKeyUtil.mq_order_pay_sucess_redis_key(MqTypeEnum.order_bps_uppdate.getType()), orderModifyProcess);
        orderModifyThread.setRedisService(redisService);
        redisMqService.registerMQService(orderModifyThread);
        
        RedisMQThread messageThread = new RedisMQThread(RedisKeyUtil.mq_order_pay_sucess_redis_key(MqTypeEnum.order_pay_message.getType()), messageProcess);
        messageThread.setRedisService(redisService);
        redisMqService.registerMQService(messageThread);
        
        redisMqService.start();
        
        try {
        	 String port = System.getProperty("tomcat_port", "8080");
             InetAddress inet = InetAddress.getLocalHost();
             String ip =   inet.getHostAddress();
             Config.setTomcat_ip(ip);
             Config.setTomcat_port(port);
		} catch (Exception e) {
			// TODO: handle exception
			LogCvt.error(e.getMessage(), e);
		}
       
        
    }
 
    
}