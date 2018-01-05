/**
 * Amendment History
 * 
 * 	Amended   By		: 
 * 	Amendment Date		: 
 *  Amendment Label		: 
 * 	Amendment Details	: 
 * 	
 * 
 * @author F-road
 * 
 * Copyright 2008-2015 F-ROAD Commercial Services Co.,Ltd. All rights reserved.
 *
 */

package com.geling.msg.db.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.geling.msg.db.dao.RedisDAO;

import redis.clients.jedis.Jedis;

public class RedisDAOImpl implements RedisDAO {

	/**
	 * Redis connection factory
	 */
	private JedisConnectionFactory redisConnectionFactory = null;
	
	public void putString(String key, String value) {
		Jedis redis = null;
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		redis.set(key, value);
		try {
			redis.close();
		} catch (Exception e){
		}
	}

	public void putList(String key, List<String> valueList) {
		String[] strings = null;
		Jedis redis = null;
		
		strings = new String[valueList.size()];
		valueList.toArray(strings);
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		redis.rpush(key, strings);
		try {
			redis.close();
		} catch (Exception e){
		}
	}

	public void putMap(String key, Map<String, String> valueMap) {
		Jedis redis = null;
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		redis.hmset(key, valueMap);
		try {
			redis.close();
		} catch (Exception e){
		}
	}

	public void putSet(String key, Set<String> valueSet) {
		String[] members = null;
		Jedis redis = null;
		
		members = new String[valueSet.size()];
		valueSet.toArray(members);
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		redis.sadd(key, members);
		try {
			redis.close();
		} catch (Exception e){
		}
	}

	public String getString(String key) {
		String resultStr = null;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		resultStr = redis.get(key);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return resultStr;
	}

	public List<String> getList(String key) {
		List<String> resultList = null;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		resultList = getListRange(key, 0, -1);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return resultList;
	}

	public List<String> getListRange(String key, long begin, long end) {
		List<String> resultList = null;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		resultList = redis.lrange(key, begin, end);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return resultList;
	}

	public Map<String, String> getMap(String key) {
		Map<String, String> resultMap = null;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		resultMap = redis.hgetAll(key);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return resultMap;
	}

	public String getMapField(String mapKey, String fieldKey) {
		String resultStr = null;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		resultStr = redis.hmget(mapKey, fieldKey).get(0);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return resultStr;
	}

	public Set<String> getSet(String key) {
		Set<String> resultSet = null;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		resultSet = redis.smembers(key);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return resultSet;
	}

	public long publish(String channel, String message) {
		long result = 0l;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		
		result = redis.publish(channel, message);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return result;
	}

	public long rpush(String key, String value) {
		long result = 0l;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		
		result = redis.rpush(key, value);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return result;
	}

	public String lpop(String key) {
		String resultStr = null;
		Jedis redis = null;
		
		redis = redisConnectionFactory.getConnection().getNativeConnection();
		
		resultStr = redis.lpop(key);
		try {
			redis.close();
		} catch (Exception e){
		}
		
		return resultStr;
	}

	public Long setnx (String key, String value) {
		Jedis jedis = null;
		Long res = 0l;
		jedis = redisConnectionFactory.getConnection().getNativeConnection();
		res = jedis.setnx(key, value);
		
		try {
			jedis.close();
		} catch (Exception e) {
		}
		
		return res;
	}
	
	
	public Long del(String... keys) {
		Jedis jedis = null;
		Long res = 0l;
		jedis = redisConnectionFactory.getConnection().getNativeConnection();
		
		res =  jedis.del(keys);
		try {
			jedis.close();
		} catch (Exception e) {
		}
		
		return res;
	}
	
	public String setex (String key,int seconds, String value) {
		Jedis jedis = null;
		String res = null;
		jedis = redisConnectionFactory.getConnection().getNativeConnection();
		res = jedis.setex(key,seconds, value);
		try {
			jedis.close();
		} catch (Exception e) {
		}
		return res;
	}
	
	/**
	 * @return the redisConnectionFactory
	 */
	public JedisConnectionFactory getRedisConnectionFactory() {
		return redisConnectionFactory;
	}

	/**
	 * @param redisConnectionFactory the redisConnectionFactory to set
	 */
	public void setRedisConnectionFactory(
			JedisConnectionFactory redisConnectionFactory) {
		this.redisConnectionFactory = redisConnectionFactory;
	}
	
	
	
}
