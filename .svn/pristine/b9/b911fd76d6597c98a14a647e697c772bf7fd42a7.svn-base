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
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogPageReqVo;
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogPageVo;
import com.qbt.web.pojo.baseSfExpressLog.BaseSfExpressLogVo;
import com.qbt.web.support.BaseSfExpressLogSupport;

/**
 * 顺丰发送日志
 * @author wuwang
 *
 */
@Controller
@RequestMapping("/baseSfExpressLog")
public class BaseSfExpressLogController {

	@Resource
	private BaseSfExpressLogSupport baseSfExpressLogSupport;
	
	/**
	 * 分页
	 * @param reqVo
	 * @return
	 */
	
	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<BaseSfExpressLogPageVo>> findByPage(@RequestBody BaseSfExpressLogPageReqVo reqVo) {
		PageResult<List<BaseSfExpressLogPageVo>> result = new PageResult<List<BaseSfExpressLogPageVo>>();
		try {
			result.setDatas(baseSfExpressLogSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "顺丰发送日志分页查询异常";
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
	public Result<BaseSfExpressLogVo> findById(Integer id){
		Result<BaseSfExpressLogVo> result = new Result<BaseSfExpressLogVo>();
		BaseSfExpressLogVo baseSfExpressLogVo = null;
		try {
			baseSfExpressLogVo = baseSfExpressLogSupport.findById(id);
		} catch (Exception e) {
			String errMsg = "顺丰发送日志详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		result.setDatas(baseSfExpressLogVo);
		return result;
	}
	
}
