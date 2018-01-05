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
import com.qbt.persistent.entity.SysRole;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.entity.SysUserRole;
import com.qbt.web.pojo.sysRole.AdminSysRoleVO;
import com.qbt.web.pojo.sysRole.SysRolePageReqVo;
import com.qbt.web.support.AdminSysRoleSupport;
import com.qbt.web.support.LoginSupport;

/**
 * 角色模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/adminSysRole")
public class SysRoleController {
	
	@Resource
	private AdminSysRoleSupport adminSysRoleSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	/**
	 * 分页查询
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<AdminSysRoleVO>> findByPage(@RequestBody SysRolePageReqVo reqVo){
		PageResult<List<AdminSysRoleVO>> result = new PageResult<List<AdminSysRoleVO>>();
		try {
			result.setDatas(adminSysRoleSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "资源列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	@RequestMapping("list")
	public Result<List<AdminSysRoleVO>> list(){
		Result<List<AdminSysRoleVO>> result = new Result<List<AdminSysRoleVO>>();
		List<AdminSysRoleVO> adminSysRoleVOList = adminSysRoleSupport.list();
		result.setDatas(adminSysRoleVOList);
		return result;
	}
	
	/**
	 * 添加角色
	 * @param sysRole
	 * @return
	 */
	@RequestMapping(value="add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody AdminSysRoleVO vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			adminSysRoleSupport.insert(vo);
			result.setDatas("添加角色成功。");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加角色异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public Result<String> delete(Integer id){
		Result<String> result = new Result<String>();
		if(id!=0){
			adminSysRoleSupport.delete(id);
			result.setDatas("删除角色成功。");	
		}else{
			result.setDatas("id为空。");	
		}
		return result;
	}
	
	/**
	 * 更新角色
	 * @param sysRole
	 * @return
	 */
	@RequestMapping(value="update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody AdminSysRoleVO vo){
		Result<String> result = new Result<String>();
		if(vo!=null){
			adminSysRoleSupport.update(vo);
			result.setDatas("更新角色成功。");
		}else{
			result.setDatas("对象为空。");
		}
		return result;
	}
	
	/**
	 * 根据后台用户id查SysUserRole列表
	 * @param userId
	 * @return
	 */
	@RequestMapping("sysUserRolelistByUserId")
	public Result<List<SysUserRole>> sysUserRolelistByUserId(Integer userId){
		Result<List<SysUserRole>> result = new Result<List<SysUserRole>>();
		List<SysUserRole> sysUserRoleList = adminSysRoleSupport.sysUserRolelistByUserId(userId);
		result.setDatas(sysUserRoleList);
		return result;
	}
	
	/**
	 * 更具用户id获取角色列表
	 * @param request
	 * @param platId
	 * @return
	 */
	@RequestMapping("sysRolelistByUserId")
	public Result<List<SysRole>> sysRolelistByUserId(HttpServletRequest request,Integer platId){
		Result<List<SysRole>> result = new Result<List<SysRole>>();
		SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
		List<SysRole> sysRoleList = adminSysRoleSupport.sysRolelistByUserId(platId,sysUser.getId());
		result.setDatas(sysRoleList);
		return result;
	}
	
	
}
