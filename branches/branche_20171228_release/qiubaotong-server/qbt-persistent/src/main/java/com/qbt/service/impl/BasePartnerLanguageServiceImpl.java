package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.BasePartnerLanguage;
import com.qbt.persistent.mapper.BasePartnerLanguageMapper;
import com.qbt.service.BasePartnerLanguageService;

@Service
public class BasePartnerLanguageServiceImpl implements BasePartnerLanguageService {

	@Resource
	private BasePartnerLanguageMapper basePartnerLanguageMapper;
	
	@Override
	public List<BasePartnerLanguage> listByPartnerlId(int partnerlId) {
		// TODO Auto-generated method stub
		return basePartnerLanguageMapper.listByPartnerlId(partnerlId);
	}

	@Override
	public void insert(List<BasePartnerLanguage> basePartnerLanguageList) {
		// TODO Auto-generated method stub
		basePartnerLanguageMapper.insert(basePartnerLanguageList);
	}

	@Override
	public void deleteByPartnerlId(int partnerlId) {
		// TODO Auto-generated method stub
		basePartnerLanguageMapper.deleteByPartnerlId(partnerlId);
	}

}
