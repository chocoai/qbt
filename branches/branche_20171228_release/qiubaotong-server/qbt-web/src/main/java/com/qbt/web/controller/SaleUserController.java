/**
 * Project Name:qbt-web
 * File Name:SaleUserController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年2月7日下午4:22:46
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
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.util.StringUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.saleUser.SaleUserApplyVo;
import com.qbt.web.pojo.saleUser.SaleUserOrderRequest;
import com.qbt.web.pojo.saleUser.SaleUserOrderVo;
import com.qbt.web.pojo.saleUser.SaleUserSubcripbeRequest;
import com.qbt.web.pojo.saleUser.SaleUserSubcripbeVo;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.SaleUserSupport;

/**
 * ClassName:SaleUserController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月7日 下午4:22:46
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/saleUser")
public class SaleUserController {
	
	@Resource
	private LoginSupport loginSupport;
	@Resource
	private OrderSupport orderSupport;
	@Resource
	private SaleUserSupport saleUserSupport;
	
	@RequestMapping("/apply")
	public Result<Boolean> apply(HttpServletRequest request, @RequestBody SaleUserApplyVo applyVo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(applyVo);  
			if(!StringUtil.isMobile(applyVo.getMobile())){
				 result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
		         result.setMsg("手机号格式不正确");
		         return result;
			}
			
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(saleUserSupport.apply(userWeixin, applyVo));
		}catch (ValidationException e) {  
           result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
           result.setMsg(e.getMessage());
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
	
	@RequestMapping("/codeCompany")
	public Result<String> codeCompany(@RequestParam("salesmanCode")String salesmanCode){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(saleUserSupport.codeCompany(salesmanCode));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/orderList")
	public Result<List<SaleUserOrderVo>> orderList(HttpServletRequest request, @RequestBody SaleUserOrderRequest req){
		Result<List<SaleUserOrderVo>> result = new Result<List<SaleUserOrderVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(saleUserSupport.orderList(userWeixin, req));
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
	
	@RequestMapping("/subcripbeList")
	public Result<List<SaleUserSubcripbeVo>> subcripbeList(HttpServletRequest request, @RequestBody SaleUserSubcripbeRequest req){
		Result<List<SaleUserSubcripbeVo>> result = new Result<List<SaleUserSubcripbeVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(saleUserSupport.subcripbeList(userWeixin, req));
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
	
	/**
	 *  销售人员详情
	  * @Title: info
	  * @Description: TODO
	  * @author: share 2017年2月14日
	  * @modify: share 2017年2月14日
	  * @param request
	  * @return
	 */
	@RequestMapping("/info")
	public Result<SaleUserVo> info(HttpServletRequest request){
		Result<SaleUserVo> result = new Result<SaleUserVo>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(saleUserSupport.detail(userWeixin.getId()));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	

	/**
	 *  销售人员最近一笔订单查询
	  * @Title: lastOrder
	  * @Description: TODO
	  * @author: share 2016年9月23日
	  * @modify: share 2016年9月23日
	  * @param orderId
	  * @return
	 */
	@RequestMapping(value="/lastOrder")
	public Result<OrderDetail> lastOrder(HttpServletRequest request,Integer userId){
		Result<OrderDetail> result = new Result<OrderDetail>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(orderSupport.lastOrder(userId,userWeixin.getId()));
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
