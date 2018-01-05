package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodeOrderDto;
import com.qbt.persistent.entity.BagCodeOrder;

public interface BagCodeOrderService {
	
    int insert(BagCodeOrder bagCodeOrder);

    BagCodeOrder selectById(Integer id);

    int updateById(BagCodeOrder bagCodeOrder);
    
    List<BagCodeOrder> findByPage(PageEntity<BagCodeOrderDto> pageEntity);

	BagCodeOrder findByOrderId(int orderId);

}