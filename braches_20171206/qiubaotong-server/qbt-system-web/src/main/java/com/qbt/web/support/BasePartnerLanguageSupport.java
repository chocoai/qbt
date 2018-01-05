package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.baseParnerLanguage.BasePartnerLanguageVO;

public interface BasePartnerLanguageSupport {

	List<BasePartnerLanguageVO> listByPartnerlId(int partnerlId);

}
