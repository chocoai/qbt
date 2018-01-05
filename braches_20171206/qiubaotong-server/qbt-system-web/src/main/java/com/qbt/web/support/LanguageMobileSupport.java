package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.languageMobile.LanguageMobilePageReqVo;
import com.qbt.web.pojo.languageMobile.LanguageMobileVo;

public interface LanguageMobileSupport {
	
	int add(LanguageMobileVo vo);
	
	boolean delete(String mobile);
	
	List<LanguageMobileVo> findByPage(LanguageMobilePageReqVo reqVo);
}
