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
import com.qbt.web.pojo.basePartner.BasePartnerPageReqVo;
import com.qbt.web.pojo.basePartner.BasePartnerVO;
import com.qbt.web.support.BasePartnerSupport;


/**
 * 合作社模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/basePartner")
public class BasePartnerController {

	@Resource
	private BasePartnerSupport basePartnerSupport;
	
	/**
	 * 添加
	 * @param vo
	 * @return
	 */
	@RequestMapping(value="add", method = RequestMethod.POST)
	public Result<String> add(@RequestBody BasePartnerVO vo){
		Result<String> result = new Result<String>();
		try {
			VlidationUtil.validate(vo);
			basePartnerSupport.insert(vo);
			result.setDatas("添加合作社成功。");
		} catch (ValidationException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_VALID_FAIL.getCode());
			result.setMsg(e.getMessage());
		} catch (BusinessException e) {
			LogCvt.error(e.getMsg(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMsg());
		}catch (Exception e) {
			String errMsg = "添加合作社异常";
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
	public PageResult<List<BasePartnerVO>> findByPage(@RequestBody BasePartnerPageReqVo reqVo){
		PageResult<List<BasePartnerVO>> result = new PageResult<List<BasePartnerVO>>();
		try {
			result.setDatas(basePartnerSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "合作社列表分页异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}
	
	/**
	 * 修改
	 * @param vo
	 */
	@RequestMapping(value="update", method = RequestMethod.POST)
	public Result<String> update(@RequestBody BasePartnerVO vo){
		Result<String> result = new Result<String>();
		if(vo!=null){
			basePartnerSupport.update(vo);
			result.setDatas("更新合作社成功。");
		}else{
			result.setDatas("对象为空。");
		}
		return result;
	}
	
	/**
	 * 获取详情
	 * @param id
	 * @return
	 */
	@RequestMapping(value="findById")
	public Result<BasePartnerVO> findById(Integer id){
		Result<BasePartnerVO> result = new Result<BasePartnerVO>();
		BasePartnerVO basePartnerVO = basePartnerSupport.findById(id);
		result.setDatas(basePartnerVO);
		return result;
	}
	
	/**
	 * 删除
	 * @param reqVo
	 * @return
	 */
	@RequestMapping("delete")
	public Result<String> delete(Integer id, int status){
		Result<String> result = new Result<String>();
		try {
			basePartnerSupport.updateStatus(id, status);
			result.setDatas("更新状态成功");
		} catch (BusinessException e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(e.getCode());
			result.setMsg(e.getMessage());
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg("更新状态异常");
		}
		return result;
	}
	
}
