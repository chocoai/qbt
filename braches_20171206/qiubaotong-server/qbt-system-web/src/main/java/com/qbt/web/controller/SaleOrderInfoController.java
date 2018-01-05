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
import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoPageReqVo;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderInfoVo;
import com.qbt.web.support.SaleOrderInfoSupport;

/**
 * 销售人员代下单业绩
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/saleOrderInfo")
public class SaleOrderInfoController {

	@Resource
	private SaleOrderInfoSupport saleOrderInfoSupport;
	
	@RequestMapping(value = "findByPageBySaleId", method = RequestMethod.POST)
	public PageResult<List<SaleOrderInfoVo>> findByPageBySaleId(@RequestBody SaleOrderInfoPageReqVo reqVo){
		PageResult<List<SaleOrderInfoVo>> result = new PageResult<List<SaleOrderInfoVo>>();
		try {
			result.setDatas(saleOrderInfoSupport.findByPageBySaleId(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "代下单提成列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
