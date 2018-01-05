package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.baseBankBranch.BaseBankBranchPageReqVo;
import com.qbt.web.pojo.baseBankBranch.BaseBankBranchVo;
import com.qbt.web.support.BaseBankBranchSupport;

/**
 * 银行网点模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/baseBankBranch")
public class BaseBankBranchController {
	
	@Resource
	private BaseBankBranchSupport baseBankBranchSupport;
	
	/**
	 * 获取分页列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseBankBranchVo>> findByPage(@RequestBody BaseBankBranchPageReqVo reqVo){
		PageResult<List<BaseBankBranchVo>> result = new PageResult<List<BaseBankBranchVo>>();
		try {
			result.setDatas(baseBankBranchSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "银行网点分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 添加
	 * @param baseBankBranch
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseBankBranchVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseBankBranchSupport.add(vo);
			result.setDatas("添加银行网点成功");
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "添加银行网点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 修改
	 * @param baseBankBranch
	 * @return
	 */
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseBankBranchVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseBankBranchSupport.updateById(vo);
			result.setDatas("修改银行网点成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "修改银行网点异常";
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
			baseBankBranchSupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除银行网点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findById")
	public Result<BaseBankBranchVo> findById(Integer id){
		Result<BaseBankBranchVo> result = new Result<BaseBankBranchVo>();
		BaseBankBranchVo baseBankBranchVo = null;
		try {
			baseBankBranchVo = baseBankBranchSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看微信用户详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(baseBankBranchVo);
		return result;
	}
	
	//软删除
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(@RequestParam(value = "id", required = true)Integer id
								, @RequestParam(value = "isDelete", required = false, defaultValue = "true")Boolean isDelete){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(baseBankBranchSupport.delete(id, isDelete));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "删除银行网点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
