package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.result.Result;
import com.qbt.web.pojo.base.Area;
import com.qbt.web.support.AreaSupport;

/**
 * 地区模块
 * @author wuwang
 *
 */
@Controller

@RequestMapping("/area")
public class BaseAreaController {
	
	@Resource
	private AreaSupport areadSupport;
	
	/**
	 * 获取省市区
	 * @param superId
	 * @return
	 */
	@RequestMapping("/list")
	public Result<List<Area>> list(int superId){
		Result<List<Area>> result = new Result<List<Area>>();
		result.setDatas(areadSupport.findBySuperId(superId));
		return result;
	}
}
