package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.MailChannel;

public interface MailChannelService {
	List<MailChannel> findAll();

	public MailChannel findById(int id);
}
