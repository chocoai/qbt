package com.qbt.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qbt.common.result.Result;
import com.qbt.persistent.entity.SysRoleResource;
import com.qbt.web.support.SysRoleResourceSupport;

/**
 * 角色资源模块
 * @author wuwang
 *
 */
@Controller
@RequestMapping(value="/sysRoleResource")
public class SysRoleResourceController {

	@Resource
	private SysRoleResourceSupport sysRoleResourceSupport; 
	
	@RequestMapping("list")
	public Result<List<Integer>> list(int roleId){
		Result<List<Integer>> result = new Result<List<Integer>>();
		List<SysRoleResource> sysRoleResourceList = sysRoleResourceSupport.listByRoleId(roleId);
		List<Integer> resourceIdList = new ArrayList<Integer>();
		for (SysRoleResource sysRoleResource : sysRoleResourceList) {
			resourceIdList.add(sysRoleResource.getResourceId());
		}
		result.setDatas(resourceIdList);
		return result;
	}
	
}
