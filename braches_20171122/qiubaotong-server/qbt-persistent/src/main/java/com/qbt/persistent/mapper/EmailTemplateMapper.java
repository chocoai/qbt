package com.qbt.persistent.mapper;

import com.qbt.persistent.entity.EmailTemplate;

public interface EmailTemplateMapper {
	
    int insert(EmailTemplate record);

    EmailTemplate findById(Integer id);

    int updateById(EmailTemplate record);

	EmailTemplate findByCode(String code);

}