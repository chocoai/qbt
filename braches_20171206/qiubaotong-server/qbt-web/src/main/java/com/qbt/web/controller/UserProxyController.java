/**
 * Project Name:qbt-web
 * File Name:UserProxyController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年2月27日下午2:47:07
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.user.Address;
import com.qbt.web.pojo.user.AddressDto;
import com.qbt.web.pojo.userProxy.UserProxyVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UserProxyAddressSupport;
import com.qbt.web.support.UserProxySupport;

/**
 * ClassName:UserProxyController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月27日 下午2:47:07
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/userProxy")
public class UserProxyController {
	
	@Resource
	private UserProxySupport userProxySupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@Resource
	private UserProxyAddressSupport userProxyAddressSupport;
	
	@RequestMapping("/list")
	public Result<List<UserProxyVo>> proxyList(HttpServletRequest request, @RequestParam("keyword")String keyword){
		Result<List<UserProxyVo>> result = new Result<List<UserProxyVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userProxySupport.list(userWeixin, keyword));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/detail")
	public Result<UserProxyVo> proxyDetail(HttpServletRequest request, @RequestParam("userId")Integer userId){
		Result<UserProxyVo> result = new Result<UserProxyVo>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userProxySupport.detail(userWeixin, userId));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Result<Integer> proxySave(HttpServletRequest request, @RequestBody UserProxyVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userProxySupport.save(userWeixin, vo));
		} catch (WechatException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}  catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/address/list")
	public Result<List<Address>> addressList(HttpServletRequest request, @RequestParam(value="userId", required=false)Integer userId, 
			@RequestParam(value="labelType", required=false,defaultValue="3")int labelType){
		Result<List<Address>> result = new Result<List<Address>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userProxyAddressSupport.list(userWeixin, userId, labelType));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/address/add")
	public Result<Integer> addressAdd(HttpServletRequest request, @RequestBody Address address){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(address);
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userProxyAddressSupport.add(userWeixin, address));
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
	
	@RequestMapping("/address/update")
	public Result<Boolean> addressUpdate(HttpServletRequest request, @RequestBody Address address){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(address);
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userProxyAddressSupport.update(userWeixin, address));
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
	 * 代下单常用地址删除
	 * @param openid
	 * @return
	 */
	@RequestMapping(value="/address/delete",method=RequestMethod.GET)
	public Result<String> addressDelete(Integer id){
		Result<String> result = new Result<String>();
		boolean flag = userProxyAddressSupport.delete(id);
		if(!flag){
			result.setError(ErrorCodeEnum.ERROR);
		}
		return result;
	}
	
	/**
	 * 代下单常用地址置顶
	 * @param openid
	 * @return
	 */
	@RequestMapping("/address/updateUpdateTime")
	public Result<Boolean> addressUpdateUpdateTime(HttpServletRequest request,@RequestBody AddressDto address){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(address);
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			address.setUserId(userWeixin.getId());
			result.setDatas(userProxyAddressSupport.updateUpdateTime(address));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
}
