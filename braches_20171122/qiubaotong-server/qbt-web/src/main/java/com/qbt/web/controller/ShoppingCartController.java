package com.qbt.web.controller;

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
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.saleUser.SaleUserVo;
import com.qbt.web.pojo.shoppingCart.CartRequest;
import com.qbt.web.pojo.shoppingCart.ShoppingCart;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.SaleUserSupport;
import com.qbt.web.support.ShoppingCartSupport;

/**
 *  购物车清单
  * @ClassName: ShoppingCartController
  * @Description: TODO
  * @author share 2016年10月15日
  * @modify share 2016年10月15日
 */
@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {

	@Resource
	private LoginSupport loginSupport;
	
	@Resource
	private SaleUserSupport saleUserSupport;
	
	@Resource
	private ShoppingCartSupport shoppingCartSupport;
	
	/**
	 *  订单下单
	  * @Title: confirmOrder
	  * @Description: TODO
	  * @author: share 2016年8月13日
	  * @modify: share 2016年8月13日
	  * @param orderInfo
	  * @return
	 */
	@RequestMapping("/add")
	public Result<String> addShoppingCart(HttpServletRequest request,@RequestBody OrderConfirm orderInfo){
		Result<String> result = new Result<String>();
		try {  
            VlidationUtil.validate(orderInfo); 
            if(orderInfo.getCreate_method() == 2){
          		UserWeixin userWeixin = loginSupport.findById(orderInfo.getUserId());
          		if(userWeixin == null){
          			throw new ValidationException("待下单用户不存在");
          		}
          		
          		orderInfo.setUserId(userWeixin.getId());
          		orderInfo.setUserName(userWeixin.getName());
          		orderInfo.setOpenid(userWeixin.getOpenid());
          		// 代理下单人员ID
          		String openid = String.valueOf(request.getAttribute("openid"));
 	    		UserWeixin proxyUserWeixin = loginSupport.findByOpenId(openid);
 	    		orderInfo.setProxyUserId(proxyUserWeixin.getId());
 	    		SaleUserVo userVo = saleUserSupport.detail(proxyUserWeixin.getId());
          		if(userVo == null || userVo.getStatus() == 2){
          			throw new ValidationException("无效销售员，不能下单");
          		}
          		orderInfo.setProxyOpenid(proxyUserWeixin.getOpenid());
            }else{
	            String openid = String.valueOf(request.getAttribute("openid"));
	    		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
	    		orderInfo.setUserId(userWeixin.getId());
	    		orderInfo.setUserName(userWeixin.getName());
	    		orderInfo.setOpenid(openid);
            }
    		/**
    		 * 添加购物车
    		 */
    		shoppingCartSupport.addShoppingCart(orderInfo);
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
	 *  清单拉取
	  * @Title: confirmOrder
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param request
	  * @return
	 */
	@RequestMapping("/pull")
	public Result<List<ShoppingCart>> pull(HttpServletRequest request){
		Result<List<ShoppingCart>> result = new Result<List<ShoppingCart>>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
    		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
    		/**
    		 * 添加购物车
    		 */
    		result.setDatas(shoppingCartSupport.getShoppingCart(userWeixin.getId()));
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
	 *  购物车修改
	  * @Title: update
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param request
	  * @return
	 */
	@RequestMapping("/update")
	public Result<String> update(HttpServletRequest request,@RequestBody CartRequest req){
		Result<String> result = new Result<String>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
    		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
    		req.setUserId(userWeixin.getId());
    		shoppingCartSupport.update(req);
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
	 *  删除清单购物车内容
	  * @Title: delete
	  * @Description: TODO
	  * @author: share 2016年10月17日
	  * @modify: share 2016年10月17日
	  * @param request
	  * @param req
	  * @return
	 */
	@RequestMapping("/delete")
	public Result<String> delete(HttpServletRequest request,@RequestBody CartRequest req){
		Result<String> result = new Result<String>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
    		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
    		req.setUserId(userWeixin.getId());
    		shoppingCartSupport.delete(req);
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
	 *  购物数量统计
	  * @Title: count
	  * @Description: TODO
	  * @author: share 2016年10月21日
	  * @modify: share 2016年10月21日
	  * @param request
	  * @return
	 */
	@RequestMapping("/count")
	public Result<Integer> count(HttpServletRequest request){
		Result<Integer> result = new Result<Integer>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
    		UserWeixin userWeixin = loginSupport.findByOpenId(openid);
    		result.setDatas(shoppingCartSupport.count(userWeixin.getId()));
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
