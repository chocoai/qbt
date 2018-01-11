/**
 * Project Name:qbt-persistent
 * File Name:VipCreateServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年1月4日上午10:34:25
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipCreate;
import com.qbt.persistent.mapper.VipCreateMapper;
import com.qbt.service.VipCreateService;

/**
 * ClassName:VipCreateServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 上午10:34:25
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class VipCreateServiceImpl implements VipCreateService {
	
	@Resource
	private VipCreateMapper vipCreateMapper;
	
	@Override
	public int insert(VipCreate vipCreate) {
		vipCreateMapper.insert(vipCreate);
		return vipCreate.getId();
	}

	@Override
	public VipCreate findById(Integer id) {
		return vipCreateMapper.selectById(id);
	}

	@Override
	public int updateById(VipCreate vipCreate) {
		return vipCreateMapper.updateById(vipCreate);
	}

	@Override
	public List<VipCreate> findByPage(PageEntity<VipCreate> pageEntity) {
		return vipCreateMapper.findByPage(pageEntity);
	}

	@Override
	public int exist(String name) {
		return vipCreateMapper.exist(name);
	}

}
