/**
 * Project Name:qbt-persistent
 * File Name:BagCodeUserServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年8月24日下午4:26:59
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodeUserDto;
import com.qbt.persistent.entity.BagCodeUser;
import com.qbt.persistent.mapper.BagCodeUserMapper;
import com.qbt.service.BagCodeUserService;

/**
 * ClassName:BagCodeUserServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月24日 下午4:26:59
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodeUserServiceImpl implements BagCodeUserService {
	
	@Resource
	private BagCodeUserMapper bagCodeUserMapper;
	
	@Override
	public int insert(BagCodeUser bagCodeUser) {
		bagCodeUserMapper.insert(bagCodeUser);
		return bagCodeUser.getId();
	}

	@Override
	public BagCodeUser selectById(Integer id) {
		return bagCodeUserMapper.selectById(id);
	}

	@Override
	public int updateById(BagCodeUser bagCodeUser) {
		return bagCodeUserMapper.updateById(bagCodeUser);
	}

	@Override
	public List<BagCodeUser> findByPage(PageEntity<BagCodeUserDto> pageEntity) {
		return bagCodeUserMapper.findByPage(pageEntity);
	}
	
	@Override
	public BagCodeUser findIsSenderRandom(String bagCode, String name, String mobile) {
		return bagCodeUserMapper.findIsSenderRandom(bagCode, name, mobile);
	}

	@Override
	public BagCodeUser findSenderRandom(String bagCode, String name, String moibile) {
		return bagCodeUserMapper.findSenderRandom(bagCode,name, moibile);
	}

}
