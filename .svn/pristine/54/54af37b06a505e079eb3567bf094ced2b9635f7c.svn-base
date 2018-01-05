/**
 * Project Name:qbt-timer
 * File Name:SfExpressLogCleanTimerServiceImpl.java
 * Package Name:com.qbt.timer.impl
 * Date:2017年3月7日下午3:00:03
 *
*/

package com.qbt.timer.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.logback.LogCvt;
import com.qbt.service.BaseSfExpressLogService;
import com.qbt.timer.TimerService;

/**
 * ClassName:SfExpressLogCleanTimerServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年3月7日 下午3:00:03
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service("sfExpressLogCleanTimerService")
public class SfExpressLogCleanTimerServiceImpl extends TimerService {
	
	@Resource
	private BaseSfExpressLogService baseSfExpressLogService;
	
	@Override
	public void process() {
		//删除30天之前的日志
		int day = 30;
		int deleteCount = baseSfExpressLogService.deleteByDay(day);
		LogCvt.info("已清除顺丰发送日志表 " + day + " 天前的记录 " + deleteCount + " 条");
	}

}
