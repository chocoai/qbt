/**
 * Project Name:qbt-system-web
 * File Name:EmailConfigController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年10月24日下午2:51:47
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.emailConfig.EmailConfigPageReqVo;
import com.qbt.web.pojo.emailConfig.EmailConfigVo;
import com.qbt.web.support.EmailConfigSupport;
import com.qbt.web.support.LoginSupport;

/**
 * ClassName:EmailConfigController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年10月24日 下午2:51:47
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/emailConfig")
public class EmailConfigController {
	
	@Resource
	private EmailConfigSupport emailConfigSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody EmailConfigVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperatorId(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			result.setDatas(emailConfigSupport.add(vo));
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加邮箱配置异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 修改
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(HttpServletRequest request, @RequestBody EmailConfigVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperatorId(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			result.setDatas(emailConfigSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新邮箱配置异常";
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
	public PageResult<List<EmailConfigVo>> findByPage(@RequestBody EmailConfigPageReqVo reqVo) {
		PageResult<List<EmailConfigVo>> result = new PageResult<List<EmailConfigVo>>();
		try {
			result.setDatas(emailConfigSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "邮箱配置分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "detail")
	public Result<EmailConfigVo> detail(Integer id){
		Result<EmailConfigVo> result = new Result<EmailConfigVo>();
		try {
			result.setDatas(emailConfigSupport.detail(id));
		} catch (Exception e) {
			String errMsg = "查看邮箱配置详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
