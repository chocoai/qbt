package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.baseAdvert.BaseAdvertPageReq;
import com.qbt.web.pojo.baseAdvert.BaseAdvertVo;
import com.qbt.web.support.BaseAdvertSupport;
import com.qbt.web.support.LoginSupport;

/**
 * 广告
 * ClassName: BaseAdvertController
 * Function: TODO ADD FUNCTION
 * date: 2017年10月10日 上午10:02:00
 *
 * @author wuwang
 * @version
 */
@Controller
@RequestMapping("/baseAdvert")
public class BaseAdvertController {

	@Resource
	private BaseAdvertSupport baseAdvertSupport;
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseAdvertVo>> findByPage(@RequestBody BaseAdvertPageReq pageReq){
		PageResult<List<BaseAdvertVo>> result = new PageResult<List<BaseAdvertVo>>();
		try {
			result.setDatas(baseAdvertSupport.findByPage(pageReq));
			result.setPage(pageReq);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("分页查询异常");
		}
		return result;
	}
	
	@RequestMapping("updateStatus")
	public Result<String> updateStatus(Integer id, int status){
		Result<String> result = new Result<String>();
		try {
			baseAdvertSupport.updateStatus(id, status);
			result.setDatas("更新状态成功");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新状态异常");
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<BaseAdvertVo> findById(Integer id){
		Result<BaseAdvertVo> result = new Result<BaseAdvertVo>();
		BaseAdvertVo vo = null;
		try {
			vo = baseAdvertSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(vo);
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(HttpServletRequest request, @RequestBody BaseAdvertVo reqVo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			baseAdvertSupport.update(sysUser, reqVo);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/*@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseAdvertVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseAdvertSupport.add(vo);
			result.setDatas("添加成功");
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			String errMsg = "添加异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}*/
	
	
	
}
