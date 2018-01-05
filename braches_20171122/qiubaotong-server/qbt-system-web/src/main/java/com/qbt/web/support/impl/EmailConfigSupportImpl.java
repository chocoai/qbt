/**
 * Project Name:qbt-system-web
 * File Name:EmailConfigSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年10月24日上午11:18:52
 *
*/

package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.JSonUtil;
import com.qbt.persistent.entity.EmailConfig;
import com.qbt.service.EmailConfigService;
import com.qbt.web.pojo.emailConfig.EmailConfigPageReqVo;
import com.qbt.web.pojo.emailConfig.EmailConfigVo;
import com.qbt.web.support.EmailConfigSupport;

/**
 * ClassName:EmailConfigSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月24日 上午11:18:52
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class EmailConfigSupportImpl implements EmailConfigSupport {
	
	@Resource
	private EmailConfigService emailConfigService;
	
	@Override
	public int add(EmailConfigVo vo) {
		EmailConfig emailConfig = emailConfigService.findByCode(vo.getCode());
		if(Checker.isNotEmpty(emailConfig)) {
			throw new BusinessException("标识码已存在");
		}
		emailConfig = VoToEntity(vo);
		return emailConfigService.insert(emailConfig);
	}

	@Override
	public boolean update(EmailConfigVo vo) {
		EmailConfig emailConfig = VoToEntity(vo);
		return emailConfigService.updateById(emailConfig) > 0;
	}

	@Override
	public EmailConfigVo detail(int id) {
		EmailConfig emailConfig = emailConfigService.findById(id);
		EmailConfigVo vo = entityToVo(emailConfig);
		return vo;
	}

	@Override
	public List<EmailConfigVo> findByPage(EmailConfigPageReqVo reqVo) {
		PageEntity<EmailConfig> pageEntity = BeanUtil.pageConvert(reqVo, EmailConfig.class);
		List<EmailConfig> list = emailConfigService.findByPage(pageEntity);
		List<EmailConfigVo> voList = new ArrayList<EmailConfigVo>();
		for(EmailConfig e : list) {
			EmailConfigVo vo = entityToVo(e);
			voList.add(vo);
		}
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}
	
	private EmailConfigVo entityToVo(EmailConfig emailConfig) {
		if(emailConfig == null) return null;
		EmailConfigVo vo = new EmailConfigVo();
		vo.setId(emailConfig.getId());
		vo.setCreateTime(emailConfig.getCreateTime());
		vo.setUpdateTime(emailConfig.getUpdateTime());
		vo.setPlatform(emailConfig.getPlatform());
		vo.setCode(emailConfig.getCode());
		vo.setName(emailConfig.getName());
		vo.setHost(emailConfig.getHost());
		vo.setPort(emailConfig.getPort());
		vo.setUsername(emailConfig.getUsername());
		vo.setPassword(emailConfig.getPassword());
		vo.setSendFrom(emailConfig.getSendFrom());
		vo.setSendTo(JSonUtil.toArray(emailConfig.getSendTo(), String.class));
		vo.setSendToCc(JSonUtil.toArray(emailConfig.getSendToCc(), String.class));
		vo.setOperatorId(emailConfig.getOperatorId());
		vo.setOperatorName(emailConfig.getOperatorName());
		return vo;
	}
	
	private EmailConfig VoToEntity(EmailConfigVo vo) {
		if(vo == null) return null;
		EmailConfig emailConfig = new EmailConfig();
		emailConfig.setId(vo.getId());
		emailConfig.setCreateTime(vo.getCreateTime());
		emailConfig.setUpdateTime(vo.getUpdateTime());
		emailConfig.setPlatform(vo.getPlatform());
		emailConfig.setCode(vo.getCode());
		emailConfig.setName(vo.getName());
		emailConfig.setHost(vo.getHost());
		emailConfig.setPort(vo.getPort());
		emailConfig.setUsername(vo.getUsername());
		emailConfig.setPassword(vo.getPassword());
		emailConfig.setSendFrom(vo.getSendFrom());
		emailConfig.setSendTo(JSonUtil.toJSonString(vo.getSendTo()));
		emailConfig.setSendToCc(JSonUtil.toJSonString(vo.getSendToCc()));
		emailConfig.setOperatorId(vo.getOperatorId());
		emailConfig.setOperatorName(vo.getOperatorName());
		return emailConfig;
	}
	
}
