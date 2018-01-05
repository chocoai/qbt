
 /**
 * @Title: VipUserWeixinController.java
 * @Package com.qbt.web.controller
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater Administrator 2016年11月3日
 * @version V1.0
 **/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.vip.ActivateRequest;
import com.qbt.web.pojo.vip.VipTypeVo;
import com.qbt.web.pojo.vip.VipUser;
import com.qbt.web.pojo.vip.VipUserModifyImgRequest;
import com.qbt.web.pojo.vip.VipUserModifyRequest;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.VipUserSupport;

/**
  * vip会员信息
  * @ClassName: VipUserWeixinController
  * @Description: TODO
  * @author Administrator 2016年11月3日
  * @modify Administrator 2016年11月3日
  */
@Controller
@RequestMapping("/vipUser")
public class VipUserWeixinController {

	@Resource
	private LoginSupport loginSupport;
	@Resource
	private VipUserSupport vipUserSupport;
	
	/**
	 *  会员卡申请类型返回
	 * @param code
	 * @param lon
	 * @param lat
	 * @return
	 */
	@RequestMapping("/vipApply")
	public Result<List<VipTypeVo>> vipApply(HttpServletRequest request,int status){
		Result<List<VipTypeVo>> result=new Result<List<VipTypeVo>>();
		try {
						
			//获取状态为正常的会员卡类型  1-正常 2-禁用 
			List<VipTypeVo> vipTypeList = vipUserSupport.getVipTypeByStaus(status);
			result.setDatas(vipTypeList);
			
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
	 *  会员卡列表
	  * @Title: list
	  * @Description: TODO
	  * @author: share 2017年1月11日
	  * @modify: share 2017年1月11日
	  * @param request
	  * @param status
	  * @return
	 */
	@RequestMapping("/list")
	public Result<List<VipUser>> list(HttpServletRequest request){
		Result<List<VipUser>> result=new Result<List<VipUser>>();
		try {
						
			String openid = String.valueOf(request.getAttribute("openid"));
			List<VipUser> vipTypeList = vipUserSupport.findByOpenId(openid);
			result.setDatas(vipTypeList);
			
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
	 *  修改手机号or用户名
	  * @Title: modify
	  * @Description: TODO
	  * @author: share 2016年11月5日
	  * @modify: share 2016年11月5日
	  * @param request
	  * @return
	 */
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public Result<String> modify(HttpServletRequest request,@RequestBody VipUserModifyRequest req){
		Result<String> result=new Result<String>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			req.setOpenId(openid);
			vipUserSupport.modify(req);
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
	 *  会员卡激活
	  * @Title: activate
	  * @Description: TODO
	  * @author: share 2017年1月4日
	  * @modify: share 2017年1月4日
	  * @param request
	  * @param req
	  * @return
	 */
	@RequestMapping(value="/activate",method=RequestMethod.POST)
	public Result<String> activate(HttpServletRequest request,@RequestBody ActivateRequest req){
		Result<String> result=new Result<String>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			req.setOpenId(openid);
			vipUserSupport.activate(req);
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
	 * detail:(会员卡详情).
	 *
	 * @author huangyihao
	 * 2017年1月12日 上午11:14:28
	 * @param id
	 * @return
	 *
	 */
	@RequestMapping(value="/detail")
	public Result<VipUser> detail(Integer id){
		Result<VipUser> result = new Result<VipUser>();
		try {
			result.setDatas(vipUserSupport.detail(id));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/modifyImg")
	public Result<Boolean> modifyImg(HttpServletRequest request, @RequestBody VipUserModifyImgRequest req){
		Result<Boolean> result = new Result<Boolean>();
		try {
			String openid = String.valueOf(request.getAttribute("openid"));
			req.setOpenId(openid);
			result.setDatas(vipUserSupport.modifyImg(req));
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
	
}
