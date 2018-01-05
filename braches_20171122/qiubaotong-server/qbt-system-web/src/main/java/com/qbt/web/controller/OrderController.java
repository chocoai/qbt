package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BaseException;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.util.Checker;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderDetailVo;
import com.qbt.web.pojo.order.OrderOperateLogVo;
import com.qbt.web.pojo.order.OrderPageReqVo;
import com.qbt.web.pojo.order.OrderVo;
import com.qbt.web.pojo.order.OrderWaybillVo;
import com.qbt.web.pojo.refund.OrderCancelRefund;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderSupport;

@Controller
@RequestMapping("order")
public class OrderController {
	
	@Resource
	private OrderSupport orderSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderVo>> findByPage(@RequestBody OrderPageReqVo reqVo){
		PageResult<List<OrderVo>> result = new PageResult<List<OrderVo>>();
		try {
			result.setDatas(orderSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "订单分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<OrderDetailVo> detail(int id){
		Result<OrderDetailVo> result = new Result<OrderDetailVo>();
		try {
			result.setDatas(orderSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "订单详情查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("operateLog")
	public Result<List<OrderOperateLogVo>> operateLog(Integer orderId){
		Result<List<OrderOperateLogVo>> result = new Result<List<OrderOperateLogVo>>();
		try {
			result.setDatas(orderSupport.findOperateLogByOrderId(orderId));
		} catch (Exception e) {
			String errMsg = "订单操作日志查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("waybill")
	public Result<List<OrderWaybillVo>> waybill(Integer orderId){
		Result<List<OrderWaybillVo>> result = new Result<List<OrderWaybillVo>>();
		try {
			result.setDatas(orderSupport.findWaybillByOrderId(orderId));
		} catch (Exception e) {
			String errMsg = "订单物流查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 *  订单修改
	  * @Title: update
	  * @Description: TODO
	  * @author: share 2016年8月26日
	  * @modify: share 2016年8月26日
	  * @param orderId
	  * @return
	 */
	@RequestMapping("update")
	public Result<String> update(HttpServletRequest request,@RequestBody OrderDetailVo orderDetail){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(orderDetail);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			orderSupport.update(orderDetail,sysUser);
		} catch(ValidationException e){
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("修改订单接口异常");
		}
		return result;
	}
	
	/**
	 *  重新下单推送
	  * @Title: orderPush
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param request
	  * @param orderDetail
	  * @return
	 */
	@RequestMapping("order_push")
	public Result<String> orderPush(HttpServletRequest request,int id){
		Result<String> result = new Result<String>();
		try {
			orderSupport.orderPush(id);
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("修改订单接口异常");
		}
		return result;
	}
	
	/**
	 *  订单取消
	  * @Title: orderCancel
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param request
	  * @param id
	  * @return
	 */
	@RequestMapping("order_cancel")
	public Result<String> orderCancel(HttpServletRequest request,@RequestBody OrderCancelRefund orderDetail){
		Result<String> result = new Result<String>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			orderSupport.orderCancel(orderDetail,sysUser);
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("修改订单接口异常");
		}
		return result;
	}
	
	/**
	 *  订单取消计算退款金额
	  * @Title: orderCancelCalcRefund
	  * @Description: TODO
	  * @author: share 2016年11月3日
	  * @modify: share 2016年11月3日
	  * @param request
	  * @param orderDetail
	  * @return
	 */
	@RequestMapping("order_cancel_calc_refund")
	public Result<OrderCancelRefund> orderCancelCalcRefund(HttpServletRequest request,@RequestBody OrderDetailVo orderDetail){
		Result<OrderCancelRefund> result = new Result<OrderCancelRefund>();
		try {
			result.setDatas(orderSupport.orderCancelCalcRefund(orderDetail));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("修改订单接口异常");
		}
		return result;
	}
	
	/**
	 *  确认客服已收件
	  * @Title: orderConfirmSfRecive
	  * @Description: TODO
	  * @author: share 2016年8月27日
	  * @modify: share 2016年8月27日
	  * @param request
	  * @param orderDetail
	  * @return
	 */
	@RequestMapping("sf_recive")
	public Result<String> orderConfirmSfRecive(HttpServletRequest request,@RequestBody OrderDetailVo orderDetail){
		Result<String> result = new Result<String>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			orderSupport.orderConfirmSfRecive(orderDetail,sysUser);
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("修改订单接口异常");
		}
		return result;
	}
	
	/**
	 *  boss 下单功能
	  * @Title: orderConfirmSfRecive
	  * @Description: TODO
	  * @author: share 2016年10月25日
	  * @modify: share 2016年10月25日
	  * @param request
	  * @param orderDetail
	  * @return
	 */
	@RequestMapping("/create")
	public Result<String> create(HttpServletRequest request,@RequestBody OrderConfirm orderConfirm){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(orderConfirm);
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			if(sysUser.getWxUserId() == null || sysUser.getWxOpenId() == null){
				result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
				result.setMsg("下单人未绑定微信用户，无法下单");
				return result;
			}
			orderConfirm.setUserId(sysUser.getWxUserId());
			orderConfirm.setOpenid(sysUser.getWxOpenId());
			orderSupport.createOrder(orderConfirm);
		} catch(ValidationException e){
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (BaseException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("boss下单接口异常");
		}
		return result;
	}
	
	@RequestMapping("/receivable")
	public Result<Boolean> receivable(HttpServletRequest request, Integer id, Integer receivableType){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orderSupport.receivable(id, receivableType, sysUser));
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单收款异常");
		}
		return result;
	}
	
	@RequestMapping("/updateMailChannelById")
	public Result<Boolean> updateMailChannelById(Integer id,Integer mailChannel,String mailNumber,HttpServletRequest request){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			orderSupport.updateMailChannelById(sysUser,id,mailChannel,mailNumber);
		}catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("修改订单运营渠道失败");
		}
		return result;
	}
	
	@RequestMapping("/updateWeixinPayCodeById")
	public Result<Boolean> updateWeixinPayCodeById(HttpServletRequest request,Integer id, String weixinPayCode){
		Result<Boolean> result = new Result<Boolean>();
		try {
			if(Checker.isNotEmpty(weixinPayCode)){
				SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
				orderSupport.updateWeixinPayCodeById(id, weixinPayCode, sysUser.getId()+"");
			}
		}catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("修改微信支付码失败");
		}
		return result;
	}
	
	
	
}
