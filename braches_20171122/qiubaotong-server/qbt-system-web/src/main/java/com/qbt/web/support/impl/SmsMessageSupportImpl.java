package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.SmsMessage;
import com.qbt.service.SmsMessageService;
import com.qbt.web.pojo.smsMessage.SmsMessagePageReqVo;
import com.qbt.web.pojo.smsMessage.SmsMessageVo;
import com.qbt.web.support.SmsMessageSupport;

@Service
public class SmsMessageSupportImpl implements SmsMessageSupport {

	@Resource
	private SmsMessageService smsMessagService;
	
	@Override
	public List<SmsMessageVo> findByPage(SmsMessagePageReqVo reqVo) {
		PageEntity<SmsMessage> pageEntity = BeanUtil.pageConvert(reqVo, SmsMessage.class);
		List<SmsMessage> list = smsMessagService.findByPage(pageEntity);
		List<SmsMessageVo> voList = BeanUtil.list2list(list, SmsMessageVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

}
