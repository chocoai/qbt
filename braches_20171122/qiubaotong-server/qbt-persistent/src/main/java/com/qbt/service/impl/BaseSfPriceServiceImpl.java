package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseSfPrice;
import com.qbt.persistent.mapper.BaseSfPriceMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseSfPriceService;

/*
 *  顺丰价格表
  * @ClassName: BaseSfPriceServiceImpl
  * @Description: TODO
  * @author share 2016年8月11日
  * @modify share 2016年8月11日
 */
@Service
public class BaseSfPriceServiceImpl implements BaseSfPriceService {

	@Resource
	private RedisService redisService;
	@Resource
	private BaseSfPriceMapper baseSfPriceMapper;
	
	
	/**
	 *  添加
	  * @Title: insert
	  * @Description: TODO
	  * @author: share 2016年8月11日
	  * @modify: share 2016年8月11日
	  * @param sfPrice
	  * @return
	  * @see com.qbt.service.BaseSfPriceService#insert(com.qbt.persistent.entity.BaseSfPrice)
	 */
	@Override
	public int insert(BaseSfPrice sfPrice) {
		baseSfPriceMapper.insert(sfPrice);
		// redis
		sfPricesRedisSave(sfPrice);
		return sfPrice.getId();
	}

	/**
	 *  更新
	  * @Title: update
	  * @Description: TODO
	  * @author: share 2016年8月11日
	  * @modify: share 2016年8月11日
	  * @param sfPrice
	  * @return
	  * @see com.qbt.service.BaseSfPriceService#update(com.qbt.persistent.entity.BaseSfPrice)
	 */
	@Override
	public int update(BaseSfPrice sfPrice) {
		int result = baseSfPriceMapper.updateById(sfPrice);
		sfPrice = baseSfPriceMapper.findById(sfPrice.getId());
		// redis
		sfPricesRedisSave(sfPrice);
		return result;
	}
	
	/**
	 *  根据城市名称获取顺丰价格
	  * @Title: findByCityName
	  * @Description: TODO
	  * @author: share 2016年8月11日
	  * @modify: share 2016年8月11日
	  * @param sfPrice
	  * @return
	  * @see com.qbt.service.BaseSfPriceService#findByCityName(com.qbt.persistent.entity.BaseSfPrice)
	 */
	@Override
	public BaseSfPrice findByCityName(BaseSfPrice sfPrice) {
		String startCity = sfPrice.getStartProvince()+sfPrice.getStartCity();
		String endCity = sfPrice.getEndProvince()+sfPrice.getEndCity();
		BaseSfPrice price = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.sf_price_key(startCity,endCity)), BaseSfPrice.class);
		if(price == null){
			price = baseSfPriceMapper.findByCityName(sfPrice);
			if(price != null){
				startCity = sfPrice.getStartProvince()+sfPrice.getStartCity();
				endCity = sfPrice.getEndProvince()+sfPrice.getEndCity();
				redisService.putMap(RedisKeyUtil.sf_price_key(startCity,endCity), RedisUtil.hashsMap(price));
			}
		}
		return price;
	}
	
	
	private void sfPricesRedisSave(BaseSfPrice sfPrice) {
		String[] startCitys = sfPrice.getStartCity().split(",");
		for(String citys : startCitys){
			String startCityName = sfPrice.getStartProvince()+citys;
			String[] endCitys = sfPrice.getEndCity().split(",");
			for(String endCity : endCitys){
				String endCityName = sfPrice.getEndProvince()+endCity;
				redisService.putMap(RedisKeyUtil.sf_price_key(startCityName,endCityName), RedisUtil.hashsMap(sfPrice));
			}
		}
	}

	@Override
	public List<BaseSfPrice> findByPage(PageEntity<BaseSfPrice> pageEntity) {
		return baseSfPriceMapper.findByPage(pageEntity);
	}

	@Override
	public void deleteById(Integer id) {
		baseSfPriceMapper.deleteById(id);
	}

	@Override
	public BaseSfPrice findById(Integer id) {
		return baseSfPriceMapper.findById(id);
	}

}
