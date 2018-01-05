package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.result.Result;
import com.qbt.web.pojo.baseParnerLanguage.BasePartnerLanguageVO;
import com.qbt.web.support.BasePartnerLanguageSupport;

/**
 * 旅行社语言模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/basePartnerLanguage")
public class BasePartnerLanguageController {

	@Resource
	private BasePartnerLanguageSupport basePartnerLanguageSupport;
	
	/**
	 * 根据旅行社ID获取旅行社语言列表接口
	 * @param partnerlId
	 * @return
	 */
	@RequestMapping("listByPartnerlId")
	public Result<List<BasePartnerLanguageVO>> listByPartnerlId(int partnerlId){
		Result<List<BasePartnerLanguageVO>> result = new Result<List<BasePartnerLanguageVO>>();
		List<BasePartnerLanguageVO> basePartnerLanguageVOList = basePartnerLanguageSupport.listByPartnerlId(partnerlId);
		result.setDatas(basePartnerLanguageVOList);
		return result;
	}
	
}
