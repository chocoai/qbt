package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysUser;
import com.qbt.web.pojo.comment.CommentPageReqVo;
import com.qbt.web.pojo.comment.OrderCommentVo;
import com.qbt.web.support.LoginSupport;
import com.qbt.web.support.OrderCommentSupport;

@Controller
@RequestMapping("/comment")
public class OrderCommentController {
	
	@Resource
	private OrderCommentSupport orderCommentSupport;
	
	@Resource
	private LoginSupport loginSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<OrderCommentVo>> findByPage(@RequestBody CommentPageReqVo reqVo){
		PageResult<List<OrderCommentVo>> result = new PageResult<List<OrderCommentVo>>();
		try {
			result.setDatas(orderCommentSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单评论分页查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(HttpServletRequest request, @RequestBody OrderCommentVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			SysUser sysUser = loginSupport.tokenCheck(request.getHeader("token"));
			result.setDatas(orderCommentSupport.updateComment(sysUser, vo));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("订单评论审核异常");
		}
		return result;
	}
	
}
