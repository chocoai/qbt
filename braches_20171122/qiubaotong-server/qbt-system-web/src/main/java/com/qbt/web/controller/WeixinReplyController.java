/**
 * Project Name:qbt-system-web
 * File Name:WeixinReplyController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年2月6日下午4:23:02
 *
*/

package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.weixinReply.WeixinReplyPageReqVo;
import com.qbt.web.pojo.weixinReply.WeixinReplyVo;
import com.qbt.web.support.WeixinReplySupport;

/**
 * ClassName:WeixinReplyController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年2月6日 下午4:23:02
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/weixinReply")
public class WeixinReplyController {
	
	@Resource
	private WeixinReplySupport weixinReplySupport;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody WeixinReplyVo vo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(weixinReplySupport.add(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("添加微信自动回复异常");
		}
		return result;
	}
	
	@RequestMapping("/findByPage")
	public PageResult<List<WeixinReplyVo>> findByPage(@RequestBody WeixinReplyPageReqVo reqVo){
		PageResult<List<WeixinReplyVo>> result = new PageResult<List<WeixinReplyVo>>();
		try {
			result.setDatas(weixinReplySupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("微信自动回复分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "/detail")
	public Result<WeixinReplyVo> detail(@RequestParam("id") Integer id){
		Result<WeixinReplyVo> result = new Result<WeixinReplyVo>();
		try {
			result.setDatas(weixinReplySupport.detail(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("微信自动回复详情查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody WeixinReplyVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(weixinReplySupport.update(vo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新微信自动回复异常");
		}
		return result;
	}
	
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST)
	public Result<Boolean> updateStatus(@RequestBody WeixinReplyVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(weixinReplySupport.updateStatus(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("启用/禁用微信自动回复异常");
		}
		return result;
	}
	
	@RequestMapping(value = "/delete")
	public Result<Boolean> delete(@RequestParam("id") Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(weixinReplySupport.delete(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("删除微信自动回复异常");
		}
		return result;
	}
	
}
