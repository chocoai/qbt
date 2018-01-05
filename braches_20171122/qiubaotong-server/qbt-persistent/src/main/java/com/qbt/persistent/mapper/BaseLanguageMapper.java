package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.persistent.entity.BaseLanguage;

public interface BaseLanguageMapper {
	
	List<BaseLanguage> list();

	BaseLanguage findById(Integer id);
	
}
