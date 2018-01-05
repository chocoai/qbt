package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.BasePartnerLanguage;

public interface BasePartnerLanguageMapper {

	List<BasePartnerLanguage> listByPartnerlId(int partnerlId);

	void insert(@Param("basePartnerLanguageList")List<BasePartnerLanguage> basePartnerLanguageList);

	void deleteByPartnerlId(int partnerlId);

}
