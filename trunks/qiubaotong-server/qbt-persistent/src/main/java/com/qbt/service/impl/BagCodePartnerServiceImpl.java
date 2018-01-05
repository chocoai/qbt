/**
 * Project Name:qbt-persistent
 * File Name:BagCodePartnerServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年8月24日下午4:25:50
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodePartnerDto;
import com.qbt.persistent.entity.BagCodePartner;
import com.qbt.persistent.mapper.BagCodePartnerMapper;
import com.qbt.service.BagCodePartnerService;

/**
 * ClassName:BagCodePartnerServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月24日 下午4:25:50
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodePartnerServiceImpl implements BagCodePartnerService {
	
	@Resource
	private BagCodePartnerMapper bagCodePartnerMapper;
	
	@Override
	public int insert(BagCodePartner bagCodePartner) {
		bagCodePartnerMapper.insert(bagCodePartner);
		return bagCodePartner.getId();
	}

	@Override
	public BagCodePartner selectById(Integer id) {
		return bagCodePartnerMapper.selectById(id);
	}

	@Override
	public int updateById(BagCodePartner bagCodePartner) {
		return bagCodePartnerMapper.updateById(bagCodePartner);
	}

	@Override
	public List<BagCodePartner> findByPage(PageEntity<BagCodePartnerDto> pageEntity) {
		return bagCodePartnerMapper.findByPage(pageEntity);
	}

	@Override
	public int exists(BagCodePartner bagCodePartner) {
		return bagCodePartnerMapper.exists(bagCodePartner);
	}
	
	@Override
	public BagCodePartner findByBagCode(String bagCode) {
		return bagCodePartnerMapper.findByBagCode(bagCode);
	}

}
