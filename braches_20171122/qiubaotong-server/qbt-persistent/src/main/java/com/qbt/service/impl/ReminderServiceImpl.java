package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.Reminder;
import com.qbt.persistent.mapper.ReminderMapper;
import com.qbt.service.ReminderService;

@Service
public class ReminderServiceImpl implements ReminderService {
	
	@Resource
	private ReminderMapper reminderMapper;
	
	@Override
	public List<Reminder> findByPage(PageEntity<Reminder> pageEntity) {
		return reminderMapper.findByPage(pageEntity);
	}

	@Override
	public Reminder findById(Integer id) {
		return reminderMapper.selectById(id);
	}

	@Override
	public int insert(Reminder reminder) {
		int count = reminderMapper.insert(reminder);
		return reminder.getId();
	}

	@Override
	public int update(Reminder reminder) {
		if(reminder.getId() > 0){
			int count = reminderMapper.updateById(reminder);
			return count;
		}
		return 0;
	}

	@Override
	public List<Reminder> list() {
		return reminderMapper.list();
	}

}
