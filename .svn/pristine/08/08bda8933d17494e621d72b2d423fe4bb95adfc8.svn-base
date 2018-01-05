package com.qbt.web.support.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.persistent.entity.SysPlat;
import com.qbt.persistent.entity.SysRole;
import com.qbt.persistent.entity.SysRoleResource;
import com.qbt.persistent.entity.SysUserRole;
import com.qbt.service.SysPlatService;
import com.qbt.service.SysResourceService;
import com.qbt.service.SysRoleResourceService;
import com.qbt.service.SysRoleService;
import com.qbt.service.SysUserRoleService;
import com.qbt.web.pojo.sysRole.AdminSysRoleVO;
import com.qbt.web.pojo.sysRole.SysRolePageReqVo;
import com.qbt.web.support.AdminSysRoleSupport;

@Service
public class AdminSysRoleSupportImpl implements AdminSysRoleSupport{

	@Resource
	private SysRoleService sysRoleService;
	@Resource
	private SysRoleResourceService sysRoleResourceService;
	@Resource
	private SysUserRoleService sysUserRoleService;
	@Resource
	private SysPlatService sysPlatService;
	@Resource
	private SysResourceService sysResourceService; 
	
	@Override
	public List<AdminSysRoleVO> list() {
		List<SysRole> sysRoleList = sysRoleService.list();
		List<AdminSysRoleVO> adminSysRoleVOList = new ArrayList<AdminSysRoleVO>();
		for (SysRole sysRole : sysRoleList) {
			AdminSysRoleVO adminSysRoleVO = BeanUtil.a2b(sysRole, AdminSysRoleVO.class);
			List<SysRoleResource> sysRoleResourceList =  sysRoleResourceService.listById(sysRole.getId());
			List<Integer> resourceIdList = new ArrayList<Integer>();
			for (SysRoleResource sysRoleResource : sysRoleResourceList) {
				resourceIdList.add(sysRoleResource.getResourceId());
			}
			adminSysRoleVO.setResourceIdList(resourceIdList);
			adminSysRoleVOList.add(adminSysRoleVO);
		}
		return adminSysRoleVOList;
	}

	@Override
	public void insert(AdminSysRoleVO adminSysRoleVO) throws BusinessException{
		SysRole condition = new SysRole();
		condition.setName(adminSysRoleVO.getName());
		List<SysRole> qryList = sysRoleService.findByCondition(condition);
		if(Checker.isNotEmpty(qryList)){
			throw new BusinessException("角色名称已被使用");
		}
		SysRole sysRole = BeanUtil.a2b(adminSysRoleVO, SysRole.class);
		SysPlat sysPlat = sysPlatService.get(sysRole.getPlatId());
		sysRole.setPlatName(sysPlat.getName());
		sysRoleService.insert(sysRole);
		
		List<Integer> resourceIdList = adminSysRoleVO.getResourceIdList();
		for (Integer resourceId : resourceIdList) {
			SysRoleResource sysRoleResource = new SysRoleResource(); 
			sysRoleResource.setResourceId(resourceId);
			sysRoleResource.setRoleId(sysRole.getId());
			sysRoleResourceService.insert(sysRoleResource);
		}
	}

	@Override
	public void delete(Integer id) {
		sysRoleService.delete(id);
		sysRoleResourceService.deleteByRoleId(id);
	}

	@Override
	public void update(AdminSysRoleVO vo) {
		SysRole sysRole = BeanUtil.a2b(vo, SysRole.class);
		SysPlat sysPlat = sysPlatService.get(vo.getPlatId());
		sysRole.setPlatName(sysPlat.getName());
		sysRoleResourceService.deleteByRoleId(vo.getId());
		sysRoleService.update(sysRole);
		List<Integer> resourceIdList = vo.getResourceIdList();
		for (Integer resourceId : resourceIdList) {
			SysRoleResource sysRoleResource = new SysRoleResource(); 
			sysRoleResource.setResourceId(resourceId);
			sysRoleResource.setRoleId(sysRole.getId());
			sysRoleResourceService.insert(sysRoleResource);
		}
		
		
	}

	@Override
	public List<AdminSysRoleVO> findByPage(SysRolePageReqVo reqVo) {
		PageEntity<SysRole> pageEntity = BeanUtil.pageConvert(reqVo, SysRole.class);
		
		List<SysRole> list = sysRoleService.findByPage(pageEntity);
		List<AdminSysRoleVO> voList = BeanUtil.list2list(list, AdminSysRoleVO.class);
		
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}

	@Override
	public List<SysUserRole> sysUserRolelistByUserId(Integer userId) {
		return sysUserRoleService.findListBySysUserId(userId);
	}

	@Override
	public List<SysRole> sysRolelistByUserId(Integer platId, int userId) {
		List<SysUserRole> sysUserRoleList = sysUserRoleService.sysRolelistByUserId(platId,userId);
		List<SysRole> sysRoleList = new ArrayList<SysRole>();
		for (SysUserRole sysUserRole : sysUserRoleList) {
			SysRole sysRole = sysRoleService.get(sysUserRole.getRoleId());
			sysRoleList.add(sysRole);
		}
		
		return sysRoleList;
	}

}
