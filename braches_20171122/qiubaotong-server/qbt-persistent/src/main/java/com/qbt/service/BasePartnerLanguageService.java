package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.BasePartnerLanguage;

public interface BasePartnerLanguageService {

	List<BasePartnerLanguage> listByPartnerlId(int partnerlId);
	
	void insert(List<BasePartnerLanguage> basePartnerLanguageList);

	void deleteByPartnerlId(int partnerlId);
	
}
