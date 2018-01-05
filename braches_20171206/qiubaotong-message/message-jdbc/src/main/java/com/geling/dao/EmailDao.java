package com.geling.dao;

import com.geling.msg.entity.email.EmailNotifyRequestEntity;

public interface EmailDao {

	int insert(EmailNotifyRequestEntity entity);

	void update(EmailNotifyRequestEntity mailRequest);
	
	int countByUuid(String uuid);
}
