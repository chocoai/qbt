package com.qbt.web.controller;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
import com.qbt.persistent.entity.SysPlat;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.sysRole.AdminSysRoleVO;
import com.qbt.web.pojo.sysuser.AdminSysUserVO;
import com.qbt.web.pojo.sysuser.AdminUserPageReqVo;
import com.qbt.web.pojo.sysuser.UserPassVo;
import com.qbt.web.support.AdminSysUserSupport;
import com.qbt.web.support.LoginSupport;

/**
 * 后台用户模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/adminUser")
public class SysUserController {
	
	@Value("${globalSalt}")
    public String globalSalt;
	@Resource
	private AdminSysUserSupport adminSysUserSupport;
	@Resource
	private LoginSupport loginSupport;
	
	/**
	 * 根据用户id获取角色
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findRoleListById")
	public Result<List<AdminSysRoleVO>> findRoleListById(Integer id){
		Result<List<AdminSysRoleVO>> result = new Result<List<AdminSysRoleVO>>();
		List<AdminSysRoleVO> sysRoleList = null;
		try {
			sysRoleList = adminSysUserSupport.findRoleListById(id);
		} catch (Exception e) {
			String errMsg = "用户角色查询异常 ";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(sysRoleList);
		return result;
	}
	
	/**
	 * 根据用户id获取平台
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findPlatListById")
	public Result<List<SysPlat>> findPlatListById(Integer id){
		Result<List<SysPlat>> result = new Result<List<SysPlat>>();
		List<SysPlat> sysPlatList = null;
		try {
			sysPlatList = adminSysUserSupport.findPlatListById(id);
		} catch (Exception e) {
			String errMsg = "用户平台查询异常 ";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(sysPlatList);
		return result;
	}
	
	/**
	 * 获取用户详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findUserDitail")
	public Result<AdminSysUserVO> findUserDitail(Integer id){
		Result<AdminSysUserVO> result = new Result<AdminSysUserVO>();
		AdminSysUserVO adminSysUSerVO = adminSysUserSupport.findById(id);
		result.setDatas(adminSysUSerVO);
		return result;
	}
	
	/**
	 * 获取列表
	 * @return
	 */
	@RequestMapping("list")
	public Result<List<AdminSysUserVO>> list(){
		Result<List<AdminSysUserVO>> result = new Result<List<AdminSysUserVO>>();
		List<AdminSysUserVO> adminSysUserVOList = adminSysUserSupport.list();
		result.setDatas(adminSysUserVOList);
		return result;
	}
	
	/**
	 * 添加方法
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value="add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody AdminSysUserVO vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			adminSysUserSupport.insert(vo);
			result.setDatas("添加后台用户成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加后台用户异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 修改用户密码
	 * @param adminSysUserVO
	 * @return
	 */
	@RequestMapping(value="updatePwd", method = RequestMethod.POST)
	public Result<Boolean> updatePwd(@RequestBody UserPassVo vo,HttpServletRequest request){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(vo);
			String token = request.getHeader("token");
			SysUser sysUser = loginSupport.tokenCheck(token);
			result.setDatas(adminSysUserSupport.updatePasswod(vo, sysUser));
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		}catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "更新用户密码异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 重置密码
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="resetPwdByUserId")
	public Result<Boolean> resetPwdByUserId(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try{
			result.setDatas(adminSysUserSupport.resetPwdByUserId(id));
		}catch (Exception e) {
			String errMsg = "重置密码异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 删除数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public Result<String> delete(Integer id){
		Result<String> result = new Result<String>();
		if(id!=null){
			adminSysUserSupport.delete(id);
			result.setDatas("删除用户成功！");
		}
		return result;
	}
	
	/**
	 * 更新用户数据
	 * @param sysUser
	 * @return
	 */
	@RequestMapping(value="update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody AdminSysUserVO adminSysUserVO){
		Result<String> result = new Result<String>();
		if(adminSysUserVO!=null){
			adminSysUserSupport.update(adminSysUserVO);
			result.setDatas("更新用户成功！");
		}
		return result;
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param adminSysUserVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<AdminSysUserVO>> findByPage(@RequestBody AdminUserPageReqVo reqVo){
		PageResult<List<AdminSysUserVO>> result = new PageResult<List<AdminSysUserVO>>();
		try {
			result.setDatas(adminSysUserSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "用户分页查询异常 ";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 根据角色id获取用户列表
	 * @param roleId
	 * @return
	 */
	@RequestMapping("listUserByRoleId")
	public Result<List<AdminSysUserVO>> listUserByRoleId(int roleId){
		Result<List<AdminSysUserVO>> result = new Result<List<AdminSysUserVO>>();
		List<AdminSysUserVO> adminSysUserVOList = adminSysUserSupport.listUserByRoleId(roleId);
		result.setDatas(adminSysUserVOList);
		return result;
	}
}
