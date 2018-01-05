package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.userAddress.UserAddressPageReqVo;
import com.qbt.web.pojo.userAddress.UserAddressVo;
import com.qbt.web.support.UserAddressSupport;

/**
 * 用户地址模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/userAddress")
public class UserAddressController {

	@Resource
	private UserAddressSupport userAddressSupport;
	
	/**
	 * 根据微信用户id，获取地址列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<UserAddressVo>> findByPage(@RequestBody UserAddressPageReqVo reqVo){
		PageResult<List<UserAddressVo>> result = new PageResult<List<UserAddressVo>>();
		try {
			result.setDatas(userAddressSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "顺丰客服分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 新增微信用户地址
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "addByUserWXId", method = RequestMethod.POST)
	public Result<String> addByUserWXId(@RequestBody UserAddressVo vo){
		Result<String> result = new Result<String>();
		try {
			userAddressSupport.add(vo);
			result.setDatas("新增微信用户地址成功");
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增微信用户地址异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 根据用户id查用户常用地址(分页)
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findListByUserId", method = RequestMethod.POST)
	public PageResult<List<UserAddressVo>> findListByUserId(@RequestBody UserAddressPageReqVo reqVo){
		PageResult<List<UserAddressVo>> result = new PageResult<List<UserAddressVo>>();
		try {
			result.setDatas(userAddressSupport.findListByUserId(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "根据用户id查用户常用地址(分页)异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
