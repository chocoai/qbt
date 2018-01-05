package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.persistent.entity.OrderShoppingCart;
import com.qbt.persistent.mapper.OrderShoppingCartMapper;
import com.qbt.service.OrderShoppingCartService;

/**
 *  清单购物车
  * @ClassName: OrderShoppingCartServiceImpl
  * @Description: TODO
  * @author share 2016年10月15日
  * @modify share 2016年10月15日
 */
@Service
public class OrderShoppingCartServiceImpl implements OrderShoppingCartService {

	@Resource
	private OrderShoppingCartMapper orderShoppingCartMapper;
	
	@Override
	public int insert(OrderShoppingCart record) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.insert(record);
	}

	@Override
	public OrderShoppingCart findById(Integer id) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.findById(id);
	}

	@Override
	public int updateById(OrderShoppingCart record) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.updateById(record);
	}

	@Override
	public List<OrderShoppingCart> findByUserId(int userId) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.findByUserId(userId);
	}

	@Override
	public int deleteByIds(int[] ids,int userId) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.deleteByIds(ids,userId);
	}

	@Override
	public Integer checkExists(int userId, String md5) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.checkExists(userId, md5);
	}

	@Override
	public int count(int userId) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.count(userId);
	}

	@Override
	public int updateQuantity(int userId,int id,int quantity) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.updateQuantity(userId,id,quantity);
	}

	@Override
	public void addQuantity(int id,int quantity) {
		// TODO Auto-generated method stub
		orderShoppingCartMapper.addQuantity(id,quantity);
	}
	
	@Override
	public List<OrderShoppingCart> findByIds(int userId,int[] ids) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.findByIds(userId,ids);
	}

	@Override
	public int count(int userId, int[] notInIds) {
		// TODO Auto-generated method stub
		return orderShoppingCartMapper.countNotIn(userId,notInIds);
	}


}
