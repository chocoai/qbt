package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.baseNews.BaseNewsCategoryVo;
import com.qbt.web.pojo.baseNews.BaseNewsOfficialVo;
import com.qbt.web.pojo.baseNews.BaseNewsPageReqVo;
import com.qbt.web.pojo.baseNews.BaseNewsVo;
import com.qbt.web.support.BaseNewsSupport;

/**
 * 官网新闻
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/baseNews")
public class BaseNewsController {

	@Resource
	private BaseNewsSupport baseNewsSupport;
	
	/**
	 * 添加
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BaseNewsVo vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			baseNewsSupport.add(vo);
			result.setDatas("添加新闻成功");
		}catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		}catch (Exception e) {
			String errMsg = "添加新闻异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 分页
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseNewsVo>> findByPage(@RequestBody BaseNewsPageReqVo reqVo){
		PageResult<List<BaseNewsVo>> result = new PageResult<List<BaseNewsVo>>();
		try {
			result.setDatas(baseNewsSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "新闻分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	@RequestMapping(value = "findByPageOfficial", method = RequestMethod.POST)
	public PageResult<List<BaseNewsOfficialVo>> findByPageOfficial(@RequestBody BaseNewsPageReqVo reqVo){
		PageResult<List<BaseNewsOfficialVo>> result = new PageResult<List<BaseNewsOfficialVo>>();
		try {
			result.setDatas(baseNewsSupport.findByPageOfficial(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "新闻分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 无登录态接口查询
	 * @param reqVo
	 * @return
	 */
	@RequestMapping(value = "list")
	public Result<List<BaseNewsVo>> list(Integer categoryId){
		Result<List<BaseNewsVo>> result = new Result<List<BaseNewsVo>>();
		try {
			result.setDatas(baseNewsSupport.list(categoryId));
		} catch (Exception e) {
			String errMsg = "获取新闻列表异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 无登录态接口查询分类新闻
	 * @return
	 */
	@RequestMapping(value = "listGroupByCategoryId")
	public Result<List<BaseNewsCategoryVo>> listGroupByCategoryId(){
		Result<List<BaseNewsCategoryVo>> result = new Result<List<BaseNewsCategoryVo>>();
		try {
			result.setDatas(baseNewsSupport.listGroupByCategoryId());
		} catch (Exception e) {
			String errMsg = "获取新闻列表异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 更新
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody BaseNewsVo vo){
		Result<String> result = new Result<String>();
		if(vo!=null){
			baseNewsSupport.update(vo);
			result.setDatas("更新新闻成功。");
		}else{
			result.setDatas("更新新闻异常。");
		}
		return result;
	}
	
	/**
	 * 详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findById")
	public Result<BaseNewsVo> findById(Integer id){
		Result<BaseNewsVo> result = new Result<BaseNewsVo>();
		BaseNewsVo baseNewsVo = baseNewsSupport.findById(id);
		result.setDatas(baseNewsVo);
		return result;
	}
	
	/**
	 * 官网新闻详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findByIdOfficial")
	public Result<BaseNewsVo> findByIdOfficial(Integer id){
		Result<BaseNewsVo> result = new Result<BaseNewsVo>();
		BaseNewsVo baseNewsVo = baseNewsSupport.findByIdOfficial(id);
		result.setDatas(baseNewsVo);
		return result;
	}
	
	/**
	 * 更新状态
	 * @param id
	 * @param status
	 * @return
	 */
	@RequestMapping("updateStatus")
	public Result<String> updateStatus(Integer id, int status){
		Result<String> result = new Result<String>();
		try {
			baseNewsSupport.updateStatus(id, status);
			result.setDatas("更新状态成功");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新状态异常");
		}
		return result;
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("delete")
	public Result<String> delete(Integer id){
		Result<String> result = new Result<String>();
		try {
			baseNewsSupport.delete(id);
			result.setDatas("删除成功");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("删除异常");
		}
		return result;
	}
	
	@RequestMapping("updateReadTimes")
	public Result<String> updateReadTimes(){
		Result<String> result = new Result<String>();
		try {
			baseNewsSupport.updateReadTimes();
			result.setDatas("更新数量成功");
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新数量异常");
		}
		return result;
	}
	
}
