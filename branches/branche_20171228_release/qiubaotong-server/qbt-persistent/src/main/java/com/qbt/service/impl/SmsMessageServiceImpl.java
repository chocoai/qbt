package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SmsMessage;
import com.qbt.persistent.mapper.SmsMessageMapper;
import com.qbt.service.SmsMessageService;

@Service
public class SmsMessageServiceImpl implements SmsMessageService{

	@Resource
	private SmsMessageMapper smsMessageMapper;
	
	@Override
	public List<SmsMessage> findByPage(PageEntity<SmsMessage> pageEntity) {
		// TODO Auto-generated method stub
		return smsMessageMapper.findByPage(pageEntity);
	}

}
