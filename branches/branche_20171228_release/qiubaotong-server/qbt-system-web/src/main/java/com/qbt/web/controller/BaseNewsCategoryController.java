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
import com.qbt.web.pojo.baseNewsCatagory.BaseNewsCatagoryVo;
import com.qbt.web.pojo.baseNewsCatagory.NewsCatagoryPageVo;
import com.qbt.web.support.BaseNewsCategorySupport;

@Controller
@RequestMapping(value = "/newsCategory")
public class BaseNewsCategoryController {

	@Resource
	private BaseNewsCategorySupport categortSupport;
	
	/***
	 * 
	 * <b>方法名：</b>：doFindCategoryPage<br>
	 * <b>功能说明：</b>：分页查询新闻类型<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午4:59:57
	 * @param pageVo
	 * @return
	 */
	@RequestMapping(value = "findPage",method = RequestMethod.POST)
	public PageResult<List<BaseNewsCatagoryVo>> doFindCategoryPage(@RequestBody NewsCatagoryPageVo pageVo){
		 PageResult<List<BaseNewsCatagoryVo>> result = new PageResult<List<BaseNewsCatagoryVo>>();
		 try {
			 result.setDatas(categortSupport.doFindNewsCatagoryPage(pageVo));
			 result.setPage(pageVo);
		} catch (Exception e) {
			String errMsg = "分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		 return result;
	}
	
	@RequestMapping(value = "findList")
	public Result<List<BaseNewsCatagoryVo>> doFindCategoryList(){
		Result<List<BaseNewsCatagoryVo>> result = new Result<List<BaseNewsCatagoryVo>>();
		try {
			result.setDatas(categortSupport.doFindNewsCatagortList());
		} catch (Exception e) {
			String errMsg = "列表查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 
	 * <b>方法名：</b>：doFindCategoryDetail<br>
	 * <b>功能说明：</b>：查询新闻类型详情<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午5:00:18
	 * @param id
	 * @return
	 */
	@RequestMapping(value ="detail")
	public Result<BaseNewsCatagoryVo> doFindCategoryDetail(Integer id){
		 Result<BaseNewsCatagoryVo> result = new Result<BaseNewsCatagoryVo>();
		 try {
			 result.setDatas(categortSupport.doFindCategoryDetail(id));
		} catch (Exception e) {
			String errMsg = "分类信息查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doSaveCategory<br>
	 * <b>功能说明：</b>：新增新闻类型<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午5:00:33
	 * @param categortVo
	 * @return
	 */
	@RequestMapping(value = "add",method = RequestMethod.POST)
	public Result<Integer> doSaveCategory(@RequestBody BaseNewsCatagoryVo categortVo){
		Result<Integer> result = new Result<Integer>();
		try {
			VlidationUtil.validate(categortVo);
			result.setDatas(categortSupport.doSave(categortVo));
		}catch(ValidationException e){
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch(BusinessException e){
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "新增新闻类型异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doUpdateCategory<br>
	 * <b>功能说明：</b>：修改新闻分类信息<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午5:05:00
	 * @param categortVo
	 * @return
	 */
	@RequestMapping(value = "update",method = RequestMethod.POST)
	public Result<Boolean> doUpdateCategory(@RequestBody BaseNewsCatagoryVo categortVo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(categortVo);
			result.setDatas(categortSupport.doUpdate(categortVo));
		}catch(ValidationException e){
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch(BusinessException e){
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "修改新闻类型异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/***
	 * 
	 * <b>方法名：</b>：doDelteCategory<br>
	 * <b>功能说明：</b>：删除新闻分类<br>
	 * @author <font color='blue'>张祥</font> 
	 * @date  2017年3月24日 下午5:09:50
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "delete",method = RequestMethod.GET)
	public Result<Boolean> doDelteCategory(@RequestParam(value = "id") Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(categortSupport.doDelete(id));
		}catch(BusinessException e){
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			String errMsg = "删除新闻类型异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
}
