package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ChannelQrcodeInfo;
import com.qbt.persistent.mapper.ChannelQrcodeInfoMapper;
import com.qbt.service.ChannelQrcodeInfoService;

@Service
public class ChannelQrcodeInfoServiceImpl implements ChannelQrcodeInfoService{

	@Resource
	private ChannelQrcodeInfoMapper channelQrcodeInfoMapper;

	@Override
	public List<ChannelQrcodeInfo> findByPage(PageEntity<ChannelQrcodeInfo> pageEntity) {
		return channelQrcodeInfoMapper.findByPage(pageEntity);
	}

	@Override
	public void add(ChannelQrcodeInfo channelQrcodeInfo) {
		channelQrcodeInfoMapper.insert(channelQrcodeInfo);
	}

	@Override
	public void update(ChannelQrcodeInfo channelQrcodeInfo) {
		channelQrcodeInfoMapper.updateById(channelQrcodeInfo);
	}

	@Override
	public void updateStatus(Integer id, int status) {
		channelQrcodeInfoMapper.updateStatus(id, status);
	}

	@Override
	public ChannelQrcodeInfo findById(Integer id) {
		return channelQrcodeInfoMapper.findById(id);
	}

	@Override
	public ChannelQrcodeInfo findByChannelQrcodeCode(String channelQrcodeCode) {
		return channelQrcodeInfoMapper.findByChannelQrcodeCode(channelQrcodeCode);
	}

	@Override
	public List<String> findAllChannelQrcodeCode() {
		return channelQrcodeInfoMapper.findAllChannelQrcodeCode();
	}
	
}

