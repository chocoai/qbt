package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodeOrderDto;
import com.qbt.persistent.entity.BagCodeOrder;

public interface BagCodeOrderMapper {
	
    int insert(BagCodeOrder record);

    BagCodeOrder selectById(Integer id);

    int updateById(BagCodeOrder record);
    
    List<BagCodeOrder> findByPage(PageEntity<BagCodeOrderDto> pageEntity);

	BagCodeOrder findByOrderId(int orderId);
}