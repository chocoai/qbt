package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.saleQrcodeCreateInfo.SaleQrcodeCreateInfoPageReqVo;
import com.qbt.web.pojo.saleQrcodeCreateInfo.SaleQrcodeCreateInfoVo;
import com.qbt.web.support.SaleQrcodeCreateInfoSupport;

/**
 * 销售记录
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/saleQrcodeCreateInfo")
public class SaleQrcodeCreateInfoController {

	@Resource
	private SaleQrcodeCreateInfoSupport saleQrcodeCreateInfoSupport;
	
	@Value("${local.images.dir}")
	private String localImagesDir;
	
	//批量生成
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody SaleQrcodeCreateInfoVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			saleQrcodeCreateInfoSupport.add(vo);
			result.setDatas("销售人员二维码生成成功");
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "销售人员二维码生成异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 分页
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<SaleQrcodeCreateInfoVo>> findByPage(@RequestBody SaleQrcodeCreateInfoPageReqVo reqVo){
		PageResult<List<SaleQrcodeCreateInfoVo>> result = new PageResult<List<SaleQrcodeCreateInfoVo>>();
		try {
			result.setDatas(saleQrcodeCreateInfoSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "销售人员二维码管理列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
