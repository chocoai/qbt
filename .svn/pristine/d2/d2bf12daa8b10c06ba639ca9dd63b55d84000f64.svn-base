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
import com.qbt.web.pojo.baseSfSite.BaseSfSitePageReqVo;
import com.qbt.web.pojo.baseSfSite.BaseSfSiteVo;
import com.qbt.web.support.BaseSfSiteSupport;

/**
 * 顺丰站点模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping("baseSfSite")
public class BaseSfSiteController {

	@Resource
	private BaseSfSiteSupport baseSfSiteSupport;
	
	/**
	 * 获取分页列表
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseSfSiteVo>> findByPage(@RequestBody BaseSfSitePageReqVo reqVo){
		PageResult<List<BaseSfSiteVo>> result = new PageResult<List<BaseSfSiteVo>>();
		try {
			result.setDatas(baseSfSiteSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "顺丰站点列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 添加顺丰站点
	 * @param baseSfSite
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseSfSiteVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseSfSiteSupport.add(vo);
			result.setDatas("添加顺丰站点成功");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加顺丰站点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 更新顺丰站点
	 * @param baseSfSite
	 * @return
	 */
	@RequestMapping(value = "updateById", method = RequestMethod.POST)
	public Result<String> updateById(@RequestBody BaseSfSiteVo Vo){
		Result<String> result = new Result<String>();
		try {
			baseSfSiteSupport.updateById(Vo);
			result.setDatas("编辑成功");
		} catch (Exception e) {
			String errMsg = "更新顺丰站点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("deleteById")
	public Result<String> deleteById(Integer id){
		Result<String> result = new Result<String>();
		try {
			baseSfSiteSupport.deleteById(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			String errMsg = "删除顺丰站点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "findById")
	public Result<BaseSfSiteVo> findById(Integer id){
		Result<BaseSfSiteVo> result = new Result<BaseSfSiteVo>();
		BaseSfSiteVo baseSfSiteVo = null;
		try {
			baseSfSiteVo = baseSfSiteSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "查看微信用户详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(baseSfSiteVo);
		return result;
	}
	
	//软删除
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(@RequestParam(value = "id", required = true)Integer id
								, @RequestParam(value = "isDelete", required = false, defaultValue = "true")Boolean isDelete){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(baseSfSiteSupport.delete(id, isDelete));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			String errMsg = "删除顺丰站点异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
}
