package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.reminder.ReminderVo;
import com.qbt.web.support.ReminderSupport;

@Controller
@RequestMapping("/reminder")
public class ReminderController {
	
	@Resource
	private ReminderSupport reminderSupport;
	
	@RequestMapping("detail")
	public Result<ReminderVo> detail(Integer id){
		Result<ReminderVo> result = new Result<ReminderVo>();
		try {
			result.setDatas(reminderSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "查询提示详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 *  列表查询
	  * @return
	 */
	@RequestMapping("/list")
	public Result<List<ReminderVo>> list(){
		Result<List<ReminderVo>> result = new Result<List<ReminderVo>>();
		try {
			result.setDatas(reminderSupport.list());
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
