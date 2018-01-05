/**
 * Project Name:qbt-persistent
 * File Name:EmailConfigServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年10月23日下午3:07:20
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.EmailConfig;
import com.qbt.persistent.mapper.EmailConfigMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.EmailConfigService;

/**
 * ClassName:EmailConfigServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月23日 下午3:07:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class EmailConfigServiceImpl implements EmailConfigService {
	
	@Resource
	private EmailConfigMapper emailConfigMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public int insert(EmailConfig emailConfig) {
		emailConfigMapper.insert(emailConfig);
		redisService.putMap(RedisKeyUtil.email_config_code_key(emailConfig.getCode()), RedisUtil.hashsMap(emailConfig));
		return emailConfig.getId();
	}

	@Override
	public EmailConfig findById(Integer id) {
		return emailConfigMapper.selectById(id);
	}

	@Override
	public int updateById(EmailConfig emailConfig) {
		int result = emailConfigMapper.updateById(emailConfig);
		redisService.del(RedisKeyUtil.email_config_code_key(emailConfig.getCode()));
		return result;
	}

	@Override
	public EmailConfig findByCode(String code) {
		EmailConfig emailConfig = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.email_config_code_key(code)), EmailConfig.class);
		if(emailConfig == null) {
			emailConfig = emailConfigMapper.findByCode(code);
			if(emailConfig != null) {
				redisService.putMap(RedisKeyUtil.email_config_code_key(emailConfig.getCode()), RedisUtil.hashsMap(emailConfig));
			}
		}
		return emailConfig;
	}

	@Override
	public List<EmailConfig> findByPage(PageEntity<EmailConfig> pageEntity) {
		return emailConfigMapper.findByPage(pageEntity);
	}

}
