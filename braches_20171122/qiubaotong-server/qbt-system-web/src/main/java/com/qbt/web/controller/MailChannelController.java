package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.mailChannel.MailChannelVo;
import com.qbt.web.support.MailChannelSupport;

@Controller
@RequestMapping("/mailChannel")
public class MailChannelController {
	
	@Resource
	private MailChannelSupport support;
	
	@RequestMapping(value = "findAll")
	public Result<List<MailChannelVo>> findAll(){
		Result<List<MailChannelVo>> result = new Result<List<MailChannelVo>>();
		try{
			result.setDatas(support.findAll());
			
		}catch(Exception e){
			String errMsg = "查询物流渠道异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;

	}
}
