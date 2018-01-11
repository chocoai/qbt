package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.EmailConfig;

public interface EmailConfigService {
	
    int insert(EmailConfig emailConfig);

    EmailConfig findById(Integer id);

    int updateById(EmailConfig emailConfig);
    
    EmailConfig findByCode(String code);
    
    List<EmailConfig> findByPage(PageEntity<EmailConfig> pageEntity);
}