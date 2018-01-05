package com.qbt.service;

import java.util.List;

import com.qbt.persistent.entity.OrderShoppingCart;

public interface OrderShoppingCartService {

	  int insert(OrderShoppingCart record);

	  OrderShoppingCart findById(Integer id);

	  int updateById(OrderShoppingCart record);
	    
	  List<OrderShoppingCart> findByUserId(int userId);
	  
	  List<OrderShoppingCart> findByIds(int userId,int[] ids);
	    
	  int deleteByIds(int[] ids,int userId);
	  
	  Integer checkExists(int userId,String md5);
	  
	  int count(int userId);
	  
	  int updateQuantity(int userId,int id,int quantity);

	  void addQuantity(int cartId,int quantity);

	  int count(int userId, int[] notInIds);
	  
	  
}
