/**
 * Project Name:qbt-web
 * File Name:UserImageController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年1月11日上午11:42:26
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.userImage.UserImageDeleteRequest;
import com.qbt.web.pojo.userImage.UserImageVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UserImageSupport;

/**
 * ClassName:UserImageController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 上午11:42:26
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/userImage")
public class UserImageController {
	
	@Resource
	private UserImageSupport userImageSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	
	@RequestMapping("/list")
	public Result<List<UserImageVo>> list(HttpServletRequest request, 
			@RequestParam(value = "imgType", required = false, defaultValue = "1")Integer imgType){
		Result<List<UserImageVo>> result = new Result<List<UserImageVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userImageSupport.list(userWeixin.getId(), imgType));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/add")
	public Result<UserImageVo> add(HttpServletRequest request, 
			@RequestParam("pic")String pic, 
			@RequestParam(value = "imgType", required = false, defaultValue = "1")Integer imgType){
		Result<UserImageVo> result = new Result<UserImageVo>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(userImageSupport.add(userWeixin.getId(), pic, imgType));
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
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Result<Boolean> delete(@RequestBody UserImageDeleteRequest req){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(userImageSupport.delete(req));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
}
