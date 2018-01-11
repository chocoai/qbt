package com.qbt.redis.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qbt.common.logback.LogCvt;
import com.qbt.redis.RedisService;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * 
 * @ClassName: RedisManager
 * @author FQ
 * @date 2015年3月12日 下午12:00:24
 *
 */
@Service
public class RedisManager implements RedisService{
	
	@Resource
	private JedisPool jedisPool;
	
	/**
	 * 获取Redis实例
	 * @return
	 * Jedis
	 * 
	 * @author: FQ
	 * @date:2015年3月12日 下午1:03:37
	 */
	public Jedis getJedis() {
		if (jedisPool != null) {
			return jedisPool.getResource();
		}
		return null;
	}
	
	/**
	 * 释放redis实例到连接池
	 * @param jedis
	 * void
	 * 
	 * @author: FQ
	 * @date:2015年3月12日 下午1:03:47
	 */
	public void returnJedis(Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

	public String putString(String key, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.set(key, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return "0";
		} finally {
			returnJedis(jedis);
		}
	}
	
	public String putMset(Set<String> keys, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();// 获得jedis实例
			for(String set : keys)
			{
				return jedis.mset(set,value);
			}
			return "1";
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return "0";
		} finally {
			returnJedis(jedis);
		}
	}
	

	public String putExpire(String key, String value, int seconds) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.setex(key, seconds, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	
	public String getString(String key) {
		Jedis jedis = null;
		String value = null;
		try {
			jedis = getJedis();// 获得jedis实例
			value = jedis.get(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return value;
	}

	public String putMap(String key, Map<String, String> valueMap) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			res = jedis.hmset(key, valueMap);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}

	public Map<String, String> getMap(String key) {
		Jedis jedis = null;
		Map<String, String> res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			res = jedis.hgetAll(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}

	public Long putSet(String key, Set<String> valueSet) {
		Jedis jedis = null;
		Long res = null;
		try {
			String[] members = null;
			members = new String[valueSet.size()];
			valueSet.toArray(members);

			jedis = getJedis();// 获得jedis实例
			res = jedis.sadd(key, members);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	public Long putSet(String key, String... members) {
		Jedis jedis = null;
		Long res = null;
		try {		

			jedis = getJedis();// 获得jedis实例
			res = jedis.sadd(key, members);
		} catch (Exception e) {
			
			res = -1l;
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}

	public Long scard(String key) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			res = jedis.scard(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}

	public Boolean sismember(String key, String member) {
		Jedis jedis = null;
		Boolean res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			res = jedis.sismember(key, member);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	public Set<String> getSet(String key) {
		Jedis jedis = null;
		Set<String> res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			res = jedis.smembers(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}

	public Boolean exists(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.exists(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return false;
		} finally {
			returnJedis(jedis);
		}
	}

	public Long putList(String key, List<String> valueList) {
		Jedis jedis = null;
		Long res = null;
		try {
			String[] strings = null;
			strings = new String[valueList.size()];
			valueList.toArray(strings);

			jedis = getJedis();// 获得jedis实例
			res = jedis.rpush(key, strings);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	/**
	 * 删除区间之外的值
	 * @param key
	 * @param valueList
	 * @return 
	 */
	public String ltrim (String key, long start, long end) {
		Jedis jedis = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.ltrim (key, start, end);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return "error";
		} finally {
			returnJedis(jedis);
		}
	}
	
	 /**
	  * @Title: lrem
	  * @Description: 删除count个key的list中值为value的元素
	  * @param key
	  * @param count
	  * @param value
	  * @return 
	 */
	public Long lrem(String key, int count, String value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.lrem(key, count, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return (long) 9999;
		} finally {
			returnJedis(jedis);
		}
	}

	public List<String> getList(String key) {
		Jedis jedis = null;
		List<String> res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			res = jedis.hvals(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	public Long del(String... keys) {
		Jedis jedis = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.del(keys);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return 0L;
		} finally {
			returnJedis(jedis);
		}
	}
	
	/**
	 * Get field value from redis hash
	 * 
	 * @param mapKey
	 * @param fieldKey
	 * @return
	 */
	public String getMapValue(String mapKey, String fieldKey){
		
		return this.hget(mapKey, fieldKey);
	}
	
	/**
	 * Get field value from redis hash
	 * 
	 * @param mapKey
	 * @param fieldKey
	 * @return
	 */
	public String hget(String key, String field){
		Jedis jedis = null;
		String value = null;
		
		try {
			jedis = getJedis();// 获得jedis实例
			value = jedis.hget(key, field);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		
		return value;
	}
	
	/**
	 * Set field value for redis hash
	 * 
	 * @param mapKey
	 * @param fieldKey
	 * @return
	 */
	public Long hset(String key, String field, String value){
		Jedis jedis = null;
		Long result = null;
		
		try {
			jedis = getJedis();// 获得jedis实例
			result = jedis.hset(key, field, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	public Long incr(String key, Long max){
		Jedis jedis = null;
		Long value = -1l;
		
		try {
			jedis = getJedis();
			value = jedis.incr(key);
			if(value > max){
				jedis.set(key, "" + max);
				value = max;
			}
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return value;
	}

	@Override
	public Long srem(String key, String... values) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.srem(key, values);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return 0l;
		} finally {
			returnJedis(jedis);
		}
	}
	
	public Long hincrBy(String key, String field, Long value) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.hincrBy(key, field, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return 0l;
		} finally {
			returnJedis(jedis);
		}
	}
	
	/**
	 * 将 key中储存的数字值加increment
	 * @param key
	 * @param value
	 * @return
	 */
	public Long incrBy(String key, Long increment) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.incrBy(key, increment);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			returnJedis(jedis);
		}
	}
	
	/**
	 * 将 key中储存的数字值减value
	 * @param key
	 * @param value
	 * @return
	 */
	public Long decrBy(String key, Long value){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.decrBy(key,value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			returnJedis(jedis);
		}
	}
	
	/**
	 * 
	 * @Title: zadd 
	 * @author vania
	 * @version 1.0
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 * @return Long    返回类型 
	 * @throws
	 */
	public Long zadd(String key, double score, String member) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			System.out.print(jedis.type(key));
			return jedis.zadd(key, score, member);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			returnJedis(jedis);
		}
		
	}
	
	/**
	 * 
	 * @Title: zrem 
	 * @author vania
	 * @version 1.0
	 * @param key
	 * @param member
	 * @return
	 * @return Long    返回类型 
	 * @throws
	 */
	public Long zrem(String key, String member) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.zrem(key, member);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			returnJedis(jedis);
		}
		
	}
	
	
	public List<String> hmget(String key,String... fields){
		Jedis jedis = null;
		List<String> value = null;
		try {
			jedis = getJedis();// 获得jedis实例
			value = jedis.hmget(key, fields);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		
		return value;
	}
	
	public Long hdel (String key,String... fields){
		Jedis jedis = null;
		Long result = null;
		try {
			jedis = getJedis();
			result = jedis.hdel(key, fields);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result= -1l;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	public Set<String> keys (String pattern) {
		Jedis jedis = null;
		Set<String> result = null;
		try {
			jedis = getJedis();
			result = jedis.keys(pattern);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result= null;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	public Long lpush(String key, String... values){
		Jedis jedis = null;
		Long result = 0l;
		try {
			jedis = getJedis();
			result = jedis.lpush(key, values);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result= 0l;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	public Long rpush(String key, String... values){
		Jedis jedis = null;
		Long result = 0l;
		try {
			jedis = getJedis();
			result = jedis.rpush(key, values);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result= 0l;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	public List<String> lrange(String key, long start, long end) {
		Jedis jedis = null;
		List<String> result = null;
		try {
			jedis = getJedis();
			result = jedis.lrange(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = null;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	public Long llen(String key) {
		Jedis jedis = null;
		Long result = 0l;
		try {
			jedis = getJedis();
			result = jedis.llen(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = 0l;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}
	
	public Long expire (String key, int seconds) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.expire(key, seconds);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	public Long expireAt(String key, long unixTime) {
		Jedis jedis = null;
		Long res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.expireAt(key, unixTime);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	public Long setnx (String key, String value) {
		Jedis jedis = null;
		Long res = 0l;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.setnx(key, value);
		} catch (Exception e) {
			res = 0l;
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	public String setex (String key,int seconds, String value) {
		Jedis jedis = null;
		String res = null;
		try {
			jedis = getJedis();// 获得jedis实例
			return jedis.setex(key,seconds, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		//接口参考地址：  http://www.tuicool.com/articles/ieAvAzz
		
		RedisManager r=new RedisManager();
		//System.out.println(r.putString("name", "String"));
		
		System.out.println(r.del("name"));
	}

	@Override
	public Integer getPageQueryTotalCount(String md5PageKey) {
		Jedis jedis = null;
		Integer totalCount = 0;
		
		try {
			jedis = getJedis();// 获得jedis实例
			
			if (null != jedis.get(md5PageKey)){
				totalCount = Integer.valueOf(jedis.get(md5PageKey));
			}
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		
		return totalCount;
	}


	@Override
	public Long incr(String key) {
		Jedis jedis = null;
		Long value = -1l;
		
		try {
			jedis = getJedis();
			value = jedis.incr(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return value;
	}

	@Override
	public String get(String key) {
		Jedis jedis = null;
		String value = "";
		
		try {
			jedis = getJedis();
			value = jedis.get(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return value;
	}

	@Override
	public String set(String key,String value) {
		Jedis jedis = null;
		String result = "";
		try {
			jedis = getJedis();
			result = jedis.set(key, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			returnJedis(jedis);
		}
		return result;
	}

	/**
	 * 返回名称为key的zset（元素已按score从大到小排序）中的index从start到end的所有元素
	 */
    @Override
    public Set<String> zRange(String key, long start, long end) {
        // TODO Auto-generated method stub
        Jedis jedis = null;
        Set<String> result = null;
        try {
            jedis = getJedis();
            result = jedis.zrange(key, start, end);
        } catch (Exception e) {
            
            LogCvt.error(e.getMessage(), e);
            result = null;
        } finally {
            returnJedis(jedis);
        }
        return result;
    }

    /**
     * 返回名称为key的zset的所有元素的个数
     */
    @Override
    public Long zinterstore(String dstkey, String... sets) {
        // TODO Auto-generated method stub
        Jedis jedis = null;
        Long result = 0L;
        try {
            jedis = getJedis();
            result = jedis.zinterstore(dstkey, sets);
        } catch (Exception e) {
            
            LogCvt.error(e.getMessage(), e);
            result = 0L;
        } finally {
            returnJedis(jedis);
        }
        return result;
    }
    
    /**
     * 
     * zremrangebyscore:(移除score值介于start和end之间（等于）的成员).
     *
     * @author wangyan
     * 2015-8-13 下午2:57:27
     * @param key
     * @param start
     * @param end
     * @return 被移除成员的数量
     *
     */
	public Long zremrangebyscore(String key, double start, double end) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			returnJedis(jedis);
		}
		
	}
	
	/**
	 * Redis读取阻塞队列BRPOP
	 * @param timeout
	 * @param key
	 * @return
	 */
	public List<String> brpop(int timeout,String key){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.brpop(timeout,key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			returnJedis(jedis);
		}
	}
	
	
	/**
	 * Redis读取阻塞队列BRPOP
	 * @param timeout
	 * @param key
	 * @return
	 */
	public String rpop(String key){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.rpop(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			returnJedis(jedis);
		}
	}
	
	public List<String> blpop(int timeout,String key){
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.blpop(timeout,key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			returnJedis(jedis);
		}
	}
	

	/**
	 * 返回名称为key的zset(按score从大到小排序)中的index从start到end的所有元素
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	@Override
	public Set<String> zrevrange(String key, long start, long end) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.zrevrange(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			returnJedis(jedis);
		}
	}

	/**
	 * 返回给定元素对应的score
	 * @param key
	 * @param member
	 * @return
	 */
	@Override
	public Double zscore(String key, String member) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.zscore(key, member);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			returnJedis(jedis);
		}
	}

	/**
	 * 返回集合中score在给定区间的元素
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 */
	@Override
	public Set<String> zrangeByScore(String key, double min, double max) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.zrangeByScore(key, min, max);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			returnJedis(jedis);
		}
	}

	@Override
	public Long zcard(String key) {
		Jedis jedis = null;
		Long result = 0l;
		try {
			jedis = getJedis();
			result = jedis.zcard(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = 0l;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}

	@Override
	public Long zremrangeByScore(String key, double start, double end) {
		Jedis jedis = null;
		Long result = 0l;
		try {
			jedis = getJedis();
			result = jedis.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = 0l;
		} finally {
			returnJedis(jedis);
		}
		return result;
	}

	@Override
	public void setPageQueryTotalCount(String md5PageKey, Integer count) {
		
	}

	@Override
	public String lpop(String key) {
		Jedis jedis = null;
		try {
			jedis = getJedis();
			return jedis.lpop(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			returnJedis(jedis);
		}
	}
	

}
