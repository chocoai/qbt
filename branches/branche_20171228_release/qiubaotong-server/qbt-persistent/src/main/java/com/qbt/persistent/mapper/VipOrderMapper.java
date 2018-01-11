package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.common.entity.PageEntity;
import com.qbt.persistent.entity.VipOrder;

public interface VipOrderMapper {
	
    int insert(VipOrder vipOrder);

    VipOrder selectById(@Param("id")Integer id);

    int updateById(VipOrder vipOrder);

	List<VipOrder> findByPage(PageEntity<VipOrder> pageEntity);

	VipOrder selectByNumber(@Param("number")String number);
	
	int updateByNumbers(VipOrder vipOrder);
	
	int insertBatch(@Param("vipOrders")List<VipOrder> vipOrders);

	int updateByNumber(VipOrder vipOrder);
}