package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.BillAddress;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.bill.BillAddressVo;
import com.qbt.web.pojo.bill.BillVo;
import com.qbt.web.pojo.order.OrderDetailV2;
import com.qbt.web.support.BillSupport;
import com.qbt.web.support.LoginSupport;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Resource
	private BillSupport billSupport;
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping("applayForBill")
	public Result<Boolean> applayForBill(HttpServletRequest request, @RequestBody BillVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(billSupport.applyForBill(vo,userWeixin));
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	@RequestMapping("findBillAddress")
	public Result<List<BillAddress>> findBillAddress(HttpServletRequest request,int orgType){
		Result<List<BillAddress>> result = new Result<List<BillAddress>>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(billSupport.findBillAddress(userWeixin.getId(),orgType));
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("insertBillAddress")
	public Result<Boolean> findBillAddress(HttpServletRequest request,@RequestBody BillAddressVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
	    	vo.setUserId(userWeixin.getId());
	    	result.setDatas(billSupport.insertBillAddress(vo));
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	@RequestMapping("updateBillAddress")
	public Result<Boolean> updateBillAddress(@RequestBody BillAddressVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try{
			billSupport.updateBillAddress(vo);
			result.setDatas(true);
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(e.getMessage());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("deleteBillAddress")
	public Result<Boolean> deleteBillAddress(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try{
			billSupport.deleteBillAddress(id);
			result.setDatas(true);
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("findBill")
	public Result<List<BillVo>> findBill(HttpServletRequest request){
		Result<List<BillVo>> result = new Result<List<BillVo>>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(billSupport.findBill(userWeixin.getId()));
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("findOrderByIds")
	public Result<List<OrderDetailV2>> findOrderByIds(String orderIds){
		Result<List<OrderDetailV2>> result = new Result<List<OrderDetailV2>>();
		try{
			String[] idArray=orderIds.split(",");
			int[] ids = new int[idArray.length];
			for(int i = 0;i<idArray.length;i++){
				ids[i]= Integer.parseInt(idArray[i]);
			}
			result.setDatas(billSupport.findOrderByIds(ids));
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	@RequestMapping("findLastUseAddressByUserId")
	public Result<BillAddressVo> findLastUseAddressByUserId(HttpServletRequest request){
		Result<BillAddressVo> result = new Result<BillAddressVo>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
	    	result.setDatas(billSupport.findLastUseAddressByUserId(userWeixin.getId()));
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
}
