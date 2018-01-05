package com.qbt.web.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Paging;
import com.qbt.common.result.Result;
import com.qbt.common.util.StringUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.order.BigOrderDetail;
import com.qbt.web.pojo.order.CommentRequest;
import com.qbt.web.pojo.order.HistoryOrderAddressVo;
import com.qbt.web.pojo.order.OrderCommentInfo;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.order.OrderDetail;
import com.qbt.web.pojo.order.OrderDetailV2;
import com.qbt.web.pojo.order.OrderPageRequest;
import com.qbt.web.pojo.order.ShoppingCartOrderDetail;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.pojo.sf.WayBill;
import com.qbt.web.pojo.shoppingCart.CartRequest;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderSupport;
import com.qbt.web.support.OrderWaybillSupport;
import com.qbt.web.support.SaleUserSupport;
import com.qbt.web.support.ShoppingCartOrderSupport;

/**
 *  订单接口
  * @ClassName: OrderController
  * @Description: TODO
  * @author share 2016年8月11日
  * @modify share 2016年8月11日
 */
@Controller
@RequestMapping("/order")
public class OrderController {

	@Resource
	private OrderSupport orderSupport;
	@Resource
	private ShoppingCartOrderSupport shoppingCartOrderSupport;
	@Resource
	private LoginSupport loginSupport;
	@Resource
	private OrderWaybillSupport orderWaybillSupport;
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
	public Result<String> confirmOrder(HttpServletRequest request,@RequestBody OrderConfirm orderInfo){
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
            }else if(orderInfo.getCreate_method() == 3){
          		UserWeixin userWeixin = loginSupport.findById(orderInfo.getUserId());
          		if(userWeixin == null){
          			throw new ValidationException("待下单用户不存在");
          		}
          		orderInfo.setUserId(userWeixin.getId());
          		orderInfo.setUserName(userWeixin.getName());
          		orderInfo.setOpenid(userWeixin.getOpenid());
          		orderInfo.setProxySelfUserId(userWeixin.getId());
          		// 代理下单人员ID
          		String openid = String.valueOf(request.getAttribute("openid"));
 	    		UserWeixin proxyUserWeixin = loginSupport.findByOpenId(openid);
 	    		orderInfo.setProxyUserId(proxyUserWeixin.getId());
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
    		result.setDatas(orderSupport.orderCreate(orderInfo));
    		
        } catch (ValidationException e) {  
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg(e.getMessage());
            return result;
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
	 *  购物车下单
	  * @Title: confirmOrder
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param request
	  * @param orderInfo
	  * @return
	 */
	@RequestMapping("/shoping_cart_confirm_order")
	public Result<String> shoppingCartConfirmOrder(HttpServletRequest request,@RequestBody CartRequest cartRequest){
		Result<String> result = new Result<String>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
    		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
    		cartRequest.setUserId(userWeixin.getId());
    		cartRequest.setUserName(userWeixin.getName());
    		cartRequest.setOpenid(openid);
    		if(cartRequest.getIds() == null || cartRequest.getIds().length == 0){
    			result.setCode(ErrorCodeEnum.ERROR.getCode());
    			result.setMsg("未选择清单数据");
    			return result;
    		}
    		/**
    		 * 下单流程及业务校验
    		 */
    		result.setDatas(shoppingCartOrderSupport.orderCreate(cartRequest));
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
	public Result<ShoppingCartOrderDetail> payInfo(HttpServletRequest request,String orderId){
		Result<ShoppingCartOrderDetail> result = new Result<ShoppingCartOrderDetail>();
		try {  
			if(orderId == null){
				result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
		        result.setMsg("订单号不能为空");
		        return result;
			}
			// 获取订单详情
			result.setDatas(shoppingCartOrderSupport.unpayOrderDetail(orderId));
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
	 *  子订单订单详情
	  * @Title: confirmOrder
	  * @Description: TODO
	  * @author: share 2016年8月14日
	  * @modify: share 2016年8月14日
	  * @param request
	  * @param orderInfo
	  * @return
	 */
	@RequestMapping("/info")
	public Result<OrderDetail> info(HttpServletRequest request,String orderId){
		Result<OrderDetail> result = new Result<OrderDetail>();
		try {  
			if(orderId == null){
				result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
		        result.setMsg("订单号不能为空");
		        return result;
			}
	        
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			// 获取订单详情
			result.setDatas(orderSupport.orderDetail(userWeixin.getId(), orderId));
		 } catch (WechatException e) {
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
	  * @Title: info
	  * @Description: TODO
	  * @author: share 2016年8月14日
	  * @modify: share 2016年8月14日
	  * @param request
	  * @param orderId
	  * @return
	 */
	@RequestMapping("/cart_list")
	public PageResult<List<BigOrderDetail>> cartList(HttpServletRequest request,@RequestBody OrderPageRequest order){
		PageResult<List<BigOrderDetail>> result = new PageResult<List<BigOrderDetail>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			order.setUserId(userWeixin.getId());
			result.setDatas(shoppingCartOrderSupport.orderList(order));
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
	 *  订单列表 运输中|已签收
	  * @Title: info
	  * @Description: TODO
	  * @author: share 2016年8月14日
	  * @modify: share 2016年8月14日
	  * @param request
	  * @param orderId
	  * @return
	 */
	@RequestMapping("/list")
	public PageResult<List<OrderDetail>> list(HttpServletRequest request,@RequestBody OrderPageRequest order){
		PageResult<List<OrderDetail>> result = new PageResult<List<OrderDetail>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			order.setUserId(userWeixin.getId());
			result.setDatas(orderSupport.orderList(order));
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
	 *  大订单查子订单列表接口
	  * @Title: list
	  * @Description: TODO
	  * @author: share 2016年10月20日
	  * @modify: share 2016年10月20日
	  * @param request
	  * @param orderId
	  * @return
	 */
	@RequestMapping("/sub_list")
	public Result<List<OrderDetail>> subList(HttpServletRequest request,String orderId){
		Result<List<OrderDetail>> result = new Result<List<OrderDetail>>();
		try {
//			String openid = String.valueOf(request.getAttribute("openid"));
//			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(orderSupport.orderSubList(orderId));
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
	 *  订单删除
	  * @Title: delete
	  * @Description: TODO
	  * @author: share 2016年8月16日
	  * @modify: share 2016年8月16日
	  * @param request
	  * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Result<String> delete(HttpServletRequest request,@RequestBody Map<String,String> body){
		Result<String> result = new Result<String>();
		try{
			String orderId = body.get("orderId");
			if(StringUtil.isEmpty(orderId)){
				result.setError(ErrorCodeEnum.ERROR);
				return result;
			}
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			orderSupport.delete(userWeixin.getId(),orderId);
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
	 *  订单取消
	  * @Title: cancel
	  * @Description: TODO
	  * @author: share 2016年8月16日
	  * @modify: share 2016年8月16日
	  * @param request
	  * @param body
	  * @return
	 */
	@RequestMapping(value="/cancel",method=RequestMethod.POST)
	public Result<String> cancel(HttpServletRequest request,@RequestBody Map<String,String> body){
		Result<String> result = new Result<String>();
		try{
			String orderId = body.get("orderId");
			if(StringUtil.isEmpty(orderId)){
				result.setError(ErrorCodeEnum.ERROR);
				return result;
			}
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			orderSupport.cancel(userWeixin.getId(),orderId);
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
	 * 订单取消, 取消未支付订单 
	 * orderId是大订单号码
	 * 
	 * @Title: cancel
	 * @Description: TODO
	 * @author: share 2016年8月16日
	 * @modify: share 2016年8月16日
	 * @param request
	 * @param body
	 * @return
	 */
	@RequestMapping(value="/cancel_no_paid",method=RequestMethod.POST)
	public Result<String> cancel_no_paid(HttpServletRequest request,@RequestBody Map<String,String> body){
		Result<String> result = new Result<String>();
		try{
			String orderId = body.get("orderId");
			if(StringUtil.isEmpty(orderId)){
				result.setError(ErrorCodeEnum.ERROR);
				return result;
			}
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			
			List<OrderDetail> subOrders = orderSupport.orderSubList(orderId);
			
			for(OrderDetail detail: subOrders) {
				orderSupport.cancel(userWeixin.getId(), detail.getNumber());	
			}
			
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
	 * 物流订单查询
	  * @Title: orderWayBill
	  * @Description: TODO
	  * @author: share 2016年8月18日
	  * @modify: share 2016年8月18日
	  * @param orderId
	  * @return
	 */
	@RequestMapping(value="/way_bill")
	public Result<List<WayBill>> orderWayBill(String orderId){
		Result<List<WayBill>> result = new Result<List<WayBill>>();
		try{
			result.setDatas(orderWaybillSupport.findByWayBill(orderId));
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
	 * 订单追踪
	 * @param request
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value="/track_order")
	public Result<List<OrderDetail>> trackOrder(HttpServletRequest request, @RequestParam("keyword")String keyword){
		Result<List<OrderDetail>> result = new Result<List<OrderDetail>>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(orderSupport.trackOrder(userWeixin.getId(), keyword));
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
	
	@RequestMapping(value="/add_comment", method = RequestMethod.POST)
	public Result<String> addComment(HttpServletRequest request, @RequestBody CommentRequest req){
		Result<String> result = new Result<String>();
		try{
			VlidationUtil.validate(req);
			
			String openid = String.valueOf(request.getAttribute("openid"));
	    	UserWeixin userWeixin = loginSupport.findByOpenId(openid);
	    	orderSupport.addComment(userWeixin, req);
		} catch (ValidationException e) {  
            result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
            result.setMsg(e.getMessage());
            return result;
        } catch (WechatException e) {  
            result.setCode(e.getCode());
            result.setMsg(e.getMessage());
            return result;
        } catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("添加订单评论异常");
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping(value="/comment_list", method = RequestMethod.POST)
	public PageResult<List<OrderCommentInfo>> commentList(@RequestBody Paging page){
		PageResult<List<OrderCommentInfo>> result = new PageResult<List<OrderCommentInfo>>();
		try {
			result.setDatas(orderSupport.commentList(page));
			result.setPage(page);
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("订单评论查询异常");
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping(value="/my_comment")
	public Result<OrderCommentInfo> myComment(@RequestParam("orderNumber")String orderNumber){
		Result<OrderCommentInfo> result = new Result<OrderCommentInfo>();
		try {
			result.setDatas(orderSupport.findByOrderNumber(orderNumber));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("订单评论查询异常");
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping(value="/confirm")
	public Result<Boolean> confirm(Integer id){
		Result<Boolean> result= new Result<Boolean>();
		try{
			orderSupport.confirm(id);
			result.setDatas(true);
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("签收确认异常");
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	@RequestMapping(value="/findForBill")
	public Result<List<OrderDetailV2>> findForBill(HttpServletRequest request){
		Result<List<OrderDetailV2>> result= new Result<List<OrderDetailV2>>();
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(orderSupport.findForBill(userWeixin.getId()));
		}catch(Exception e){
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("可开发票订单查询异常");
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping(value="/findAddressHistoryById")
	public  Result<List<HistoryOrderAddressVo>> findAddressHistoryById(HttpServletRequest request)
	{
		Result<List<HistoryOrderAddressVo>> result = new Result<List<HistoryOrderAddressVo>>();
		
		try{
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(orderSupport.findAddressHistory(userWeixin.getId()));
			//result.setDatas(orderSupport.findAddressHistory(170));
		}catch(Exception e){
		
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg("查找历史订单地址异常");
			LogCvt.error(e.getMessage(),e);
		}
		
		return result;
	}
}
