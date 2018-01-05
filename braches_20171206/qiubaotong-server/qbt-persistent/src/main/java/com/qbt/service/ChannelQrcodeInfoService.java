package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.ChannelQrcodeInfo;

public interface ChannelQrcodeInfoService {

	List<ChannelQrcodeInfo> findByPage(PageEntity<ChannelQrcodeInfo> pageEntity);

	void add(ChannelQrcodeInfo channelQrcodeInfo);

	void update(ChannelQrcodeInfo channelQrcodeInfo);

	void updateStatus(Integer id, int status);

	ChannelQrcodeInfo findById(Integer id);

	ChannelQrcodeInfo findByChannelQrcodeCode(String channelQrcodeCode);
	
	List<String> findAllChannelQrcodeCode();
}
