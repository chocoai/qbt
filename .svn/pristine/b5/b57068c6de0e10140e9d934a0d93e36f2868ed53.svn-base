package com.qbt.timer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.enums.MqTypeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.OrderDelayTask;
import com.qbt.redis.RedisService;
import com.qbt.service.OrderDelayTaskService;
import com.qbt.timer.TimerService;

@Service("orderDelayTimerService")
public class OrderDelayTimerServiceImpl extends TimerService {
	
	@Resource
	private OrderDelayTaskService orderDelayTaskService;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public void process() {
		List<OrderDelayTask> delayList = orderDelayTaskService.findValidTasks();
		if(Checker.isNotEmpty(delayList)){
			String mqKey = RedisKeyUtil.mq_order_pay_sucess_redis_key(MqTypeEnum.order_pay_sucess.getType());
			for(OrderDelayTask t : delayList){
				//redis 队列处理发送顺丰和微信通知功能，走异步方式
				//发订单信息到顺丰接口
				redisService.lpush(mqKey, String.valueOf(t.getOrderId()));
				//更新延迟下单状态
				orderDelayTaskService.updateById(2, t.getId());
				LogCvt.info("订单ID[" + t.getOrderId() +"] 已处理完成");
			}
		}
	}

}
