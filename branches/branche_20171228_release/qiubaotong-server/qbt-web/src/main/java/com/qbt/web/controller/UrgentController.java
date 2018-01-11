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
import com.qbt.web.pojo.base.Area;
import com.qbt.web.pojo.urgent.UrgentPageReqVo;
import com.qbt.web.pojo.urgent.UrgentVo;
import com.qbt.web.support.AreaSupport;
import com.qbt.web.support.UrgentSupport;

@Controller
@RequestMapping("/urgent")
public class UrgentController {

	@Resource
	private UrgentSupport urgentSupport;
	
	@Resource
	private AreaSupport areaSupport;

	@RequestMapping(value = "findByPage", method = RequestMethod.POST)
	public PageResult<List<UrgentVo>> findByPage(@RequestBody UrgentPageReqVo reqVo) {
		PageResult<List<UrgentVo>> result = new PageResult<List<UrgentVo>>();
		try {
			result.setDatas(urgentSupport.findByPage(reqVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "加急分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

	@RequestMapping(value = "findByArea", method = RequestMethod.POST)
	public PageResult<List<UrgentVo>> findByArea(@RequestBody UrgentPageReqVo reqVo) {
		PageResult<List<UrgentVo>> result = new PageResult<List<UrgentVo>>();
		
		Area fromArea = areaSupport.findById(Integer.valueOf(reqVo.getFromArea()));
		Area toArea = areaSupport.findById(Integer.valueOf(reqVo.getToArea()));
		
		UrgentPageReqVo reqCityVo = new UrgentPageReqVo();
		reqCityVo.setFromCity(fromArea.getSuperId()+"");
		reqCityVo.setToCity(toArea.getSuperId()+"");		
		
		try {
			result.setDatas(urgentSupport.findByPage(reqCityVo));
			result.setPage(reqVo);
		} catch (Exception e) {
			String errMsg = "加急分页查询异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

	@RequestMapping("detail")
	public Result<UrgentVo> detail(Integer id) {
		Result<UrgentVo> result = new Result<UrgentVo>();
		try {
			result.setDatas(urgentSupport.findById(id));
		} catch (Exception e) {
			String errMsg = "查询加急详情异常";
			LogCvt.error(errMsg, e);
			result.setCode(ErrorCodeEnum.ERROR_SYS.getCode());
			result.setMsg(errMsg);
		}
		return result;
	}

}
