package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BagCodeUserDto;
import com.qbt.persistent.entity.BagCodeUser;

public interface BagCodeUserMapper {
	
    int insert(BagCodeUser record);

    BagCodeUser selectById(Integer id);

    int updateById(BagCodeUser record);
    
    List<BagCodeUser> findByPage(PageEntity<BagCodeUserDto> pageEntity);

	BagCodeUser findIsSenderRandom(@Param("bagCode")String bagCode, @Param("name")String name, @Param("mobile")String mobile);

	BagCodeUser findSenderRandom(@Param("bagCode")String bagCode, @Param("name")String name, @Param("mobile")String moibile);
}