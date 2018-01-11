package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

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
import com.qbt.web.pojo.asAp.UserAsApPageReqVo;
import com.qbt.web.pojo.asAp.UserAsApVo;
import com.qbt.web.pojo.asAp.UserAsUpdateVo;
import com.qbt.web.support.UserAsApSupport;
/**
 * 球包助理审核
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/userAssistantApply")
public class UserAssistantApplyController {
	
	@Resource
	private UserAsApSupport userAsApSupport;
	
	/**
	 * 获取分页列表，包括搜索
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<UserAsApVo>> findByPage(@RequestBody UserAsApPageReqVo reqVo){
		PageResult<List<UserAsApVo>> result = new PageResult<List<UserAsApVo>>();
		try {
			result.setDatas(userAsApSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "审核球包助理分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 更新状态
	 * @param u
	 * @return
	 */
	@RequestMapping("updateStatus")
	public Result<String> updateStatus(@RequestBody UserAsUpdateVo reqVo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(reqVo);
			userAsApSupport.updateStatus(reqVo);
			result.setDatas("更新状态成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新状态异常");
		}
		return result;
	}
	
	/**
	 * 根据球场拿助理列表(只做球场)
	 */
	@RequestMapping("list")
	public Result<List<UserAsApVo>> list(Integer applyId,int applyType){
		Result<List<UserAsApVo>> result = new Result<List<UserAsApVo>>();
		List<UserAsApVo> adminUserAssistantVOList = userAsApSupport.list(applyId, applyType);
		result.setDatas(adminUserAssistantVOList);
		return result;
	}
	
	
}
