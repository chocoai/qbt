package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.reminder.ReminderAddReqVo;
import com.qbt.web.pojo.reminder.ReminderPageReqVo;
import com.qbt.web.pojo.reminder.ReminderVo;

public interface ReminderSupport {

	List<ReminderVo> findByPage(ReminderPageReqVo reqVo);
	
	ReminderVo findById(Integer id);
	
	int add(ReminderAddReqVo vo);
	
	boolean updateStatus(ReminderVo vo);
	
	List<ReminderVo> list();
}
