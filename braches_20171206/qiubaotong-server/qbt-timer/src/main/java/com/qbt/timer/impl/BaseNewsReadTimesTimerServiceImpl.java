package com.qbt.timer.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.persistent.entity.BaseNews;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseNewsService;
import com.qbt.timer.TimerService;

@Service("baseNewsReadTimesTimerService")
public class BaseNewsReadTimesTimerServiceImpl extends TimerService {

	@Resource
	private BaseNewsService baseNewsService;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public void process() {
		// TODO Auto-generated method stub
		String key = null;
		String readTimesStr = null;
		List<BaseNews> baseNewsList = baseNewsService.list(0);
		for (BaseNews baseNews : baseNewsList) {
			key = RedisKeyUtil.base_news_id_key(baseNews.getId());
			readTimesStr = redisService.get(key);
			if(Checker.isEmpty(readTimesStr)){
				readTimesStr = String.valueOf(baseNews.getReadTimes());
			}
			baseNewsService.updateReadTimesById(baseNews.getId(), Integer.parseInt(readTimesStr));
		}
		
		
	}

}
