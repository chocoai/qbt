package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.BaseLanguage;

public interface BaseLanguageService {

	public List<BaseLanguage> list();

	public BaseLanguage findById(Integer id);
	
}
