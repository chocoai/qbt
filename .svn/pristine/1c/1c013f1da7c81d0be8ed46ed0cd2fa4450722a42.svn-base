package com.qbt.web.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.ActivityTicketPackage;
import com.qbt.persistent.entity.UserWeixin;
import com.qbt.web.pojo.ticket.UserActivityPackageVo;
import com.qbt.web.pojo.ticket.UserPackageTicketVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.MyTicketPackageSupport;

/**
 * @ClassName: MyTicketPackageController
 * @author andy.li
 * @Description: TODO
 */
@Controller
@RequestMapping("/myTicketPackage")
public class MyTicketPackageController {
	
	@Resource
	private MyTicketPackageSupport myTicketPackageSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	/**
	  * @Title: listNotActive
	  * @Description: Search (active_status=0 and package_type=0))
	  * @author: andy.li
	  * @return List<UserActivityPackageVo>
	  */
	@RequestMapping("/listNotActive")
	public Result<List<UserActivityPackageVo>> listNotActive(HttpServletRequest request){
		Result<List<UserActivityPackageVo>> result = new Result<List<UserActivityPackageVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(myTicketPackageSupport.findlistNotActive(userWeixin.getId()));
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
	  * @Title: listUsed
	  * @Description: Search (active_status=1 or package_type in(1,2) or(active_status=1 and today>expiration_time))
	  * @author: andy.li
	  * @return List<UserActivityPackageVo>
	 */
	@RequestMapping("/listUsed")
	public Result<List<UserActivityPackageVo>> listUsed(HttpServletRequest request){
		Result<List<UserActivityPackageVo>> result = new Result<List<UserActivityPackageVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(myTicketPackageSupport.findlistUsed(userWeixin.getId()));
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
	 * @Title: listAvailableTicket
	 * @author: andy.li
	 * @return List<UserPackageTicketVo>
	 */
	@RequestMapping("/listAvailableTicket")
	public Result<List<UserPackageTicketVo>> listAvailableTicket(HttpServletRequest request){
		Result<List<UserPackageTicketVo>> result = new Result<List<UserPackageTicketVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(myTicketPackageSupport.findlistAvailableTicket(userWeixin.getId()));
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
	 * @Title: listDisableTicket
	 * @author: andy.li
	 * @return List<UserPackageTicketVo>
	 */
	@RequestMapping("/listDisableTicket")
	public Result<List<UserPackageTicketVo>> listDisableTicket(HttpServletRequest request){
		Result<List<UserPackageTicketVo>> result = new Result<List<UserPackageTicketVo>>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			UserWeixin userWeixin = loginSupport.findByOpenId(openid);
			result.setDatas(myTicketPackageSupport.findlistDisableTicket(userWeixin.getId()));
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
	 * @Title: activate
	 * @Description:update active_status  = 1
	 * @param packageId
	 * @param activateUser
	 * @param activatePhoneNumber
	 * @param code
	 * @param codeStatus
	 * @author: andy.li
	 * @return
	 */
	@RequestMapping("/activate")
	public Result<String> activate(int packageId,String activateUser,String activatePhoneNumber,String code,int codeStatus){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(myTicketPackageSupport.activate(packageId,activateUser,activatePhoneNumber,code,codeStatus));
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
	 * @Title: cancel
	 * @Description:update package_type = 0
	 * @param packageId
	 * @author: andy.li
	 * @return
	 */
	@RequestMapping("/cancel")
	public Result<String> cancel(int packageId){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(myTicketPackageSupport.cancel(packageId));
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
	 * @Title: recieve
	 * @Description:
	 *  update package_type = 2
		copy a new package to current user
	 * @param 接受方的userId
	 * @param 赠送方的packageId
	 * @param qrCode
	 * @return
	 */
	@RequestMapping("/recieve")
	public Result<String> recieve(int userId,int packageId){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(myTicketPackageSupport.recieve(userId,packageId));
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
	 * @Title: qrcode
	 * @Description: post :package_id (update qrcode to user_activity_package, update package_type = 1)
	 * @param packageId
	 * @param url
	 * @author: andy.li
	 * @return 
	 */
	@RequestMapping(value="/qrcode",method = RequestMethod.POST)
	public Result<String> qrcode(int packageId,String url,HttpServletRequest request,HttpServletResponse response){
		Result<String> result=new Result<String>();
		String webpath=request.getSession().getServletContext().getRealPath("/")+"WEB-INF/qrCodeImg/";
		byte[] qrCode=myTicketPackageSupport.qrcode(packageId, url,webpath);
		if(qrCode!=null){
		response.setContentType("image/png");
		OutputStream out;
		try {
			out = response.getOutputStream();
			out.write(qrCode);
		    out.flush();
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//清除服务器下二维码临时图片
//		try {
//			ZxingUtil.deletefile(webpath);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	  }else{
		  result.setDatas("获取二维码失败!");
	  }
		return result;
	}
	
	
	/**
	 * @Title: useTicket
	 * @Description update table user_package_ticket,set used_quantity+1
	 * @author: andy.li
	 * @param ticketId
	 * @return
	 */
	@RequestMapping("/useTicket")
	public Result<String> useTicket(int ticketId){
		Result<String> result = new Result<String>();
		try {
			result.setDatas(myTicketPackageSupport.useTicket(ticketId));
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
	 * @Title: findPackageById
	 * @Description find details Package info by packageId
	 * @author: andy.li
	 * @param packageId
	 * @return ActivityTicketPackage
	 */
	@RequestMapping("/findPackageById")
	public Result<ActivityTicketPackage> findPackageById(int packageId){
		Result<ActivityTicketPackage> result = new Result<ActivityTicketPackage>();
		try {
			result.setDatas(myTicketPackageSupport.findPackageById(packageId));
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
