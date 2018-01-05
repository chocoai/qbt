package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.Bill;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.bill.BillPageReqVo;
import com.qbt.web.pojo.bill.BillVo;
import com.qbt.web.support.BillSupport;
import com.qbt.web.support.LoginSupport;

@Controller
@RequestMapping("/bill")
public class BillController {
	
	@Resource
	private BillSupport billSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BillVo>> findByPage(@RequestBody BillPageReqVo vo){
		PageResult<List<BillVo>> result = new  PageResult<List<BillVo>>();
		try{
			result.setDatas(billSupport.findByPage(vo));
			result.setPage(vo);
		}catch (Exception e) {
			String errMsg = "发票分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<BillVo> findById(Integer id){
		Result<BillVo> result = new  Result<BillVo>();
		try{
			result.setDatas(billSupport.findById(id));
		}catch (Exception e) {
			String errMsg = "发票分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "openBill")
	public Result<Boolean> openBill(HttpServletRequest request,Integer id,String number){
		Result<Boolean> result = new  Result<Boolean>();
		try{
			if(StringUtils.isEmpty(number)){
				result.setMsg("发票编码不能为空！");
				result.setDatas(false);
			}else{
				SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
				billSupport.updateNumberById(id, number, sysUser.getId(),sysUser.getName());
				result.setDatas(true);
			}
		}catch (Exception e) {
			String errMsg = "开票异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	@RequestMapping(value = "updateRemark")
	public Result<Boolean> updateRemark(HttpServletRequest request,@RequestBody BillVo vo){
		Result<Boolean> result = new  Result<Boolean>();
		try{
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vo.setOperater(sysUser.getId());
			vo.setOperaterName(sysUser.getName());
			billSupport.updateRemark(vo);
			result.setDatas(true);
		}catch (Exception e) {
			String errMsg = "发票分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
