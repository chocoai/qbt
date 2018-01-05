/**
 * Project Name:qbt-system-web
 * File Name:BagCodePartnerController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年8月25日上午11:54:55
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
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.bagCode.BagCodePartnerPageReq;
import com.qbt.web.pojo.bagCode.BagCodePartnerVo;
import com.qbt.web.support.BagCodePartnerSupport;
import com.qbt.web.support.LoginSupport;

/**
 * ClassName:BagCodePartnerController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月25日 上午11:54:55
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/bagCodePartner")
public class BagCodePartnerController {
	
	@Resource
	private BagCodePartnerSupport bagCodePartnerSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BagCodePartnerVo>> findByPage(@RequestBody BagCodePartnerPageReq pageReq){
		PageResult<List<BagCodePartnerVo>> result = new PageResult<List<BagCodePartnerVo>>();
		try {
			result.setDatas(bagCodePartnerSupport.findByPage(pageReq));
			result.setPage(pageReq);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("包包码合作社分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "detail")
	public Result<BagCodePartnerVo> detail(@RequestParam("id") Integer id){
		Result<BagCodePartnerVo> result = new Result<BagCodePartnerVo>();
		try {
			result.setDatas(bagCodePartnerSupport.detail(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("包包码合作社详情查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody BagCodePartnerVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperatorId(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			result.setDatas(bagCodePartnerSupport.add(vo));
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
			result.setMsg("包包码合作社新增异常");
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(HttpServletRequest request, @RequestBody BagCodePartnerVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperatorId(sysUser.getId());
			vo.setOperatorName(sysUser.getName());
			result.setDatas(bagCodePartnerSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("包包码合作社更新异常");
		}
		return result;
	}
	
}
