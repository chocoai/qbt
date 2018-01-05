package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.BaseSfPrice;
import com.qbt.web.pojo.baseSFPrice.BaseSFPricePageReqVo;
import com.qbt.web.pojo.baseSFPrice.BaseSFPriceVo;
import com.qbt.web.support.BaseSFPriceSupport;

/**
 * 价格模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/baseSFPrice")
public class BaseSFPriceController {
	
	@Resource
	private BaseSFPriceSupport baseSFPriceSupport;
	
	/**
	 * 获取列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseSFPriceVo>> findByPage(@RequestBody BaseSFPricePageReqVo reqVo){
		PageResult<List<BaseSFPriceVo>> result = new PageResult<List<BaseSFPriceVo>>();
		try {
			result.setDatas(baseSFPriceSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "顺丰价格列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteById")
	public Result<String> deleteById(Integer id){
		Result<String> result = new Result<String>();
		try {
			baseSFPriceSupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除顺丰价格异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 新建
	 * @param baseSfPrice
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseSFPriceVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseSFPriceSupport.add(vo);
			result.setDatas("添加成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "添加顺丰价格异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 *根据id更新 
	 * @param baseSfPrice
	 * @return
	 */
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseSfPrice baseSfPrice){
		Result<String> result = new Result<String>();
		try {
			baseSFPriceSupport.updateById(baseSfPrice);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "编辑顺丰价格异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
