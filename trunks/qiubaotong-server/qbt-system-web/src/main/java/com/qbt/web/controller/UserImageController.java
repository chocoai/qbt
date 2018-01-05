/**
 * Project Name:qbt-system-web
 * File Name:UserImageController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年1月11日下午2:46:56
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.userImage.UserImageVo;
import com.qbt.web.support.UserImageSupport;

/**
 * ClassName:UserImageController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月11日 下午2:46:56
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/userImage")
public class UserImageController {
	
	@Resource
	private UserImageSupport userImageSupport;
	
	@RequestMapping("/list")
	public Result<List<UserImageVo>> list(@RequestParam("userId")Integer userId, 
										@RequestParam(value = "type", required = false, defaultValue = "1")Integer type){
		Result<List<UserImageVo>> result = new Result<List<UserImageVo>>();
		try {
			result.setDatas(userImageSupport.list(userId, type));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/add")
	public Result<Integer> add(@RequestBody UserImageVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(userImageSupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
	@RequestMapping("/delete")
	public Result<Boolean> delete(@RequestParam("ids")List<Integer> ids){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(userImageSupport.delete(ids));
		} catch (Exception e) {
			result.setCode(ErrorCodeEnum.ERROR.getCode());
			result.setMsg(ErrorCodeEnum.ERROR.getMsg());
			LogCvt.error(e.getMessage(),e);
		}
		return result;
	}
	
}
