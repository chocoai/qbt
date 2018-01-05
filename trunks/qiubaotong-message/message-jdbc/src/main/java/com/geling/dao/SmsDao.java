package com.geling.dao;

import com.geling.msg.entity.sms.SMSNotifyRequestEntity;

public interface SmsDao {

	int insert(SMSNotifyRequestEntity entity);

	void update(SMSNotifyRequestEntity smsRequest);
	
	int countByUuid(String uuid);	
}
