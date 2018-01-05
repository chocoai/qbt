package com.qbt.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.persistent.entity.UserActivityOrder;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.service.UserActivityOrderService;
import com.qbt.service.UserWeixinService;
import com.qbt.web.pojo.ticket.UserActivityOrderAddReqVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UserActivityOrderSupport;
import com.qbt.web.support.UserActivityPackageSupport;

@Controller
@RequestMapping("/proxyTicketPackage")
public class ProxyTicketPacakgeController {

	@Resource
	private UserActivityOrderSupport userActivityOrderSupport;

	@Resource
	private UserActivityPackageSupport userActivityPackageSupport;

	@Resource
	private LoginSupport loginSupport;

	@Resource
	UserActivityOrderService userActivityOrderService;

	@Resource
	private UserWeixinService userWeixinService;

	@RequestMapping(value = "order", method = RequestMethod.POST)
	public Result<Integer> proxyOrder(HttpServletRequest request, @RequestBody UserActivityOrderAddReqVo vo) {

		// help this openid to create a order
		String openId = vo.getOpenid();
		UserWeixin userWeixin = userWeixinService.findByOpenId(openId);

		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);

			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));

			if (sysUser != null) {
				vo.setOperatorId(sysUser.getId());
				vo.setOperatorName(sysUser.getName());

				vo.setProxyUserId(sysUser.getId());
				vo.setProxyUser(sysUser.getName());
			}

			vo.setUserId(userWeixin.getId());

			result.setDatas(userActivityOrderSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "代下单券包异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;

	}

	@RequestMapping(value = "confirmPaid", method = RequestMethod.POST)
	public Result<Integer> confirmPaid(HttpServletRequest request, @RequestBody UserActivityOrderAddReqVo vo) {
		Result<Integer> result = new Result<Integer>();

		int orderId = vo.getId();

		try {
			userActivityOrderSupport.createPackageAfterPaid(orderId);
			result.setDatas(orderId);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "确认支付失败异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}

		return result;
	}

	@RequestMapping(value = "pay", method = RequestMethod.POST)
	public Result<Integer> pay(HttpServletRequest request, @RequestBody UserActivityOrderAddReqVo vo) {
		return null;
	}

	@RequestMapping(value = "activate", method = RequestMethod.POST)
	public Result<Integer> activate(HttpServletRequest request, @RequestBody UserActivityOrderAddReqVo vo) {
		return null;
	}

	@RequestMapping(value = "pushPayment", method = RequestMethod.POST)
	public Result<Integer> pushPayment(HttpServletRequest request, @RequestBody UserActivityOrderAddReqVo vo) {
		
		Result<Integer> result = new Result<Integer>();
		int orderId = vo.getId();
		
		// get openid form order
		String paymentUrl = vo.getPaymentUrl();
		UserActivityOrder order = userActivityOrderService.findById(orderId);

		// check order info
		if (order == null || paymentUrl == null || order.getPayStatus() == 1) {
			LogCvt.error("订单不存在或者已经支付链接为空");
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单不存在或者已经支付链接为空");
			return result;
		}

		// ticketPackagePay/order
		order.setPaymentUrl(paymentUrl);

		// send wechat message
		try {
			userActivityOrderSupport.pushTicketPackagePaymentNotify(order);
		} catch (Exception e) {
			String errMsg = "发送支付通知异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}

		return result;
	}

	@RequestMapping(value = "list", method = RequestMethod.POST)
	public Result<Integer> list(HttpServletRequest request, @RequestBody UserActivityOrderAddReqVo vo) {
		return null;
	}
}
