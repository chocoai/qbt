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
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.channelQrcodeInfo.ChannelQrcodeInfoPageReqVo;
import com.qbt.web.pojo.channelQrcodeInfo.ChannelQrcodeInfoVo;
import com.qbt.web.support.ChannelQrcodeInfoSupport;

/**
 * 渠道二维码管理
 * @author wuwang
 *
 */
@Controller
@RequestMapping("channelQrcodeInfo")
public class ChannelQrcodeInfoController {

	@Resource
	private ChannelQrcodeInfoSupport channelQrcodeInfoSupport;
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<ChannelQrcodeInfoVo>> findByPage(@RequestBody ChannelQrcodeInfoPageReqVo reqVo){
		PageResult<List<ChannelQrcodeInfoVo>> result = new PageResult<List<ChannelQrcodeInfoVo>>();
		try {
			result.setDatas(channelQrcodeInfoSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody ChannelQrcodeInfoVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			channelQrcodeInfoSupport.add(vo);
			result.setDatas("添加成功");
		} catch (Exception e) {
			String errMsg = "添加异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody ChannelQrcodeInfoVo Vo){
		Result<String> result = new Result<String>();
		try {
			channelQrcodeInfoSupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "更新异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("updateStatus")
	public Result<String> updateStatus(Integer id, int status){
		Result<String> result = new Result<String>();
		try {
			channelQrcodeInfoSupport.updateStatus(id, status);
			result.setDatas("更新状态成功");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新状态异常");
		}
		return result;
	}
	
	@RequestMapping(value = "findById")
	public Result<ChannelQrcodeInfoVo> findById(Integer id){
		Result<ChannelQrcodeInfoVo> result = new Result<ChannelQrcodeInfoVo>();
		ChannelQrcodeInfoVo channelQrcodeInfoVo = null;
		try {
			channelQrcodeInfoVo = channelQrcodeInfoSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(channelQrcodeInfoVo);
		return result;
	}
	
}
