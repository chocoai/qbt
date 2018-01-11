package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.TicketPackageActivity;
import com.qbt.persistent.mapper.TicketPackageActivityMapper;
import com.qbt.service.TicketPackageActivityService;

@Service
public class TicketPackageActivityServiceImpl implements
		TicketPackageActivityService {

	@Resource
	private TicketPackageActivityMapper mapper;
	
	@Override
	public int insert(TicketPackageActivity activity) {
		return mapper.insert(activity);
	}

	@Override
	public List<TicketPackageActivity> findByPage(
			PageEntity<TicketPackageActivity> pageEntity) {
		
		return mapper.findByPage(pageEntity);
	}

	
}
