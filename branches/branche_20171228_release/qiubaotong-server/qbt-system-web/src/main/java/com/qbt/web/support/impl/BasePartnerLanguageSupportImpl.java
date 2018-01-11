package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BasePartnerLanguage;
import com.qbt.service.BasePartnerLanguageService;
import com.qbt.web.pojo.baseParnerLanguage.BasePartnerLanguageVO;
import com.qbt.web.support.BasePartnerLanguageSupport;

@Service
public class BasePartnerLanguageSupportImpl implements BasePartnerLanguageSupport {

	@Resource
	private BasePartnerLanguageService basePartnerLanguageService;
	
	@Override
	public List<BasePartnerLanguageVO> listByPartnerlId(int partnerlId) {
		List<BasePartnerLanguage> basePartnerLanguageList = basePartnerLanguageService.listByPartnerlId(partnerlId);
		List<BasePartnerLanguageVO> basePartnerLanguageVOList = BeanUtil.list2list(basePartnerLanguageList, BasePartnerLanguageVO.class);
		return basePartnerLanguageVOList;
	}

	
	
}
