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
import com.qbt.common.result.Result;
import com.qbt.web.pojo.emailMessage.EmailMessagePageReqVo;
import com.qbt.web.pojo.emailMessage.EmailMessageVo;
import com.qbt.web.support.EmailMessageSupport;

@Controller
@RequestMapping("emailMessage")
public class EmailMessageController {

	@Resource
	private EmailMessageSupport emailMessageSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<EmailMessageVo>> findByPage(@RequestBody EmailMessagePageReqVo reqVo){
		PageResult<List<EmailMessageVo>> result = new PageResult<List<EmailMessageVo>>();
		try {
			result.setDatas(emailMessageSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "邮箱信息分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "resend")
	public Result<Boolean> resend(String uuid){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(emailMessageSupport.resend(uuid));;
		} catch (Exception e) {
			String errMsg = "邮件重发异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
