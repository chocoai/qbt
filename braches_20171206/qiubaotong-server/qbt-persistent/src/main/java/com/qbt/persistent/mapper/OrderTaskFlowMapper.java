package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrderTaskFlow;

public interface OrderTaskFlowMapper {
	
	int insert(OrderTaskFlow taskFlow);
	
	int deleteById(@Param("id")Integer id);
	
	List<OrderTaskFlow> findByType(@Param("type")Integer type);
	
	/**
	 * 删除x天前的数据
	 * @param day
	 * @return
	 */
	int deleteByDay(@Param("day")int day);
	
}
