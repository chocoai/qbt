package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.Reminder;
import com.qbt.service.ReminderService;
import com.qbt.web.pojo.reminder.ReminderAddReqVo;
import com.qbt.web.pojo.reminder.ReminderPageReqVo;
import com.qbt.web.pojo.reminder.ReminderVo;
import com.qbt.web.support.ReminderSupport;

@Service
public class ReminderSupportImpl implements ReminderSupport {
	
	@Resource
	private ReminderService reminderService;
	
	@Override
	public List<ReminderVo> findByPage(ReminderPageReqVo reqVo) {
		PageEntity<Reminder> pageEntity = BeanUtil.pageConvert(reqVo, Reminder.class);
		
		List<Reminder> list = reminderService.findByPage(pageEntity);
		List<ReminderVo> voList = new ArrayList<ReminderVo>();
		for(Reminder act : list){
			ReminderVo vo = BeanUtil.a2b(act, ReminderVo.class);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public ReminderVo findById(Integer id) {
		Reminder activity = reminderService.findById(id);
		ReminderVo vo = BeanUtil.a2b(activity, ReminderVo.class);
		return vo;
	}

	@Override
	public int add(ReminderAddReqVo vo) {
		Reminder reminder = BeanUtil.a2b(vo, Reminder.class);
		int activityId = reminderService.insert(reminder);
		return activityId;
	}

	@Override
	public boolean updateStatus(ReminderVo vo) {
		Reminder reminder = reminderService.findById(vo.getId());
		if(Checker.isEmpty(reminder)) {
			throw new BusinessException(ErrorCodeEnum.ERROR_VALID_FAIL, "无效提示数据");
		}
		reminder.setStatus(vo.getStatus());
		return reminderService.update(reminder) > 0;
	}

	@Override
	public List<ReminderVo> list() {
		List<Reminder> list = reminderService.list();
		List<ReminderVo> voList = new ArrayList<ReminderVo>();
		for(Reminder act : list){
			ReminderVo vo = BeanUtil.a2b(act, ReminderVo.class);
			voList.add(vo);
		}
		return voList;
	}
	
}
