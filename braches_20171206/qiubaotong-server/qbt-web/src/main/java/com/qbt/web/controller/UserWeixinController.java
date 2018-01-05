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
import com.qbt.common.exception.BusinessException;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.util.StringUtil;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.persistent.entity.VipType;
import com.qbt.web.pojo.base.SiteModel;
import com.qbt.web.pojo.user.Contacts;
import com.qbt.web.pojo.user.UserCourseVo;
import com.qbt.web.pojo.user.UserInfo;
import com.qbt.web.support.AssistantService;
import com.qbt.web.support.BaseCourseSupport;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.UserWeixinSupport;
import com.qbt.web.support.VipUserSupport;

/**
 *  用户信息接口
  * @ClassName: UserWeixinController
  * @Description: TODO
  * @author share 2016年8月19日
  * @modify share 2016年8月19日
 */
@Controller
@RequestMapping("/user")
public class UserWeixinController {
	
	@Resource
	private LoginSupport loginSupport;
	@Resource
	private VipUserSupport vipUserSupport;
	@Resource
	private BaseCourseSupport baseCourseSupport;
	@Resource
	private AssistantService assistantService;
	@Resource
	private UserWeixinSupport userWeixinSupport;
	
	/**
	 *  用户信息接口
	  * @Title: query_user_info
	  * @Description: TODO
	  * @author: share 2016年8月14日
	  * @modify: share 2016年8月14日
	  * @param request
	  * @return
	 */
	@RequestMapping("/query_user_info")
	public Result<UserInfo> query_user_info(HttpServletRequest request){
		Result<UserInfo> result = new Result<UserInfo>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			UserInfo userInfo = new UserInfo();
			userInfo.setEmail(userWeixin.getEmail());
			userInfo.setHeadImgUrl(userWeixin.getHeadImgUrl());
			userInfo.setMobile(userWeixin.getMobile());
			userInfo.setName(userWeixin.getName());
			userInfo.setNickname(userWeixin.getNickname());
			userInfo.setSex(userInfo.getSex());
			
			VipType vipType = vipUserSupport.findVipType();
			userInfo.setVipAmount(vipType == null?0:vipType.getOrderAmount().doubleValue());
			userInfo.setAssistantUser(assistantService.checkIsPartner(userWeixin.getId()));
			result.setDatas(userInfo);
		} catch (WechatException e) {  
            result.setCode(e.getCode());
            result.setMsg(e.getMessage());
            return result;
        } catch (Exception e) {
        	LogCvt.error(e.getMessage(),e);
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg("系统异常");
            return result;
        } 
		return result;
	}
	
	/**
	 *  更新用户信息
	  * @Title: update_user_info
	  * @Description: TODO
	  * @author: share 2016年8月19日
	  * @modify: share 2016年8月19日
	  * @param request
	  * @return
	 */
	@RequestMapping("/update_user_info")
	public Result<String> update_user_info(HttpServletRequest request,@RequestBody UserInfo userInfo){
		Result<String> result = new Result<String>();
		/**
		 * 订单信息基本校验
		 */
		try {  
            VlidationUtil.validate(userInfo); 
            if(!StringUtil.isMobile(userInfo.getMobile())){
            	result.setMsg("手机号格式不正确");
            	return result;
            }
            String openid = String.valueOf(request.getAttribute("openid"));
            UserWeixin user = loginSupport.findByOpenId(openid);
    		UserWeixin userWeixin = new UserWeixin();
    		userWeixin.setId(user.getId());
    		userWeixin.setOpenid(openid);
    		userWeixin.setName(userInfo.getName());
    		userWeixin.setMobile(userInfo.getMobile());
    		loginSupport.update(userWeixin);
        } catch (ValidationException e) {  
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg(e.getMessage());
            return result;
        } catch (WechatException e) {  
            result.setCode(e.getCode());
            result.setMsg(e.getMessage());
            return result;
        } catch (Exception e) {
        	LogCvt.error(e.getMessage(),e);
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg("系统异常");
            return result;
        } 
		return result;
	}
	
	
	/**
	 *  查询用户常用球场5
	  * @Title: query_course
	  * @Description: TODO
	  * @author: share 2016年9月23日
	  * @modify: share 2016年9月23日
	  * @param request
	  * @return
	 */
	@RequestMapping("/query_course")
	public Result<List<SiteModel>> query_course(HttpServletRequest request,@RequestParam(value="type", required=false,defaultValue="1")int type){
		Result<List<SiteModel>> result = new Result<List<SiteModel>>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
            UserWeixin user = loginSupport.findByOpenId(openid);
            
            result.setDatas(baseCourseSupport.findCourseByUserId(user.getId(),type));
        } catch (WechatException e) {  
            result.setCode(e.getCode());
            result.setMsg(e.getMessage());
            return result;
        } catch (Exception e) {
        	LogCvt.error(e.getMessage(),e);
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg("系统异常");
            return result;
        } 
		return result;
	}
	
	/**
	 * 历史联系人
	  * @Title: query_old_contacts
	  * @Description: TODO
	  * @author: chenxiaocong 2017年4月11日
	  * @modify: chenxiaocong 2017年4月11日
	  * @param request
	  * @return
	 */
	@RequestMapping("/query_old_contacts")
	public Result<List<Contacts>> query_old_contacts(HttpServletRequest request){
		Result<List<Contacts>> result = new Result<List<Contacts>>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
            UserWeixin user = loginSupport.findByOpenId(openid);
            
            result.setDatas(userWeixinSupport.findOldContactsByUserId(user.getId()));
        } catch (WechatException e) {  
            result.setCode(e.getCode());
            result.setMsg(e.getMessage());
            return result;
        } catch (Exception e) {
        	LogCvt.error(e.getMessage(),e);
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg("系统异常");
            return result;
        } 
		return result;
	}
	
	/**
	 * 删除联系人
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping("/delete_old_contacts")
	public Result<String> delete_old_contacts(HttpServletRequest request, Integer id){
		Result<String> result = new Result<String>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
            UserWeixin user = loginSupport.findByOpenId(openid);
            
			userWeixinSupport.deleteOldContactsById(user.getId(), id);
			result.setDatas("删除成功");
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}  catch (Exception e) {
			String errMsg = "删除异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

	@RequestMapping("/query_old_course")
	public Result<List<UserCourseVo>> query_old_course(HttpServletRequest request){
		Result<List<UserCourseVo>> result = new Result<List<UserCourseVo>>();
		try {  
            String openid = String.valueOf(request.getAttribute("openid"));
            UserWeixin user = loginSupport.findByOpenId(openid);
            
            result.setDatas(userWeixinSupport.findCourseByUserId(user.getId()));
        } catch (WechatException e) {  
            result.setCode(e.getCode());
            result.setMsg(e.getMessage());
            return result;
        } catch (Exception e) {
        	LogCvt.error(e.getMessage(),e);
            result.setError(ErrorCodeEnum.ERROR_VALID_FAIL);
            result.setMsg("系统异常");
            return result;
        } 
		return result;
	}
	
}
