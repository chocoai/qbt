package com.qbt.web.support.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.email.EmailService;
import com.qbt.persistent.dto.EmailMessageDto;
import com.qbt.persistent.entity.EmailMessage;
import com.qbt.service.EmailMessageService;
import com.qbt.web.pojo.emailMessage.EmailMessagePageReqVo;
import com.qbt.web.pojo.emailMessage.EmailMessageVo;
import com.qbt.web.support.EmailMessageSupport;

@Service
public class EmailMessageSupportImpl implements EmailMessageSupport {

	@Resource
	private EmailMessageService emailMessageService;
	
	@Resource
	private EmailService emailService;
	
	@Override
	public List<EmailMessageVo> findByPage(EmailMessagePageReqVo reqVo) {
		PageEntity<EmailMessageDto> pageEntity = BeanUtil.pageConvert(reqVo, EmailMessageDto.class);
		List<EmailMessage> list = emailMessageService.findByPage(pageEntity);
		List<EmailMessageVo> voList = BeanUtil.list2list(list, EmailMessageVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public boolean resend(String uuid) {
		EmailMessage message = emailMessageService.findByUuid(uuid);
		if(Checker.isNotEmpty(message)){
			emailService.sendEmail(uuid, 
					message.getHost(), 
					message.getPort(), 
					message.getUsername(), 
					message.getPassword(), 
					message.getSubject(), 
					message.getData(), 
					JSonUtil.toObject(message.getRecAddress(), List.class), 
					JSonUtil.toObject(message.getCcAddress(), List.class), 
					JSonUtil.toObject(message.getAttachments(), Map.class), 
					0, 
					message.getPlatform());
		}
		return true;
	}
	
	
}
