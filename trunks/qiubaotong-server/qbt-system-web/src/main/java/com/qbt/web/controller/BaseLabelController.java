package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.Result;
import com.qbt.web.pojo.baseLabel.BaseLabelVO;
import com.qbt.web.pojo.baseUserLabel.UserLabelVO;
import com.qbt.web.support.BaseLabelSupport;

@Controller
@RequestMapping(value="/baseLabel")
public class BaseLabelController {

	@Resource
	private BaseLabelSupport baseLabelSupport;
	
	@RequestMapping("list")
	public Result<List<BaseLabelVO>> list(){
		Result<List<BaseLabelVO>> result = new Result<List<BaseLabelVO>>();
		List<BaseLabelVO> bsaseLabelVOList = baseLabelSupport.list();
		result.setDatas(bsaseLabelVOList);
		return result;
	}
	
	@RequestMapping(value = "addUserLabel",  method = RequestMethod.POST)
	public Result<String> addUserLabel(@RequestBody UserLabelVO userVO){
		Result<String> result = new Result<String>();
		try {
			baseLabelSupport.addUserLabel(userVO);
			result.setDatas("添加用户标签成功！");
		}catch (Exception e) {
			String errMsg = "添加用户标签异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping("listByMobile")
	public Result<List<Integer>> listByMobile(Integer userType, Integer userId){
		Result<List<Integer>> result = new Result<List<Integer>>();
		List<Integer> LabelIdList = baseLabelSupport.findByUser(userType, userId);
		result.setDatas(LabelIdList);
		return result;
	}
	
	@RequestMapping("listContentByMobile")
	public Result<List<String>> listContentByMobile(Integer userType, Integer userId){
		Result<List<String>> result = new Result<List<String>>();
		List<String> LabelContentList = baseLabelSupport.findContentByUser(userType, userId);
		result.setDatas(LabelContentList);
		return result;
	}
	
}
