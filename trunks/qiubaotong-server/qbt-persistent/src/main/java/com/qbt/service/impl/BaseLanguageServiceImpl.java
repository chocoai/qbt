package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BaseLanguage;
import com.qbt.persistent.mapper.BaseLanguageMapper;
import com.qbt.service.BaseLanguageService;

@Service
public class BaseLanguageServiceImpl implements BaseLanguageService{

	@Resource
	private BaseLanguageMapper baseLanguageMapper;
	
	@Override
	public List<BaseLanguage> list() {
		// TODO Auto-generated method stub
		return baseLanguageMapper.list();
	}

	@Override
	public BaseLanguage findById(Integer id) {
		// TODO Auto-generated method stub
		return baseLanguageMapper.findById(id);
	}

}
