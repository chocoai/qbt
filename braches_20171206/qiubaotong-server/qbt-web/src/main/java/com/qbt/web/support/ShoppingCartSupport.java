package com.qbt.web.support;

import java.util.List;

import com.qbt.web.pojo.order.OrderConfirm;
import com.qbt.web.pojo.shoppingCart.CartRequest;
import com.qbt.web.pojo.shoppingCart.ShoppingCart;

public interface ShoppingCartSupport {

	public void addShoppingCart(OrderConfirm orderInfo);

	public List<ShoppingCart> getShoppingCart(int id);

	public void update(CartRequest req);

	public void delete(CartRequest req);

	public Integer count(Integer userId);
	
}
