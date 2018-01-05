package com.qbt.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderCountVo;
import com.qbt.web.pojo.order.OrderDetailV2;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderV2Support;
import com.qbt.web.support.SaleUserSupport;

/**
 *  订单接口 版本V2  UI改版
  * @ClassName: OrderV2Controller
  * @Description: TODO
  * @author share 2017年04月11日
  * @modify share 2016年04月11日
 */
@Controller
@RequestMapping("/order/v2/")
public class OrderV2Controller {

	@Resource
	private OrderV2Support orderV2Support;
	@Resource
	private LoginSupport loginSupport;
	@Resource
	private SaleUserSupport saleUserSupport;
	
	/**
	 *  订单下单
	  * @Title: confirmOrder
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param orderInfo
	  * @return
	 */
	@RequestMapping("/confirm_order")
	public Result<String> confirmOrder(HttpServletRequest request, @RequestBody OrderConfirm orderInfo){
		Result<String> result = new Result<String>();
		try {  
            VlidationUtil.validate(orderInfo); 
            if(orderInfo.getCreate_method() == 2){
            	// 代理下单人员ID
          		String openid = String.valueOf(request.getAttribute("openid"));
 	    		UserWeixin proxyUserWeixin = loginSupport.findByOpenId(openid);
            	
            	//如果代下单人没有扫销售的二维码，orderInfo.getUserId()=0 代下单人为自己
 	    		UserWeixin userWeixin  = null;
            	if(orderInfo.getUserId()==0){
            		userWeixin = proxyUserWeixin;
            	}else{
            		userWeixin = loginSupport.findById(orderInfo.getUserId());
              		if(userWeixin == null){
              			throw new ValidationException("待下单用户不存在");
              		}
            	}
          		
            	orderInfo.setUserName(userWeixin.getName());
          		orderInfo.setOpenid(userWeixin.getOpenid());
          		orderInfo.setProxySelfUserId(userWeixin.getId());
          		
 	    		orderInfo.setProxyUserId(proxyUserWeixin.getId());
 	    		orderInfo.setUserId(proxyUserWeixin.getId());
 	    		orderInfo.setProxyOpenid(proxyUserWeixin.getOpenid());
 	    		SaleUserVo userVo = saleUserSupport.detail(proxyUserWeixin.getId());
          		if(userVo == null || userVo.getStatus() == 2){
          			throw new ValidationException("无效销售员，不能下单");
          		}
            }else{
	        	String openid = String.valueOf(request.getAttribute("openid"));
	      		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
	      		orderInfo.setUserId(userWeixin.getId());
	      		orderInfo.setProxySelfUserId(userWeixin.getId());
	      		orderInfo.setUserName(userWeixin.getName());
	      		orderInfo.setOpenid(openid);
            }
            
    		/**
    		 * 下单流程及业务校验
    		 */
    		result.setDatas(orderV2Support.orderCreate(orderInfo));
    		
        } catch (ValidationException e) {  
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg(e.getMessage());
            return result;
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
	 *  待支付大订单支付详情
	  * @Title: payInfo
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param request
	  * @param orderId 大订单号
	  * @return
	 */
	@RequestMapping("/pay_info")
	public Result<OrderDetailV2> payInfo(HttpServletRequest request,String orderId){
		Result<OrderDetailV2> result = new Result<OrderDetailV2>();
		try {  
			if(orderId == null){
				result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
		        result.setMsg("订单号不能为空");
		        return result;
			}
			// 获取订单详情
			result.setDatas(orderV2Support.unpayOrderDetail(orderId));
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
	
	@RequestMapping("/orderCount")
	public Result<OrderCountVo> orderCount(HttpServletRequest request){
		Result<OrderCountVo> result = new Result<OrderCountVo>();
		try {  
			String openid = String.valueOf(request.getAttribute("openid"));
      		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(orderV2Support.orderCountByStatus(userWeixin));
		 } catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		 }
		
		 return result;
	}
	
	@RequestMapping("/lastOrder")
	public Result<OrderDetailV2> lastOrder(HttpServletRequest request){
		Result<OrderDetailV2> result = new Result<OrderDetailV2>();
		try {  
			String openid = String.valueOf(request.getAttribute("openid"));
      		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(orderV2Support.userLastOrder(userWeixin.getId()));
		 } catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		 }
		 return result;
	}
	
	@RequestMapping("/isWinner")
	public Result<Boolean> isWinner(Integer orderId){
		Result<Boolean> result = new Result<Boolean>();
		try{
			if(orderId<=0){
				result.setDatas(false);
				result.setMsg("orderId不能小于等于0");
			}
			result.setDatas(orderV2Support.isWinner(orderId));
		}catch(Exception e){
			String errMsg = "解锁优惠价失败";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 
	 * back:(返程).
	 *
	 * @author huangyihao
	 * 2017年10月11日 上午10:26:18
	 * @param orderId 
	 * @return
	 *
	 */
	@RequestMapping("/back")
	public Result<OrderDetailV2> back(String orderId){
		Result<OrderDetailV2> result = new Result<OrderDetailV2>();
		try {  
			result.setDatas(orderV2Support.backOrder(orderId));
		 } catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		 }
		 return result;
	}
	
}
