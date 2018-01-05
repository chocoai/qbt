package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.sysLogs.SysLogsPageReqVo;
import com.qbt.web.pojo.sysLogs.SysLogsVo;
import com.qbt.web.support.SysLogsSupport;
/**
 * 系统日志模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("sysLogs")
public class SysLogsController {

	@Resource
	private SysLogsSupport sysLogsSupport;
	
	/**
	 * 分页获取列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<SysLogsVo>> findByPage(@RequestBody SysLogsPageReqVo reqVo){
		PageResult<List<SysLogsVo>> result = new PageResult<List<SysLogsVo>>();
		try {
			result.setDatas(sysLogsSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "系统日志分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 添加日志
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody SysLogsVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			sysLogsSupport.insert(vo);
			result.setDatas("添加日志成功。");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "添加日志异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
	}
	
	/**
	 * 删除日志
	 * @param id
	 * @return
	 */
	@RequestMapping(value="delete")
	public Result<String> delete(Integer id){
		Result<String> result = new Result<String>();
		if(id!=0){
			sysLogsSupport.delete(id);
			result.setDatas("删除日志成功。");	
		}else{
			result.setDatas("id为空。");	
		}
		return result;
	}
	
	/**
	 * 更新日志
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody SysLogsVo vo){
		Result<String> result = new Result<String>();
		if(vo!=null){
			sysLogsSupport.updateById(vo);
			result.setDatas("更新日志成功。");
		}else{
			result.setDatas("对象为空。");
		}
		return result;
	}
	
}
