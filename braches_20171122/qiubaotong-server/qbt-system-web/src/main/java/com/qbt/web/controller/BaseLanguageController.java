package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.result.Result;
import com.qbt.web.pojo.baseLanguage.BaseLanguageVO;
import com.qbt.web.support.BaseLanguageSupport;

/**
 * 语言种类模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/baseLanguage")
public class BaseLanguageController {

	@Resource
	private BaseLanguageSupport baseLanguageSupport;
	
	@RequestMapping("list")
	public Result<List<BaseLanguageVO>> list(){
		Result<List<BaseLanguageVO>> result = new Result<List<BaseLanguageVO>>();
		List<BaseLanguageVO> baseLanguageVOList = baseLanguageSupport.list();
		result.setDatas(baseLanguageVOList);
		return result;
	}
	
}
