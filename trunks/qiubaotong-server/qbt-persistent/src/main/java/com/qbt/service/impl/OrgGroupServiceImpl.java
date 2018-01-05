/**
 * Project Name:qbt-persistent
 * File Name:OrgGroupServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年8月1日下午2:41:24
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OrgGroup;
import com.qbt.persistent.mapper.OrgGroupMapper;
import com.qbt.service.OrgGroupService;

/**
 * ClassName:OrgGroupServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午2:41:24
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrgGroupServiceImpl implements OrgGroupService {
	
	@Resource
	private OrgGroupMapper orgGroupMapper;
	
	@Override
	public int insert(OrgGroup orgGroup) {
		orgGroupMapper.insert(orgGroup);
		return orgGroup.getId();
	}

	@Override
	public OrgGroup selectById(Integer id) {
		return orgGroupMapper.selectById(id);
	}

	@Override
	public int updateById(OrgGroup orgGroup) {
		return orgGroupMapper.updateById(orgGroup);
	}

	@Override
	public List<OrgGroup> findByPage(PageEntity<OrgGroup> pageEntity) {
		return orgGroupMapper.findByPage(pageEntity);
	}

	@Override
	public int exists(OrgGroup orgGroup) {
		return orgGroupMapper.exists(orgGroup);
	}

	@Override
	public int deleteById(Integer id) {
		return orgGroupMapper.deleteById(id);
	}

	@Override
	public List<OrgGroup> list() {
		return orgGroupMapper.list();
	}
	
}
