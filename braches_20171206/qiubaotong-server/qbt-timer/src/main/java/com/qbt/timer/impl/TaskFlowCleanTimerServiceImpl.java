package com.qbt.timer.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.logback.LogCvt;
import com.qbt.service.OrderTaskFlowService;
import com.qbt.timer.TimerService;

@Service("taskFlowCleanTimerService")
public class TaskFlowCleanTimerServiceImpl extends TimerService {
	
	@Resource
	private OrderTaskFlowService orderTaskFlowService;
	
	@Override
	public void process() {
		int day = 15;//15天前
		int deleteCount = orderTaskFlowService.deleteByDay(day);
		LogCvt.info("已清除订单客服跟踪表 " + day + " 天前的记录 " + deleteCount + " 条");
	}

}
