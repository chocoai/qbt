package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.dto.OrderPageDto;
import com.qbt.persistent.entity.Orders;

public interface OrdersMapper {
    int insert(Orders record);

    Orders findById(Integer id);

    int updateById(Orders order);

	Orders findByNumber(String number);

	List<Orders> findByUserIdForWeiXin(OrderPageDto pageDto);

	List<Orders> queryPartnerOrder(OrderPageDto pageDto);

	int updateSubNumber(@Param("number")String number, @Param("orderId")Integer orderId);

	void updateUserId(@Param("id")int id,@Param("userId") int userId,@Param("openId")String openId);
	
	int updateByProxUserId(@Param("id")Integer id, @Param("proxySelfUserId")Integer proxySelfUserId);

}