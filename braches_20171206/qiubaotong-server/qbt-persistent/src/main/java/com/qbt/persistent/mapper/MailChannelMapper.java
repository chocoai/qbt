package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.MailChannel;

public interface MailChannelMapper {
	List<MailChannel> findAll();

	MailChannel findById(int id);
}
