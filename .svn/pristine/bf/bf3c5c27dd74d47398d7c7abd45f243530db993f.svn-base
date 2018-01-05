package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodePartnerDto;
import com.qbt.persistent.entity.BagCodePartner;

public interface BagCodePartnerService {
	
    int insert(BagCodePartner bagCodePartner);

    BagCodePartner selectById(Integer id);

    int updateById(BagCodePartner bagCodePartner);
    
    List<BagCodePartner> findByPage(PageEntity<BagCodePartnerDto> pageEntity);
    
    int exists(BagCodePartner bagCodePartner);

	BagCodePartner findByBagCode(String bagCode);
	
}