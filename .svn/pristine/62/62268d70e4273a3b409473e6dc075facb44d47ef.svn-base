/**
 * Project Name:qbt-system-web
 * File Name:VipInfoController.java
 * Package Name:com.qbt.web.controller
 * Date:2016年11月4日下午1:13:38
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

import com.qbt.bussiness.pojo.vip.VipOrderConfirmRequest;
import com.qbt.bussiness.pojo.vip.VipOrderConfirmResponse;
import com.qbt.bussiness.support.VipCommonSupport;
import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BaseException;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.exception.WechatException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.userImage.UserImageAppointVo;
import com.qbt.web.pojo.vipInfo.ActivateRequest;
import com.qbt.web.pojo.vipInfo.VipInfoPageReqVo;
import com.qbt.web.pojo.vipInfo.VipInfoVo;
import com.qbt.web.pojo.vipInfo.VipUserModifyRequest;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.VipInfoSupport;

/**
 * 会员信息 管理
 * ClassName:VipInfoController
 * Reason:	 TODO ADD REASON.
 * Date:     2016年11月4日 下午1:13:38
 * @author   haungyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/vipInfo")
public class VipInfoController {
	
	@Resource
	private VipInfoSupport vipInfoSupport;
	
	@Resource
	private VipCommonSupport vipCommonSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<VipInfoVo>> findByPage(@RequestBody VipInfoPageReqVo reqVo){
		PageResult<List<VipInfoVo>> result = new PageResult<List<VipInfoVo>>();
		try {
			result.setDatas(vipInfoSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "会员信息分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "detail")
	public Result<VipInfoVo> detail(Integer id){
		Result<VipInfoVo> result = new Result<VipInfoVo>();
		try {
			result.setDatas(vipInfoSupport.detail(id));
		} catch (Exception e) {
			String errMsg = "获取会员信息异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "updateStatus")
	public Result<Boolean> updateStatus(Integer id, Integer status){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(vipInfoSupport.updateStatus(id, status));
		} catch (Exception e) {
			String errMsg = "启用/禁用会员异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "addVipInfo")
	public Result<Boolean> addVipInfo(HttpServletRequest request, @RequestBody VipInfoVo vipInfoVo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			vipInfoVo.setOperatorId(sysUser.getId());
			vipInfoVo.setOperatorName(sysUser.getName());
			result.setDatas(vipInfoSupport.addVipInfo(vipInfoVo));
			
		} catch (BusinessException e){
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "购买会员异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 *  检查是否VIP订单
	  * @Title: checkVipOrder
	  * @Description: TODO
	  * @author: share 2016年11月5日
	  * @modify: share 2016年11月5日
	  * @param vipInfoVo
	  * @return
	 */
	@RequestMapping(value = "checkVipOrder")
	public Result<VipOrderConfirmResponse> checkVipOrder(@RequestBody VipOrderConfirmRequest reqVo){
		Result<VipOrderConfirmResponse> result = new Result<VipOrderConfirmResponse>();
		try {
			result.setDatas(vipCommonSupport.checkVipOrder(reqVo));
		} catch (BusinessException e){
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (BaseException e){
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "系统异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
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
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			req.setOperatorId(sysUser.getId());
			req.setOperatorName(sysUser.getName());
			vipInfoSupport.activate(req);
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
			vipInfoSupport.modify(req);
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
	 * 更新指定球包图片
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "updateAppointImage", method = RequestMethod.POST)
	public Result<Integer> updateAppointImage(@RequestBody UserImageAppointVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			vipInfoSupport.updateAppointImage(vo);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新指定球包图片异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 绑定微信用户
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "updateUserWeixin")
	public Result<Integer> updateUserWeixin(Integer userId, Integer id){
		Result<Integer> result = new Result<Integer>();
		try {
			vipInfoSupport.updateUserWeixin(userId, id);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "绑定微信用户异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 删除指定球包图片
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "deleteAppointImage")
	public Result<Integer> deleteAppointImage(Integer id){
		Result<Integer> result = new Result<Integer>();
		try {
			vipInfoSupport.deleteAppointImage(id);
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "删除指定球包图片异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
