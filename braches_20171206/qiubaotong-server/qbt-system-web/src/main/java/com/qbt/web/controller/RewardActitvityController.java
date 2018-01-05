package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.activity.ActivityVo;
import com.qbt.web.pojo.rewardActitvity.RewardActitvityPageReqVo;
import com.qbt.web.pojo.rewardActitvity.RewardActitvityVo;
import com.qbt.web.pojo.rewardActitvity.WinnerListPageReqVo;
import com.qbt.web.pojo.rewardActitvity.WinnerListVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.RewardActitvitySupport;

@Controller
@RequestMapping("/rewardActitvity")
public class RewardActitvityController {
	
	@Resource
	private RewardActitvitySupport support;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "insert",method = RequestMethod.POST)
	public Result<Boolean> insert(@RequestBody RewardActitvityVo vo,HttpServletRequest request){
		Result<Boolean> result = new Result<Boolean>();
		try{
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperator(sysUser.getId());
		    if(support.insert(vo)==false){
		    	result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
		    	result.setMsg("该段时间已经有此类活动！");
		    }
		}catch(Exception e){
			String errMsg = "添加中奖活动失败";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "updateById",method = RequestMethod.POST)
	public Result<Boolean> updateById(@RequestBody RewardActitvityVo vo,HttpServletRequest request){
		Result<Boolean> result = new Result<Boolean>();
		try{
			VlidationUtil.validate(vo);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperator(sysUser.getId());
			 if(support.updateById(vo)==false){
			    	result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			    	result.setMsg("该段时间已经有此类活动！");
			 }
		}catch(Exception e){
			String errMsg = e.getMessage();
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "deleteById",method = RequestMethod.POST)
	public Result<Boolean> deleteById(@RequestBody RewardActitvityVo vo,HttpServletRequest request)	{
		Result<Boolean> result = new Result<Boolean>();
		try{
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperator(sysUser.getId());
			support.deleteById(vo);
		}catch(Exception e){
			String errMsg = "删除奖励活动失败";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
		
	}
	
	@RequestMapping(value = "findByPage",method = RequestMethod.POST)
	public PageResult<List<RewardActitvityVo>> findByPage(@RequestBody RewardActitvityPageReqVo vo)	{
		PageResult<List<RewardActitvityVo>> result = new PageResult<List<RewardActitvityVo>>();
		try{
			result.setDatas(support.list(vo));
			result.setPage(vo);
		}catch (Exception e) {
			String errMsg = "查询奖励活动异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		
		return result;
		
	}
	
	@RequestMapping(value = "findById",method = RequestMethod.GET)
	public Result<RewardActitvityVo> findById(Integer id){
		Result<RewardActitvityVo> result = new Result<RewardActitvityVo>();
		try{
			result.setDatas(support.findById(id));
		}catch(Exception e){
			String errMsg = "查询奖励活动异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findCurrentCoupon")
	public Result<List<ActivityVo>> findCurrentCoupon(Integer type){
		Result<List<ActivityVo>> result = new Result<List<ActivityVo>>();
	    try{
	    	result.setDatas(support.findCurrentCoupon(type));
	    }catch (Exception e) {
	    	String errMsg = "查询当前奖励类型异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "deblockingCoupon")
	public Result<Boolean> deblockingCoupon(Integer orderId)	{
		Result<Boolean> result = new Result<Boolean>();
		try{
			orderId=1;
			support.deblockingCoupon(orderId);
		}catch(Exception e){
			String errMsg = "解锁优惠价失败";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "isWinner")
	public Result<Boolean> isWinner(Integer orderId)	{
		Result<Boolean> result = new Result<Boolean>();
		try{
			result.setDatas(support.isWinner(orderId));
		}catch(Exception e){
			String errMsg = "解锁优惠价失败";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findWinnerListByPage")
    public PageResult<List<WinnerListVo>>	findWinnerListByPage(@RequestBody WinnerListPageReqVo vo){
    	PageResult<List<WinnerListVo>> result = new PageResult<List<WinnerListVo>>();
    	try{
    		result.setDatas(support.findWinnerListByPage(vo));
    		result.setPage(vo);
    	}catch(Exception e){
			String errMsg = "查询中奖名单失败";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
    	return result;
    }
	
}
