package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.userWeixin.UserWeixinPageReqVo;
import com.qbt.web.pojo.userWeixin.UserWeixinVo;
import com.qbt.web.pojo.userWeixin.WeiXinVO;
import com.qbt.web.support.UserWeixinSupport;

/**
 * 微信用户模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/userWeixin")
public class UserWeixinController {
	
	@Resource
	private UserWeixinSupport userWeixinSupport;
	
	/**
	 * 用户列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<UserWeixinVo>> findByPage(@RequestBody UserWeixinPageReqVo reqVo){
		PageResult<List<UserWeixinVo>> result = new PageResult<List<UserWeixinVo>>();
		try {
			result.setDatas(userWeixinSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "微信用户分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 获取用户详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findById")
	public Result<UserWeixinVo> findById(Integer id){
		Result<UserWeixinVo> result = new Result<UserWeixinVo>();
		UserWeixinVo userWeixinVo = null;
		try {
			userWeixinVo = userWeixinSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看微信用户详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(userWeixinVo);
		return result;
	}
	
	/**
	 * 编辑用户
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "updateUserWeixin", method = RequestMethod.POST)
	public Result<String> updateUserWeixin(@RequestBody UserWeixinPageReqVo reqVo){
		Result<String> result = new Result<String>();
		try {
			userWeixinSupport.update(reqVo);
			result.setDatas("修改用户成功");
		} catch (Exception e) {
			String errMsg = "修改微信用户详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("list")
	public Result<List<UserWeixinVo>> list(){
		Result<List<UserWeixinVo>> result = new Result<List<UserWeixinVo>>();
		List<UserWeixinVo> userWeixinVoList = userWeixinSupport.list();
		result.setDatas(userWeixinVoList);
		return result;
	}
	
	/**
	 * 通过手机号判断是否是微信用户
	 */
	@RequestMapping("isWeiXinUser")
	public Result<WeiXinVO> isWeiXinUser(String mobile){
		Result<WeiXinVO> result = new Result<WeiXinVO>();
		WeiXinVO weiXinVO = userWeixinSupport.isWeiXinUser(mobile);
		result.setDatas(weiXinVO);
		return result;
	}
	
	/**
	 * 根据openId获取用户id
	 */
	@RequestMapping("findUserIdByOpenId")
	public Result<Integer> findUserIdByOpenId(String openId){
		Result<Integer> result = new Result<Integer>();
		Integer userId = userWeixinSupport.findUserIdByOpenId(openId);
		result.setDatas(userId);
		return result;
	}
	
}
	

