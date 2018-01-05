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
import com.qbt.common.result.Result;
import com.qbt.common.util.StringUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.user.Address;
import com.qbt.web.pojo.user.AddressDto;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UserAddressSupport;

/**
 * 用户地址Api
 * @author share
 *
 */
@Controller
@RequestMapping("/userAddress")
public class UserAddressController {

	@Resource
	private UserAddressSupport userAddressSupport;
	@Resource
	private LoginSupport loginSupport;
	
	/**
	 * 查询列表
	 * @param labelType 1-家 2-公司 3-其他
	 * @return
	 */
	@RequestMapping("/list")
	public Result<List<Address>> list(HttpServletRequest request,
			@RequestParam(value="labelType", required=false,defaultValue="3")int labelType){
		Result<List<Address>> result = new Result<List<Address>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userAddressSupport.list(userWeixin.getId(), labelType));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}

	/**
	 * 添加
	 * @param openid
	 * @return
	 */
	@RequestMapping("/add")
	public Result<Map<String,String>> add(HttpServletRequest request,@RequestBody Address address){
		Result<Map<String,String>> result = new Result<Map<String,String>>();
		try {
			VlidationUtil.validate(address);
			
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			address.setUserId(userWeixin.getId());
			result.setDatas(userAddressSupport.add(address));
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
	 * 修改
	 * @param openid
	 * @return
	 */
	@RequestMapping("/update")
	public Result<Boolean> update(HttpServletRequest request,@RequestBody Address address){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(address);
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			address.setUserId(userWeixin.getId());
			result.setDatas(userAddressSupport.update(address));
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
	 * 置顶
	 * @param openid
	 * @return
	 */
	@RequestMapping("/updateUpdateTime")
	public Result<Boolean> updateUpdateTime(HttpServletRequest request,@RequestBody AddressDto address){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(address);
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			address.setUserId(userWeixin.getId());
			result.setDatas(userAddressSupport.updateUpdateTime(address));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	
	
	/**
	 * 删除
	 * @param openid
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public Result<String> delete(@RequestBody Map<String,String> body){
		Result<String> result = new Result<String>();
		String id = body.get("id");
		if(StringUtil.isEmpty(id)){
			result.setError(ErrorCodeEnum.ERROR);
			return result;
		}
		
		boolean flag = userAddressSupport.delete(Integer.parseInt(id));
		if(!flag){
			result.setError(ErrorCodeEnum.ERROR);
		}
		return result;
	}
	
}
