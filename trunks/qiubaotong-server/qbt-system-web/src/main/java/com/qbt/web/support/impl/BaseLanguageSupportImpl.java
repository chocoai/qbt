package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.util.BeanUtil;
import com.qbt.persistent.entity.BaseLanguage;
import com.qbt.service.BaseLanguageService;
import com.qbt.web.pojo.baseLanguage.BaseLanguageVO;
import com.qbt.web.support.BaseLanguageSupport;

@Service
public class BaseLanguageSupportImpl implements BaseLanguageSupport{

	@Resource
	private BaseLanguageService baseLanguageService;
	
	public List<BaseLanguageVO> list() {
		List<BaseLanguage> baseLanguageList = baseLanguageService.list();
		List<BaseLanguageVO> BaseLanguageVOList = BeanUtil.list2list(baseLanguageList, BaseLanguageVO.class);
		return BaseLanguageVOList;
	}

}
