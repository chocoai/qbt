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
import com.qbt.web.pojo.baselink.BaseLinkPageReqVo;
import com.qbt.web.pojo.baselink.BaseLinkVo;
import com.qbt.web.support.BaseLinkSupport;

/**
 * 友情链接
 * 
 * @author yuweiwei
 *
 */
@Controller
@RequestMapping("/baseLink")
public class BaseLinkController {

	@Resource
	private BaseLinkSupport baseLinkSupport;

	@RequestMapping(value = "/findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseLinkVo>> findByPage(@RequestBody BaseLinkPageReqVo reqVo) {
		PageResult<List<BaseLinkVo>> result = new PageResult<List<BaseLinkVo>>();
		try {
			result.setDatas(baseLinkSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "友情链接分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;

	}

	/**
	 * 添加
	 * 
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseLinkVo vo) {
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseLinkSupport.add(vo);
			result.setDatas("添加友情链接成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "添加友情链接异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody BaseLinkVo vo) {

		Result<String> result = new Result<String>();

		try {
			VlidationUtil.validate(vo);
			baseLinkSupport.update(vo);
			result.setDatas("修改友情链接成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "修改友情链接异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}

		return result;
	}

	/**
	 * 详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/findById")

	public Result<BaseLinkVo> findById(Integer id) {

		Result<BaseLinkVo> result = new Result<BaseLinkVo>();
		BaseLinkVo baselinkVo = baseLinkSupport.findById(id);
		result.setDatas(baselinkVo);
		return result;

	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete", method = RequestMethod.GET)

	public Result<String> delete(@RequestParam(value = "id") Integer id) {

		Result<String> result = new Result<String>();
		try {
			baseLinkSupport.delete(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("删除异常");
		}
		return result;

	}

	/**
	 * 无登录态接口查询
	 * 
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public Result<List<BaseLinkVo>> list() {
		Result<List<BaseLinkVo>> result = new Result<List<BaseLinkVo>>();
		try {
			result.setDatas(baseLinkSupport.list());
		} catch (Exception e) {
			String errMsg = "获取友情链接异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

}
