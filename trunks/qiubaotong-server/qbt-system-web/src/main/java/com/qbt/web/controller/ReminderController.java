package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.Reminder;
import com.qbt.web.pojo.reminder.ReminderAddReqVo;
import com.qbt.web.pojo.reminder.ReminderPageReqVo;
import com.qbt.web.pojo.reminder.ReminderVo;
import com.qbt.web.support.ReminderSupport;

@Controller
@RequestMapping("/reminder")
public class ReminderController {
	
	@Resource
	private ReminderSupport reminderSupport;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody ReminderAddReqVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(reminderSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增提示异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<ReminderVo>> findByPage(@RequestBody ReminderPageReqVo reqVo){
		PageResult<List<ReminderVo>> result = new PageResult<List<ReminderVo>>();
		try {
			result.setDatas(reminderSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "提示分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
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
	
	@RequestMapping("update")
	public Result<Boolean> update(@RequestBody ReminderVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(reminderSupport.update(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "提示更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("updateAll")
	public Result<List<ReminderVo>> updateAll(@RequestBody List<ReminderVo> volist){
		Result<List<ReminderVo>> result = new Result<List<ReminderVo>>();
		try {
			
			for(ReminderVo vo: volist) {
				if(vo.getId()>0) {
					reminderSupport.update(vo);	
				}else {
					ReminderAddReqVo reminder = BeanUtil.a2b(vo, ReminderAddReqVo.class);
					reminderSupport.add(reminder);
				}				
			}
			
			result.setDatas(reminderSupport.list());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "提示更新";
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
