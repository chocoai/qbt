package com.qbt.web.support;

import java.util.List;

import com.qbt.common.exception.BusinessException;
import com.qbt.web.pojo.airport.AirportPageReqVo;
import com.qbt.web.pojo.airport.BaseAirportVo;

public interface AirportSupport {
	
	List<BaseAirportVo> findByPage(AirportPageReqVo reqVo);
	
	BaseAirportVo findById(Integer id);
	
	int add(BaseAirportVo vo) throws BusinessException;
	
	boolean update(BaseAirportVo vo) throws BusinessException;
	
	boolean delete(Integer id);

	Boolean deleteById(Integer id, Boolean isDelete);
}
