package com.qbt.persistent.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qbt.persistent.entity.OrderShoppingCart;

public interface OrderShoppingCartMapper {
	  int insert(OrderShoppingCart record);

	  OrderShoppingCart findById(Integer id);

	  int updateById(OrderShoppingCart record);
	    
	  List<OrderShoppingCart> findByUserId(int userId);
	    
	  int deleteByIds(@Param("ids")int[] ids,@Param("userId")int userId);
	  
	  Integer checkExists(@Param("userId")int userId,@Param("md5")String md5);
	  
	  int count(int userId);
	  
	  int updateQuantity(@Param("userId")int userId,@Param("id")int id,@Param("quantity")int quantity);

	  int addQuantity(@Param("id")int id,@Param("quantity")int quantity);

	  List<OrderShoppingCart> findByIds(@Param("userId")int userId, @Param("ids")int[] ids);

	  int countNotIn(@Param("userId")int userId, @Param("ids")int[] notInIds);
	  
}