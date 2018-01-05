/**
 * Project Name:qbt-persistent
 * File Name:OrgGroupUserServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年8月1日下午2:43:36
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.OrgGroupUserDto;
import com.qbt.persistent.entity.OrgGroupUser;
import com.qbt.persistent.mapper.OrgGroupUserMapper;
import com.qbt.service.OrgGroupUserService;

/**
 * ClassName:OrgGroupUserServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月1日 下午2:43:36
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class OrgGroupUserServiceImpl implements OrgGroupUserService {
	
	@Resource
	private OrgGroupUserMapper orgGroupUserMapper;
	
	@Override
	public int insert(OrgGroupUser orgGroupUser) {
		orgGroupUserMapper.insert(orgGroupUser);
		return orgGroupUser.getId();
	}

	@Override
	public OrgGroupUser selectById(Integer id) {
		return orgGroupUserMapper.selectById(id);
	}

	@Override
	public int updateById(OrgGroupUser orgGroupUser) {
		return orgGroupUserMapper.updateById(orgGroupUser);
	}

	@Override
	public List<OrgGroupUser> findByPage(PageEntity<OrgGroupUserDto> pageEntity) {
		return orgGroupUserMapper.findByPage(pageEntity);
	}

	@Override
	public int deleteByBatch(List<Integer> ids) {
		return orgGroupUserMapper.deleteByBatch(ids);
	}

	@Override
	public int insertByBatch(List<OrgGroupUser> users) {
		return orgGroupUserMapper.insertByBatch(users);
	}

	@Override
	public int exists(OrgGroupUser orgGroupUser) {
		return orgGroupUserMapper.exists(orgGroupUser);
	}

	@Override
	public int deleteByOrgId(Integer orgId) {
		return orgGroupUserMapper.deleteByOrgId(orgId);
	}

	@Override
	public OrgGroupUser findByNameAndMobile(String name, String mobile) {
		return orgGroupUserMapper.findByNameAndMobile(name, mobile);
	}

}
