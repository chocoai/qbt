package com.qbt.web.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.util.StringUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserAssistant;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.sms.api.service.SmsCodeService;
import com.qbt.web.pojo.assistant.Assistant;
import com.qbt.web.pojo.assistant.AssistantDelivery;
import com.qbt.web.pojo.assistant.AssistantLoginResp;
import com.qbt.web.pojo.assistant.AssistantOrder;
import com.qbt.web.pojo.order.BigOrderDetail;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.order.OrderPageRequest;
import com.qbt.web.support.AssistantService;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.ShoppingCartOrderSupport;

/**
 * 用户登录接口
 * @author share
 *
 */
@Controller
@RequestMapping("/assistant")
public class AssistantController {

	@Resource
	private LoginSupport loginSupport;
	
	@Resource
	private SmsCodeService smsCodeService;
	
	@Resource
	private AssistantService assistantService;
	
	@Resource
	private OrderSupport orderSupport;
	
	@Resource
	private ShoppingCartOrderSupport shoppingCartOrderSupport;
	
	/**
	 *  球包助理查询
	 * @param code
	 * @param lon
	 * @param lat
	 * @return
	 */
	@RequestMapping("/query_assistant")
	public Result<AssistantLoginResp> assistantLogin(HttpServletRequest request){
		Result<AssistantLoginResp> result=new Result<AssistantLoginResp>();
		try {
			String token = request.getHeader("token");
			String openid = null;
			if(!StringUtil.isEmpty(token) && !"null".equalsIgnoreCase(token)){
				LogCvt.info("assistant token:"+token);
				openid = loginSupport.checkToken(token);
				if(openid == null){
					LogCvt.info("微信授权过期，请重新授权...");
					result.setCode(ErrorCodeEnum.ERROR_AUTH.getCode());
					result.setMsg("微信授权过期，请重新授权");
					return result;
				}
			}
			
			//查询助理表
			UserWeixin userWeixin	= loginSupport.findByOpenId(openid);
			UserAssistant user  	= loginSupport.checkUserIsAssistant(userWeixin.getId());
			AssistantLoginResp resp = new AssistantLoginResp();
			if(user == null){
				resp.setStatus(0);
				resp.setMemo("无记录");
			}else{
				resp.setStatus(user.getStatus());
				resp.setMemo(user.getMemo());
				resp.setApplyId(user.getApplyId());
				resp.setApplyName(user.getApplyName());
				int applyType = user.getApplyType();
				if(applyType == 1 || applyType == 2){
					applyType = 1;
				}else if(applyType == 3){
					applyType = 3;
				}else if(applyType == 4){
					applyType = 5;
				}else if(applyType == 5){
					applyType = 2;
				}
				resp.setApplyType(applyType);
			}
			result.setDatas(resp);
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
	  * @Title: apply
	  * @Description: 球包助理申请
	  * @author: win10 2016年8月18日
	  * @modify: win10 2016年8月18日
	  * @param request
	  * @param map
	  * @return
	 */
	@RequestMapping("/apply")
	public Result<HashMap<String,String>> apply(HttpServletRequest request,@RequestBody Assistant assistant){
		Result<HashMap<String,String>> result = new Result<HashMap<String,String>>();
		try {
			VlidationUtil.validate(assistant);  
			if(!StringUtil.isMobile(assistant.getMobile())){
				 result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
		         result.setMsg("手机号格式不正确");
		         return result;
			}
			String mobile	= assistant.getMobile();
			String smsCode	= assistant.getSmsCode();
			String smsToken	= assistant.getSmsToken();
			smsCodeService.checkSmsCode(mobile, smsCode, smsToken);
			
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			assistantService.insertOrUpdateAssistant(userWeixin, assistant);
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
	
	/**
	 *  球包助理订单列表查询 运输中|已签收
	  * @Title: order
	  * @Description: TODO
	  * @author: share 2016年8月20日
	  * @modify: share 2016年8月20日
	  * @param request
	  * @param assistant
	  * @return
	 */
	@RequestMapping("/order")
	public Result<List<OrderDetail>> order(HttpServletRequest request,int applyType,int applyId,int type){
		Result<List<OrderDetail>> result = new Result<List<OrderDetail>>();
		try {
			AssistantOrder assistant = new AssistantOrder();	
			assistant.setApplyId(applyId);
			assistant.setApplyType(applyType);
			assistant.setType(type);
			result.setDatas(orderSupport.queryAssistantOrder(assistant));
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
	 *  订单列表 全部和待支付
	  * @Title: cartList
	  * @Description: TODO
	  * @author: share 2016年10月20日
	  * @modify: share 2016年10月20日
	  * @param request
	  * @param order
	  * @return
	 */
	@RequestMapping("/cart_list")
	public PageResult<List<BigOrderDetail>> cartList(HttpServletRequest request,@RequestBody OrderPageRequest order){
		PageResult<List<BigOrderDetail>> result = new PageResult<List<BigOrderDetail>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			order.setUserId(userWeixin.getId());
			result.setDatas(shoppingCartOrderSupport.queryPartnerOrder(order));
			result.setPage(order);
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
	 *  合作社订单列表查询
	  * @Title: partnerOrder
	  * @Description: TODO
	  * @author: share 2016年10月9日
	  * @modify: share 2016年10月9日
	  * @param request
	  * @param applyType
	  * @param applyId
	  * @param type
	  * @return
	 */
	@RequestMapping("/partner_order")
	public PageResult<List<OrderDetail>> partnerOrder(HttpServletRequest request,@RequestBody OrderPageRequest order){
		PageResult<List<OrderDetail>> result = new PageResult<List<OrderDetail>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			order.setUserId(userWeixin.getId());
			result.setDatas(orderSupport.queryPartnerOrder(order));
			result.setPage(order);
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
	 *  
	  * @Title: info
	  * @Description: TODO
	  * @author: share 2016年8月20日
	  * @modify: share 2016年8月20日
	  * @param request
	  * @param orderId
	  * @return
	 */
	@RequestMapping("/order_info")
	public Result<OrderDetail> info(HttpServletRequest request,String orderId,int applyId,int applyType){
		Result<OrderDetail> result = new Result<OrderDetail>();
		try {
			if(orderId == null){
				result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
				result.setMsg("订单号不能为空");
				return result;
			}
			// 获取订单详情
			result.setDatas(orderSupport.orderDetail(applyId,applyType,orderId));
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	/**
	 *  球包助理收包
	  * @Title: info
	  * @Description: TODO
	  * @author: share 2016年8月20日
	  * @modify: share 2016年8月20日
	  * @param request
	  * @param orderId
	  * @param applyId
	  * @param applyType
	  * @param applyType
	  * @return
	 */
	@RequestMapping("/delivery")
	public Result<OrderDetail> delivery(HttpServletRequest request,@RequestBody AssistantDelivery ssistantDelivery){
		Result<OrderDetail> result = new Result<OrderDetail>();
		try{
			VlidationUtil.validate(ssistantDelivery); 
			
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			// 获取订单详情
			if(ssistantDelivery.getType() == 1){
				orderSupport.receiver(userWeixin,ssistantDelivery);
			}else if(ssistantDelivery.getType() == 2){
				orderSupport.delivery(userWeixin,ssistantDelivery);
			}
			
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
	
	
}
