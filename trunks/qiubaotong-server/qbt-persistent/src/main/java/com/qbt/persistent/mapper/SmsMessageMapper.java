package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.SmsMessage;

public interface SmsMessageMapper {

	List<SmsMessage> findByPage(PageEntity<SmsMessage> pageEntity);

}
