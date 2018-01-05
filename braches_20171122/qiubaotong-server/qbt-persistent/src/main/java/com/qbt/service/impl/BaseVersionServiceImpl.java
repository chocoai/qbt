package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseVersion;
import com.qbt.persistent.mapper.BaseVersionMapper;
import com.qbt.service.BaseVersionService;

@Service
public class BaseVersionServiceImpl implements BaseVersionService {
	
	@Resource
	private BaseVersionMapper baseVersionMapper;
	
	@Override
	public int insert(BaseVersion baseVersion) {
		baseVersionMapper.insert(baseVersion);
		return baseVersion.getId();
	}

	@Override
	public List<BaseVersion> findAll() {
		return baseVersionMapper.findAll();
	}

}
