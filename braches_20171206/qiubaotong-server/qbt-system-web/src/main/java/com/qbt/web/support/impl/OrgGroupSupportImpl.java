/**
 * Project Name:qbt-system-web
 * File Name:OrgGroupSupportImpl.java
 * Package Name:com.qbt.web.support.impl
 * Date:2017年8月1日下午6:01:05
 *
*/

package com.qbt.web.support.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.exception.BusinessException;
import com.qbt.common.util.BeanUtil;
import com.qbt.common.util.Checker;
import com.qbt.common.util.DateUtil;
import com.qbt.persistent.entity.OrgGroup;
import com.qbt.persistent.entity.OrgGroupAmountConfig;
import com.qbt.persistent.entity.SysUser;
import com.qbt.service.OrgGroupAmountConfigService;
import com.qbt.service.OrgGroupService;
import com.qbt.service.OrgGroupUserService;
import com.qbt.web.pojo.orgGroup.OrgGroupAmountConfigVo;
import com.qbt.web.pojo.orgGroup.OrgGroupDetailVo;
import com.qbt.web.pojo.orgGroup.OrgGroupPageReq;
import com.qbt.web.pojo.orgGroup.OrgGroupVo;
import com.qbt.web.support.OrgGroupSupport;

/**
 * ClassName:OrgGroupSupportImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午6:01:05
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrgGroupSupportImpl implements OrgGroupSupport {
	
	@Resource
	private OrgGroupService orgGroupService;
	
	@Resource
	private OrgGroupAmountConfigService orgGroupAmountConfigService;
	
	@Resource
	private OrgGroupUserService orgGroupUserService;
	
	@Override
	public List<OrgGroupVo> findByPage(OrgGroupPageReq reqVo) {
		PageEntity<OrgGroup> pageEntity = BeanUtil.pageConvert(reqVo, OrgGroup.class);
		List<OrgGroup> list = orgGroupService.findByPage(pageEntity);
		List<OrgGroupVo> voList = BeanUtil.list2list(list, OrgGroupVo.class);
		reqVo.setTotalCount(pageEntity.getTotalCount());
		return voList;
	}
	
	
	
	@Override
	public List<OrgGroupVo> list() {
		List<OrgGroup> list = orgGroupService.list();
		List<OrgGroupVo> voList = BeanUtil.list2list(list, OrgGroupVo.class);
		return voList;
	}



	@Override
	public int add(OrgGroupDetailVo vo, SysUser sysUser) {
		OrgGroup orgGroup = BeanUtil.a2b(vo, OrgGroup.class);
		int existCount = orgGroupService.exists(orgGroup);
		if(existCount > 0) {
			throw new BusinessException("机构名称已存在");
		}
		orgGroup.setOperatorId(sysUser.getId());
		orgGroup.setOperatorName(sysUser.getName());
		int result = orgGroupService.insert(orgGroup);
		if(Checker.isNotEmpty(vo.getAmountConfigs())) {
			List<OrgGroupAmountConfig> configs = BeanUtil.list2list(vo.getAmountConfigs(), OrgGroupAmountConfig.class);
			for(OrgGroupAmountConfig c : configs) {
				c.setOrgId(orgGroup.getId());
				c.setType(1);
			}
			orgGroupAmountConfigService.insertByBatch(configs);
		}
		return result;
	}

	@Override
	public boolean update(OrgGroupDetailVo vo, SysUser sysUser) {
		OrgGroup orgGroup = BeanUtil.a2b(vo, OrgGroup.class);
		int existCount = orgGroupService.exists(orgGroup);
		if(existCount > 0) {
			throw new BusinessException("机构名称已存在");
		}
		orgGroup.setOperatorId(sysUser.getId());
		orgGroup.setOperatorName(sysUser.getName());
		int result = orgGroupService.updateById(orgGroup);
		if(Checker.isNotEmpty(vo.getAmountConfigs())) {
			orgGroupAmountConfigService.deleteByOrgId(vo.getId());
			List<OrgGroupAmountConfig> configs = BeanUtil.list2list(vo.getAmountConfigs(), OrgGroupAmountConfig.class);
			for(OrgGroupAmountConfig c : configs) {
				c.setOrgId(vo.getId());
				c.setType(1);
			}
			orgGroupAmountConfigService.insertByBatch(configs);
		}
		return result > 0;
	}

	@Override
	public boolean delete(Integer id) {
		int result1 = orgGroupService.deleteById(id);
		int result2 = orgGroupAmountConfigService.deleteByOrgId(id);
		int result3 = orgGroupUserService.deleteByOrgId(id);
		return result1 + result2 + result3 > 0;
	}

	@Override
	public OrgGroupDetailVo detail(Integer id) {
		OrgGroup orgGroup = orgGroupService.selectById(id);
		OrgGroupDetailVo vo = BeanUtil.a2b(orgGroup, OrgGroupDetailVo.class);
		if(Checker.isNotEmpty(vo)) {
			vo.setStartDateStr(DateUtil.formatDate(vo.getStartDate(), DateUtil.DATE_FORMAT_01));
			vo.setEndDateStr(DateUtil.formatDate(vo.getEndDate(), DateUtil.DATE_FORMAT_01));
			List<OrgGroupAmountConfig> configs = orgGroupAmountConfigService.selectByOrgId(id);
			vo.setAmountConfigs(BeanUtil.list2list(configs, OrgGroupAmountConfigVo.class));
		}
		return vo;
	}

}
