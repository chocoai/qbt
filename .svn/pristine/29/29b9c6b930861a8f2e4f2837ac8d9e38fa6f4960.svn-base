/**
 * Project Name:qbt-system-web
 * File Name:SaleUserController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年2月8日上午11:49:43
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderSettleAbleInfo;
import com.qbt.web.pojo.saleOrderInfo.SaleOrderSettleReq;
import com.qbt.web.pojo.saleSubcripbe.SaleSubcripbeSettleAbleInfo;
import com.qbt.web.pojo.saleSubcripbe.SaleSubcripbeSettleReq;
import com.qbt.web.pojo.saleUser.SaleUserPageReqVo;
import com.qbt.web.pojo.saleUser.SaleUserUpdateBatch;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.SaleUserSupport;

/**
 * ClassName:SaleUserController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月8日 上午11:49:43
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/saleUser")
public class SaleUserController {
	
	@Resource
	private SaleUserSupport saleUserSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping("/findByPage")
	public PageResult<List<SaleUserVo>> findByPage(@RequestBody SaleUserPageReqVo reqVo){
		PageResult<List<SaleUserVo>> result = new PageResult<List<SaleUserVo>>();
		try {
			result.setDatas(saleUserSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员分页查询异常");
		}
		return result;
	}
	
	@RequestMapping("/detail")
	public Result<SaleUserVo> detail(@RequestParam("id")Integer id){
		Result<SaleUserVo> result = new Result<SaleUserVo>();
		try {
			result.setDatas(saleUserSupport.detail(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员详情查询异常");
		}
		return result;
	}
	
	@RequestMapping("/update")
	public Result<Boolean> update(@RequestBody SaleUserVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(saleUserSupport.update(vo));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员更新异常");
		}
		return result;
	}
	
	@RequestMapping("/updateStatus")
	public Result<Boolean> updateStatus(@RequestBody SaleUserVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(saleUserSupport.updateStatus(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员更新异常");
		}
		return result;
	}
	
	@RequestMapping("/audit")
	public Result<Boolean> audit(HttpServletRequest request, @RequestBody SaleUserVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(saleUserSupport.audit(vo, sysUser));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员审核异常");
		}
		return result;
	}
	
	@RequestMapping("/updateBatch")
	public Result<Boolean> updateBatch(@RequestBody SaleUserUpdateBatch updateBatch){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(saleUserSupport.updateBatch(updateBatch));;
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员批量更新异常");
		}
		return result;
	}
	
	@RequestMapping("/order/settleInfo")
	public Result<SaleOrderSettleAbleInfo> saleOrderSettleInfo(@RequestBody SaleOrderSettleReq req){
		Result<SaleOrderSettleAbleInfo> result = new Result<SaleOrderSettleAbleInfo>();
		try {
			VlidationUtil.validate(req);
			result.setDatas(saleUserSupport.saleOrderSettleInfo(req));;
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员待订单结算信息查询异常");
		}
		return result;
	}
	
	@RequestMapping("/order/settle")
	public Result<Boolean> settleSaleOrder(HttpServletRequest request, @RequestBody SaleOrderSettleReq req){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(req);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(saleUserSupport.settleSaleOrder(req, sysUser));;
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员待订单结算异常");
		}
		return result;
	}
	
	@RequestMapping("/subcripbe/settleInfo")
	public Result<SaleSubcripbeSettleAbleInfo> saleSubcripbeSettleInfo(@RequestBody SaleSubcripbeSettleReq req){
		Result<SaleSubcripbeSettleAbleInfo> result = new Result<SaleSubcripbeSettleAbleInfo>();
		try {
			VlidationUtil.validate(req);
			result.setDatas(saleUserSupport.saleSubcripbeSettleInfo(req));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员新拉关注结算信息查询异常");
		}
		return result;
	}
	
	@RequestMapping("/subcripbe/settle")
	public Result<Boolean> settleSubcripbe(HttpServletRequest request, @RequestBody SaleSubcripbeSettleReq req){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(req);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(saleUserSupport.settleSubcripbe(req, sysUser));;
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("销售人员新拉关注结算异常");
		}
		return result;
	}
	
}
