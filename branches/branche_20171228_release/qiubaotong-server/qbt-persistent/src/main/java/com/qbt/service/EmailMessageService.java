package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.EmailMessageDto;
import com.qbt.persistent.entity.EmailMessage;

public interface EmailMessageService {

	List<EmailMessage> findByPage(PageEntity<EmailMessageDto> pageEntity);
	
	EmailMessage findByUuid(String uuid);
}
