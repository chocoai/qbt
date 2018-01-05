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
import com.qbt.persistent.entity.SysResource;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.sysResource.AdminSysResourceVO;
import com.qbt.web.pojo.sysResource.SysResourcePageReqVo;
import com.qbt.web.support.AdminSysResourceSupport;
import com.qbt.web.support.LoginSupport;

/**
 * 资源模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/adminSysResource")
public class SysResourceController {
	
	@Resource
	private AdminSysResourceSupport adminSysResourceSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	/**
	 * 分页查询
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<AdminSysResourceVO>> findByPage(@RequestBody SysResourcePageReqVo reqVo){
		PageResult<List<AdminSysResourceVO>> result = new PageResult<List<AdminSysResourceVO>>();
		try {
			result.setDatas(adminSysResourceSupport.findByPage(reqVo));
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
	 * 获取资源列表
	 * @return
	 */
	@RequestMapping("list")
	public Result<List<AdminSysResourceVO>> list(){
		Result<List<AdminSysResourceVO>> result = new Result<List<AdminSysResourceVO>>();
		List<AdminSysResourceVO> sysResourceList = adminSysResourceSupport.list();
		result.setDatas(sysResourceList);
		return result;
	}
	
	/**
	 * 添加资源
	 * @param sysRecource
	 * @return
	 */
	@RequestMapping(value="add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody AdminSysResourceVO vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			adminSysResourceSupport.insert(vo);
			result.setDatas("添加资源成功！");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加资源异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 删除资源
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public Result<String> delete(Integer id){
		Result<String> result = new Result<String>();
		if(id!=0){
			adminSysResourceSupport.delete(id);
			result.setDatas("删除资源成功！");
		}else{
			result.setDatas("id为空。");
		}
		return result;
	}
	
	/**
	 *更新资源
	 * @param sysRecource
	 * ok
	 * @return
	 */
	@RequestMapping(value="update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody SysResource sysRecource){
		Result<String> result = new Result<String>();
		if(sysRecource!=null){
			adminSysResourceSupport.update(sysRecource);
			result.setDatas("更新资源成功！");
		}else{
			result.setDatas("资源不合法。");
		}
		return result;
	}
	
	/**
	 * 根据用户id获取资源列表
	 * @param request
	 * @param platId
	 * @return
	 */
	@RequestMapping("listByUserId")
	public Result<List<AdminSysResourceVO>> listByUserId(HttpServletRequest request,Integer platId){
		Result<List<AdminSysResourceVO>> result = new Result<List<AdminSysResourceVO>>();
		String token = request.getHeader("token");
		SysUser sysUser = loginSupport.tokenCheck(token);
		List<AdminSysResourceVO> sysResourceList = adminSysResourceSupport.listByUserId(sysUser.getId(), platId);
		result.setDatas(sysResourceList);
		return result;
	}
	
}

