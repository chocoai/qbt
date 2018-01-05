/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupUserController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年8月2日上午10:54:34
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
import com.qbt.web.pojo.common.ImportRespVo;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserDeleteReq;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserImportReq;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserPageReq;
import com.qbt.web.pojo.orgGroupUser.OrgGroupUserVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrgGroupUserSupport;

/**
 * ClassName:OrgGroupUserController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月2日 上午10:54:34
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/orgGroupUser")
public class OrgGroupUserController {
	
	@Resource
	private OrgGroupUserSupport orgGroupUserSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrgGroupUserVo>> findByPage(@RequestBody OrgGroupUserPageReq reqVo){
		PageResult<List<OrgGroupUserVo>> result = new PageResult<List<OrgGroupUserVo>>();
		try {
			result.setDatas(orgGroupUserSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群用户分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody OrgGroupUserVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orgGroupUserSupport.add(vo, sysUser));
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
			result.setMsg("机构群用户新增异常");
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(HttpServletRequest request, @RequestBody OrgGroupUserVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orgGroupUserSupport.update(vo, sysUser));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群用户更新异常");
		}
		return result;
	}
	
	@RequestMapping(value = "updateStatus", method = RequestMethod.POST)
	public Result<Boolean> updateStatus(HttpServletRequest request, @RequestBody OrgGroupUserVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orgGroupUserSupport.update(vo, sysUser));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群用户启用/禁用异常");
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(@RequestBody OrgGroupUserDeleteReq deleteReq){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(orgGroupUserSupport.delete(deleteReq.getIds()));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群用户删除异常");
		}
		return result;
	}
	
	@RequestMapping(value = "detail")
	public Result<OrgGroupUserVo> detail(@RequestParam("id") Integer id){
		Result<OrgGroupUserVo> result = new Result<OrgGroupUserVo>();
		try {
			result.setDatas(orgGroupUserSupport.detail(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群用户详情查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "importFile")
	public Result<ImportRespVo> importFile(HttpServletRequest request, @RequestBody OrgGroupUserImportReq importReq){
		Result<ImportRespVo> result = new Result<ImportRespVo>();
		try {
			VlidationUtil.validate(importReq);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orgGroupUserSupport.importFile(importReq, sysUser));
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
			result.setMsg("机构群用户删除异常");
		}
		return result;
	}
	
}
