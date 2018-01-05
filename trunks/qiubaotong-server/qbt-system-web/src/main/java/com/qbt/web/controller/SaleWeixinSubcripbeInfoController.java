package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoPageReqVo;
import com.qbt.web.pojo.saleWeixinSubcripbeInfo.SaleWeixinSubcripbeInfoVo;
import com.qbt.web.support.SaleWeixinSubcripbeInfoSupport;

/**
 * 新拉关注奖金查询
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/saleWeixinSubcripbeInfo")
public class SaleWeixinSubcripbeInfoController {

	@Resource
	private SaleWeixinSubcripbeInfoSupport saleWeixinSubcripbeInfoSupport;
	
	@RequestMapping(value = "findByPageBySaleId", method = RequestMethod.POST)
	public PageResult<List<SaleWeixinSubcripbeInfoVo>> findByPageBySaleId(@RequestBody SaleWeixinSubcripbeInfoPageReqVo reqVo){
		PageResult<List<SaleWeixinSubcripbeInfoVo>> result = new PageResult<List<SaleWeixinSubcripbeInfoVo>>();
		try {
			result.setDatas(saleWeixinSubcripbeInfoSupport.findByPageBySaleId(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "销售新拉关注奖金列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
