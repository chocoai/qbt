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
import com.qbt.web.pojo.course.CourseDetailVo;
import com.qbt.web.pojo.course.CoursePageReqVo;
import com.qbt.web.pojo.course.CoursePageRespVo;
import com.qbt.web.support.CourseSupport;

@Controller
@RequestMapping("/course")
public class CourseController {

	@Resource
	private CourseSupport courseSupport;

	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<CoursePageRespVo>> findByPage(@RequestBody CoursePageReqVo reqVo) {
		PageResult<List<CoursePageRespVo>> result = new PageResult<List<CoursePageRespVo>>();
		try {
			result.setDatas(courseSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "球场分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "detail")
	public Result<CourseDetailVo> detail(Integer id){
		Result<CourseDetailVo> result = new Result<CourseDetailVo>();
		try {
			result.setDatas(courseSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "球场详情查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Integer> add(@RequestBody CourseDetailVo reqVo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(reqVo);
			result.setDatas(courseSupport.add(reqVo));
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "新增球场异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody CourseDetailVo reqVo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(courseSupport.update(reqVo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "更新球场异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(@RequestParam(value = "id", required = true)Integer id
								, @RequestParam(value = "isDelete", required = false, defaultValue = "true")Boolean isDelete){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(courseSupport.delete(id, isDelete));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "删除球场异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
