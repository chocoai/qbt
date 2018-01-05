package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.EmailMessageDto;
import com.qbt.persistent.entity.EmailMessage;
import com.qbt.persistent.mapper.EmailMessageMapper;
import com.qbt.service.EmailMessageService;

@Service
public class EmailMessageServiceImpl implements EmailMessageService {

	@Resource 
	private EmailMessageMapper emailMessageMapper;
	
	@Override
	public List<EmailMessage> findByPage(PageEntity<EmailMessageDto> pageEntity) {
		return emailMessageMapper.findByPage(pageEntity);
	}

	@Override
	public EmailMessage findByUuid(String uuid) {
		return emailMessageMapper.findByUuid(uuid);
	}

}
