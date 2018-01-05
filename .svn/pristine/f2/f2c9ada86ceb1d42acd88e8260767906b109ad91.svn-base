package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.MailChannel;
import com.qbt.persistent.mapper.MailChannelMapper;
import com.qbt.service.MailChannelService;

@Service
public class MailChannelServiceImpl implements MailChannelService {
	@Resource
	private MailChannelMapper mapper;
	
	@Override
	public List<MailChannel> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public MailChannel findById(int id) {
		return mapper.findById(id);
	}

}
