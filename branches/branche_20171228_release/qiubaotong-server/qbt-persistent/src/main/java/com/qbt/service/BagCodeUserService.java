package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodeUserDto;
import com.qbt.persistent.entity.BagCodeUser;

public interface BagCodeUserService {
	
    int insert(BagCodeUser bagCodeUser);

    BagCodeUser selectById(Integer id);

    int updateById(BagCodeUser bagCodeUser);
    
    List<BagCodeUser> findByPage(PageEntity<BagCodeUserDto> pageEntity);

	BagCodeUser findIsSenderRandom(String bagCode, String name, String mobile);

	BagCodeUser findSenderRandom(String bagCode, String name, String moibile);
}