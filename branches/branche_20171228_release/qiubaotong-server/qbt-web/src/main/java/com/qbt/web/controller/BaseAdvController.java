package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.baseAdv.BaseAdvVo;
import com.qbt.web.support.BaseAdvSupport;

@Controller
@RequestMapping("/baseAdv")
public class BaseAdvController {

	@Resource
	private BaseAdvSupport baseAdvSupport;
	
	@RequestMapping("/list")
	public Result<List<BaseAdvVo>> list(String type,String position){
		Result<List<BaseAdvVo>> result = new Result<List<BaseAdvVo>>();
		try {
			result.setDatas(baseAdvSupport.list(type,position));
		}catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
}
