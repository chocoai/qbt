package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseUserLabel;
import com.qbt.persistent.mapper.BaseUserLabelMapper;
import com.qbt.service.BaseUserLabelService;

@Service
public class BaseUserLabelServiceImpl implements BaseUserLabelService {

	@Resource
	private BaseUserLabelMapper baseUserLabelMapper;
	
	@Override
	public int insertByBatch(List<BaseUserLabel> configs) {
		return baseUserLabelMapper.insertByBatch(configs);
	}

	@Override
	public void deleteByMobile(String mobile) {
		baseUserLabelMapper.deleteByMobile(mobile);
	}

	@Override
	public List<BaseUserLabel> getByMobile(String mobile) {
		return baseUserLabelMapper.getByMobile(mobile);
	}

	@Override
	public List<BaseUserLabel> listContentByMobile(String mobile) {
		return baseUserLabelMapper.listContentByMobile(mobile);
	}

	@Override
	public List<BaseUserLabel> findByUser(Integer userType, Integer userId) {
		return baseUserLabelMapper.selectByUser(userType, userId);
	}

	@Override
	public List<BaseUserLabel> findContentByUser(Integer userType, Integer userId) {
		return baseUserLabelMapper.selectContentByUser(userType, userId);
	}

	@Override
	public void deleteByUser(Integer userType, Integer userId) {
		// TODO Auto-generated method stub
		baseUserLabelMapper.deleteByUser(userType, userId);
	}

}
