/**
 * Project Name:qbt-persistent
 * File Name:VipCreateInfoServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年1月4日上午10:59:20
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipCreateInfo;
import com.qbt.persistent.mapper.VipCreateInfoMapper;
import com.qbt.service.VipCreateInfoService;

/**
 * ClassName:VipCreateInfoServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年1月4日 上午10:59:20
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class VipCreateInfoServiceImpl implements VipCreateInfoService {
	
	@Resource
	private VipCreateInfoMapper vipCreateInfoMapper;
	
	@Override
	public int insert(VipCreateInfo vipCreateInfo) {
		vipCreateInfoMapper.insert(vipCreateInfo);
		return vipCreateInfo.getId();
	}

	@Override
	public VipCreateInfo findById(Integer id) {
		return vipCreateInfoMapper.selectById(id);
	}

	@Override
	public int updateById(VipCreateInfo vipCreateInfo) {
		return vipCreateInfoMapper.updateById(vipCreateInfo);
	}

	@Override
	public int insertBatch(List<VipCreateInfo> infos) {
		return vipCreateInfoMapper.insertBatch(infos);
	}

	@Override
	public List<VipCreateInfo> findByPage(PageEntity<VipCreateInfo> pageEntity) {
		return vipCreateInfoMapper.findByPage(pageEntity);
	}

	@Override
	public VipCreateInfo findByVipNo(String vipNo, String random) {
		return vipCreateInfoMapper.findByVipNo(vipNo,random);
	}

	@Override
	public int updateActivate(String vipNo, String random,int activateMethod) {
		return vipCreateInfoMapper.updateActivate(vipNo,random,activateMethod);
	}

	@Override
	public int updateBatch(VipCreateInfo vipCreateInfo) {
		return vipCreateInfoMapper.updateBatch(vipCreateInfo);
	}

	@Override
	public List<VipCreateInfo> findByIds(List<Integer> ids) {
		return vipCreateInfoMapper.selectByIds(ids);
	}

	@Override
	public List<String> findAllVipNo() {
		return vipCreateInfoMapper.findAllVipNo();
	}
	
}
