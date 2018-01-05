/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年8月1日下午6:51:44
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
import com.qbt.web.pojo.orgGroup.OrgGroupDetailVo;
import com.qbt.web.pojo.orgGroup.OrgGroupPageReq;
import com.qbt.web.pojo.orgGroup.OrgGroupVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrgGroupSupport;

/**
 * ClassName:OrgGroupController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午6:51:44
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/orgGroup")
public class OrgGroupController {
	
	@Resource
	private OrgGroupSupport orgGroupSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrgGroupVo>> findByPage(@RequestBody OrgGroupPageReq reqVo){
		PageResult<List<OrgGroupVo>> result = new PageResult<List<OrgGroupVo>>();
		try {
			result.setDatas(orgGroupSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "list")
	public Result<List<OrgGroupVo>> list(){
		Result<List<OrgGroupVo>> result = new Result<List<OrgGroupVo>>();
		try {
			result.setDatas(orgGroupSupport.list());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(HttpServletRequest request, @RequestBody OrgGroupDetailVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orgGroupSupport.add(vo, sysUser));
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
			result.setMsg("机构群新增异常");
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(HttpServletRequest request, @RequestBody OrgGroupDetailVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orgGroupSupport.update(vo, sysUser));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群更新异常");
		}
		return result;
	}
	
	@RequestMapping(value = "updateStatus", method = RequestMethod.POST)
	public Result<Boolean> updateStatus(HttpServletRequest request, @RequestBody OrgGroupDetailVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orgGroupSupport.update(vo, sysUser));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群启用/禁用异常");
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(@RequestParam("id") Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(orgGroupSupport.delete(id));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群删除异常");
		}
		return result;
	}
	
	@RequestMapping(value = "detail")
	public Result<OrgGroupDetailVo> detail(@RequestParam("id") Integer id){
		Result<OrgGroupDetailVo> result = new Result<OrgGroupDetailVo>();
		try {
			result.setDatas(orgGroupSupport.detail(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("机构群详情查询异常");
		}
		return result;
	}
	
}
