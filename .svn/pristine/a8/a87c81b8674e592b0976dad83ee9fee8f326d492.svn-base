/**
 * Project Name:qbt-persistent
 * File Name:EmailTemplateServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年10月18日下午4:09:34
 *
*/

package com.qbt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.Checker;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.EmailTemplate;
import com.qbt.persistent.mapper.EmailTemplateMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.EmailTemplateService;

/**
 * ClassName:EmailTemplateServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月18日 下午4:09:34
 * @author   wuwang
 * @version  
 * @see 	 
 */
@Service
public class EmailTemplateServiceImpl implements EmailTemplateService {
	
	@Resource
	private EmailTemplateMapper emailTemplateMapper;
	@Resource
	private RedisService redisService;
	
	@Override
	public EmailTemplate findByCode(String code) {
		String key = RedisKeyUtil.email_template_code_key(code);
		EmailTemplate emailTemplate = RedisUtil.getByRedis(redisService.getMap(key), EmailTemplate.class);
		if(Checker.isEmpty(emailTemplate)){
			emailTemplate = emailTemplateMapper.findByCode(code);
			if(Checker.isNotEmpty(emailTemplate)){
				redisService.putMap(key, RedisUtil.hashsMap(emailTemplate));
			}
		}
		return emailTemplate;
	}

}
