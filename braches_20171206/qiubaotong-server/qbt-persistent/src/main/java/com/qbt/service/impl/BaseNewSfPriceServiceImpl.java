/**
 * Project Name:qbt-persistent
 * File Name:BaseNewSfPriceServiceImpl.java
 * Package Name:com.qbt.service.impl
 * Date:2017年6月6日下午3:07:17
 *
*/

package com.qbt.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.entity.PageEntity;
import com.qbt.common.util.RedisKeyUtil;
import com.qbt.common.util.RedisUtil;
import com.qbt.persistent.entity.BaseNewSfPrice;
import com.qbt.persistent.mapper.BaseNewSfPriceMapper;
import com.qbt.redis.RedisService;
import com.qbt.service.BaseNewSfPriceService;

/**
 * ClassName:BaseNewSfPriceServiceImpl
 * Reason:	 TODO ADD REASON.
 * Date:     2017年6月6日 下午3:07:17
 * @author   huangyihao
 * @version  
 * @see 	 
 */
@Service
public class BaseNewSfPriceServiceImpl implements BaseNewSfPriceService {
	
	@Resource
	private BaseNewSfPriceMapper baseNewSfPriceMapper;
	
	@Resource
	private RedisService redisService;
	
	@Override
	public int insert(BaseNewSfPrice sfPrice) {
		baseNewSfPriceMapper.insert(sfPrice);
		sfPricesRedisSave(sfPrice);
		return sfPrice.getId();
	}

	@Override
	public int update(BaseNewSfPrice price) {
		int result = baseNewSfPriceMapper.updateById(price);
		BaseNewSfPrice sfPrice = this.findById(price.getId());
		sfPricesRedisSave(sfPrice);
		return result;
	}

	@Override
	public BaseNewSfPrice findById(Integer id) {
		return baseNewSfPriceMapper.selectById(id);
	}

	@Override
	public BaseNewSfPrice findByArea(String startArea, String endArea) {
		BaseNewSfPrice price = RedisUtil.getByRedis(redisService.getMap(RedisKeyUtil.new_sf_price_key(startArea, endArea)), BaseNewSfPrice.class);
		if(price == null){
			price = baseNewSfPriceMapper.findByArea(startArea, endArea);
			if(price != null){
				sfPricesRedisSave(price);
			}
		}
		return price;
	}
	
	private void sfPricesRedisSave(BaseNewSfPrice sfPrice) {
		redisService.putMap(RedisKeyUtil.new_sf_price_key(sfPrice.getStartArea(), sfPrice.getEndArea()), RedisUtil.hashsMap(sfPrice));
	}

	@Override
	public List<BaseNewSfPrice> findByPage(PageEntity<BaseNewSfPrice> pageEntity) {
		return baseNewSfPriceMapper.findByPage(pageEntity);
	}

	@Override
	public void delete(Integer id) {
		BaseNewSfPrice sfPrice = findById(id);
		redisService.del(RedisKeyUtil.new_sf_price_key(sfPrice.getStartArea(), sfPrice.getEndArea()));
		baseNewSfPriceMapper.delete(id);
	}

}
