package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.web.pojo.assistant.AdminUserAssistantVO;
import com.qbt.web.pojo.assistant.UserAssistantPageReqVo;
import com.qbt.web.support.AdminUserAssistantSupport;

/**
 * 球包助理模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/adminUserAssistant")
public class UserAssistantController {
	
	@Resource
	private AdminUserAssistantSupport adminUserAssistantSupport;
	
	/**
	 * 分页查询列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<AdminUserAssistantVO>> findByPage(@RequestBody UserAssistantPageReqVo reqVo){
		PageResult<List<AdminUserAssistantVO>> result = new PageResult<List<AdminUserAssistantVO>>();
		try {
			result.setDatas(adminUserAssistantSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "球场客服查询分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
