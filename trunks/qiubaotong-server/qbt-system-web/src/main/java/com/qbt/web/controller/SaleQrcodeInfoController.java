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
import com.qbt.web.pojo.saleQrcodeInfo.SaleQrcodeInfoPageReqVo;
import com.qbt.web.pojo.saleQrcodeInfo.SaleQrcodeInfoVo;
import com.qbt.web.support.SaleQrcodeInfoSupport;

/**
 * 销售详情
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/saleQrcodeInfo")
public class SaleQrcodeInfoController {

	@Resource
	private SaleQrcodeInfoSupport saleQrcodeInfoSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<SaleQrcodeInfoVo>> findByPage(@RequestBody SaleQrcodeInfoPageReqVo reqVo){
		PageResult<List<SaleQrcodeInfoVo>> result = new PageResult<List<SaleQrcodeInfoVo>>();
		try {
			result.setDatas(saleQrcodeInfoSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "二维码详情分页列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
