package com.qbt.persistent.mapper;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseSfPrice;

public interface BaseSfPriceMapper {
    int insert(BaseSfPrice sfPrice);

    BaseSfPrice findById(Integer id);

    int updateById(BaseSfPrice sfPrice);

    BaseSfPrice findByCityName(BaseSfPrice sfPrice);

	List<BaseSfPrice> findByPage(PageEntity<BaseSfPrice> pageEntity);

	void deleteById(Integer id);
	
	int insertSql(BaseSfPrice sfPrice);
	
	int updateSql(BaseSfPrice sfPrice);
	
	int whereSql(BaseSfPrice sfPrice);
}