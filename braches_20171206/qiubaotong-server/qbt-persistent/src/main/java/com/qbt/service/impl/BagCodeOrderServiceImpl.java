/**
 * Project Name:qbt-persistent
 * File Name:BagCodeOrderServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年8月24日下午4:24:32
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodeOrderDto;
import com.qbt.persistent.entity.BagCodeOrder;
import com.qbt.persistent.mapper.BagCodeOrderMapper;
import com.qbt.service.BagCodeOrderService;

/**
 * ClassName:BagCodeOrderServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年8月24日 下午4:24:32
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BagCodeOrderServiceImpl implements BagCodeOrderService {
	
	@Resource
	private BagCodeOrderMapper bagCodeOrderMapper;
	
	@Override
	public int insert(BagCodeOrder bagCodeOrder) {
		bagCodeOrderMapper.insert(bagCodeOrder);
		return bagCodeOrder.getId();
	}

	@Override
	public BagCodeOrder selectById(Integer id) {
		return bagCodeOrderMapper.selectById(id);
	}

	@Override
	public int updateById(BagCodeOrder bagCodeOrder) {
		return bagCodeOrderMapper.updateById(bagCodeOrder);
	}

	@Override
	public List<BagCodeOrder> findByPage(PageEntity<BagCodeOrderDto> pageEntity) {
		return bagCodeOrderMapper.findByPage(pageEntity);
	}

	@Override
	public BagCodeOrder findByOrderId(int orderId) {
		return bagCodeOrderMapper.findByOrderId(orderId);
	}

}
