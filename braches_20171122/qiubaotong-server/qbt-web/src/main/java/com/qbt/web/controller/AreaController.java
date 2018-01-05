package com.qbt.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.result.Result;
import com.qbt.web.pojo.base.Area;
import com.qbt.web.support.AreaSupport;

/**
 * 地区管理
 * @author share
 *
 */
@Controller
@RequestMapping("/area")
public class AreaController {

	@Resource
	private AreaSupport areadSupport;
	
	/**
	 * 地区
	 * @param superId
	 * @return
	 */
	@RequestMapping("/list")
	public Result<List<Area>> list(int superId){
		Result<List<Area>> result = new Result<List<Area>>();
		result.setDatas(areadSupport.findBySuperId(superId));
		return result;
	}
	
	@RequestMapping("/query_id")
	public Result<Area> query_id(int id){
		Result<Area> result = new Result<Area>();
		result.setDatas(areadSupport.findById(id));
		return result;
	}
	
	@RequestMapping("/query_name")
	public Result<Area> query_name(String name){
		Result<Area> result = new Result<Area>();
		result.setDatas(areadSupport.findByName(name));
		return result;
	}
	
	@RequestMapping("/query_level")
	public Result<List<Area>> query_level(int level){
		Result<List<Area>> result = new Result<List<Area>>();
		result.setDatas(areadSupport.findByLevel(level+1));
		return result;
	}
	
	@RequestMapping("/query_level_course")
	public Result<List<Area>> query_level_course(int level){
		Result<List<Area>> result = new Result<List<Area>>();
		result.setDatas(areadSupport.findByLevelCourse(level+1));
		return result;
	}
	
}
