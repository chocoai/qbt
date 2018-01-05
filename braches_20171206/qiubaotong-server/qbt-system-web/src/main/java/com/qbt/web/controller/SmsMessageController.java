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
import com.qbt.web.pojo.smsMessage.SmsMessagePageReqVo;
import com.qbt.web.pojo.smsMessage.SmsMessageVo;
import com.qbt.web.support.SmsMessageSupport;

@Controller
@RequestMapping("smsMessage")
public class SmsMessageController {
	
	@Resource
	private SmsMessageSupport smsMessageSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<SmsMessageVo>> findByPage(@RequestBody SmsMessagePageReqVo reqVo){
		PageResult<List<SmsMessageVo>> result = new PageResult<List<SmsMessageVo>>();
		try {
			result.setDatas(smsMessageSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "短信消息查看分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

}
