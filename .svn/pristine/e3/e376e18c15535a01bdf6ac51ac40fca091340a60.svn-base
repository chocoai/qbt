package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.EmailConfig;

public interface EmailConfigMapper {
	
    int insert(EmailConfig record);

    EmailConfig selectById(Integer id);

    int updateById(EmailConfig record);
    
    EmailConfig findByCode(@Param("code")String code);
    
    List<EmailConfig> findByPage(PageEntity<EmailConfig> pageEntity);
}