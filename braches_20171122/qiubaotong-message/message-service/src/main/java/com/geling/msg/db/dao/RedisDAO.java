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

package com.geling.msg.db.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface RedisDAO {
	/**
	 * Put String into Redis
	 * 
	 * @param key
	 * @param value
	 */
	public void putString(String key, String value);
	
	/**
	 * Put List into Redis
	 * 
	 * @param key
	 * @param valueList
	 */
	public void putList(String key, List<String> valueList);
	
	/**
	 * Put Map into Redis
	 * 
	 * @param key
	 * @param valueMap
	 */
	public void putMap(String key, Map<String, String> valueMap);
	
	/**
	 * Put Set into Redis
	 * 
	 * @param key
	 * @param valueSet
	 */
	public void putSet(String key, Set<String> valueSet);
	
	/**
	 * Get String from Redis
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key);
	
	/**
	 * Get List from Redis
	 * 
	 * @param key
	 * @return
	 */
	public List<String> getList(String key);
	
	/**
	 * Return the specified elements of the list stored at the specified key.
	 * 0 is the first element of the list, 1 the next element and so on;
	 * -1 is the last element of the list, -2 the penultimate element and so on.
	 * 
	 * @param key
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<String> getListRange(String key, long begin, long end);
	
	/**
	 * Get Map from Redis
	 * 
	 * @param key
	 * @return
	 */
	public Map<String, String> getMap(String key);
	
	/**
	 * Get a field in map from Redis 
	 * 
	 * @param mapKey
	 * @param fieldKey
	 * @return
	 */
	public String getMapField(String mapKey, String fieldKey);
	
	/**
	 * Get Set from Redis
	 * 
	 * @param key
	 * @return
	 */
	public Set<String> getSet(String key);
	
	/**
	 * Publish message
	 * 
	 * @param channel
	 * @param message
	 * @return
	 */
	public long publish(String channel, String message);
	
	/**
	 * Add the string value to the tail of the list stored at key.
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public long rpush(String key, String value);
	
	/**
	 * Atomically return and remove the first element of the list.
	 * 
	 * @return
	 */
	public String lpop(String key);
	
	public String setex (String key,int seconds, String value);
	public Long del(String... keys);
	public Long setnx (String key, String value);
}
