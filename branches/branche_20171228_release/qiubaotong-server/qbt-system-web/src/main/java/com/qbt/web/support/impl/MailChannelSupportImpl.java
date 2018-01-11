package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.MailChannel;
import com.qbt.service.MailChannelService;
import com.qbt.web.pojo.mailChannel.MailChannelVo;
import com.qbt.web.support.MailChannelSupport;

@Service
public class MailChannelSupportImpl implements MailChannelSupport {
	@Resource
	private MailChannelService service;
	
	@Override
	public List<MailChannelVo> findAll() {
		List<MailChannel> list = service.findAll();
		return BeanUtil.list2list(list, MailChannelVo.class);
	}

}
