package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.dto.BossBaseBrand;
import com.qbt.persistent.entity.BaseBrand;

public interface BaseBrandService {
	
	int insert(BaseBrand baseBrand);

    BaseBrand selectById(Integer id);

    int updateById(BaseBrand baseBrand);
    
    int deleteById(Integer id);
    
    List<BossBaseBrand> findByPage(PageEntity<BossBaseBrand> pageEntity);
	
    int isExist(String bagNo, String rfidNo);
    
}
