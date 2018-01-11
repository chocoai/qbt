package com.qbt.timer;

import javax.annotation.Resource;

import com.qbt.common.logback.LogCvt;
import com.qbt.common.util.Config;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.service.CommonService;

public abstract class TimerService {

	@Resource
	private CommonService commonService;
	
	public abstract void process();
	
	public String getLockKey(){
		return RedisKeyUtil.timer_task_lock_key(this.getClass().getSimpleName());
	}
	
	public void run(){
		String key = getLockKey();
		try {
			String value = Config.getTomcat_ip()+":"+Config.getTomcat_port();
			long falg = commonService.lock(key,value,0);
			if(falg == 1){
				process();
			}else{
				String result = commonService.getLockValue(key);
				LogCvt.info("current timer task is running by "+result);
			}
		} catch (Exception e) {
			// TODO: handle exception
			LogCvt.error(e.getMessage(),e);
		} catch(Throwable e){
			LogCvt.error(e.getMessage(),e);
		}finally{
			commonService.unlock(key);
		}
	}
	
	
}
