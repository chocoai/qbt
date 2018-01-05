/**
 * Project Name:qbt-system-web
 * File Name:PopUpController.java
 * Package Name:com.qbt.web.controller
 * Date:2017年1月17日下午1:21:23
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

import com.qbt.common.enums.ErrorCodeEnum;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.logback.LogCvt;
import com.qbt.common.result.PageResult;
import com.qbt.common.result.Result;
import com.qbt.common.validate.VlidationUtil;
import com.qbt.web.pojo.popUp.PopUpDetailVo;
import com.qbt.web.pojo.popUp.PopUpPageReqVo;
import com.qbt.web.pojo.popUp.PopUpVo;
import com.qbt.web.support.PopUpSupport;

/**
 * ClassName:PopUpController
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月17日 下午1:21:23
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Controller
@RequestMapping("/popUp")
public class PopUpController {
	
	@Resource
	private PopUpSupport popUpSupport;
	
	
	@RequestMapping(value = "findByPage")
	public PageResult<List<PopUpVo>> findByPage(@RequestBody PopUpPageReqVo reqVo){
		PageResult<List<PopUpVo>> result = new PageResult<List<PopUpVo>>();
		try {
			result.setDatas(popUpSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("弹框管理分页查询异常");
		}
		return result;
	}
	
	@RequestMapping("detail")
	public Result<PopUpDetailVo> detail(Integer id){
		Result<PopUpDetailVo> result = new Result<PopUpDetailVo>();
		try {
			result.setDatas(popUpSupport.detail(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("弹框管理详情查询异常");
		}
		return result;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public Result<Boolean> add(@RequestBody PopUpDetailVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(popUpSupport.add(vo));
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
			result.setMsg("新增弹框异常");
		}
		return result;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public Result<Boolean> update(@RequestBody PopUpDetailVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			VlidationUtil.validate(vo);
			result.setDatas(popUpSupport.update(vo));
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
			result.setMsg("更新弹框异常");
		}
		return result;
	}
	
	@RequestMapping(value = "delete")
	public Result<Boolean> delete(Integer id){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(popUpSupport.delete(id));
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("删除弹框异常");
		}
		return result;
	}
	
	@RequestMapping(value = "updateStatus")
	public Result<Boolean> updateStatus(@RequestBody PopUpVo vo){
		Result<Boolean> result = new Result<Boolean>();
		try {
			result.setDatas(popUpSupport.updateStatus(vo));
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("删除弹框异常");
		}
		return result;
	}
	
}
