package com.qbt.service;

import java.util.List;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.BaseAirport;

public interface BaseAirportService {
	
	public List<BaseAirport> findList();
	
	public BaseAirport findById(int id);
	
	public int insert(BaseAirport baseAirport);
	
	public int update(BaseAirport baseAirport);
	
	public List<BaseAirport> findByPage(PageEntity<BaseAirport> pageEntity);
	
	public List<BaseAirport> findByCondition(BaseAirport baseAirport);
	
	public int deleteById(Integer id);

	public List<BaseAirport> list();

	public int delete(Integer id, Boolean isDelete);

}
