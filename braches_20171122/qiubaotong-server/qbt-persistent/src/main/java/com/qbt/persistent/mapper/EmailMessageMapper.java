package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.EmailMessageDto;
import com.qbt.persistent.entity.EmailMessage;

public interface EmailMessageMapper {

	List<EmailMessage> findByPage(PageEntity<EmailMessageDto> pageEntity);
	
	EmailMessage findByUuid(@Param("uuid")String uuid);
}
