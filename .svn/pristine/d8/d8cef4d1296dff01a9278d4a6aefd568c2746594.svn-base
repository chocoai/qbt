package com.qbt.service;

import java.util.List;


import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.OutRangeAddress;

public interface OutRangeAddressService {

	List<OutRangeAddress> findByPage(PageEntity<OutRangeAddress> pageEntity);

	void insert(OutRangeAddress outRangeAddress);
	
	OutRangeAddress findByAreaId(Integer areaId, String adress);
	
	

	OutRangeAddress findById(Integer id);

	void deleteById(Integer id);

	void updateById(OutRangeAddress outRangeAddress);

	List<OutRangeAddress> findByCondition(OutRangeAddress condition);

}
