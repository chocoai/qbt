package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodePartnerDto;
import com.qbt.persistent.entity.BagCodePartner;

public interface BagCodePartnerMapper {
	
    int insert(BagCodePartner record);

    BagCodePartner selectById(Integer id);

    int updateById(BagCodePartner record);
    
    List<BagCodePartner> findByPage(PageEntity<BagCodePartnerDto> pageEntity);
    
    int exists(BagCodePartner record);

	BagCodePartner findByBagCode(String bagCode);

}