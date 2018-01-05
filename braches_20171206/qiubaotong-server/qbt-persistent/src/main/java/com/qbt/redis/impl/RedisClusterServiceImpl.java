package com.qbt.redis.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import com.qbt.common.logback.LogCvt;
import com.qbt.redis.RedisService;

import redis.clients.jedis.JedisCluster;

/**
 * 
 * @ClassName: RedisManager
 * @author FQ
 * @date 2015年3月12日 下午12:00:24
 *
 */
//@Service("redisClusterService")
public class RedisClusterServiceImpl implements RedisService{
	
	@Resource
	private JedisCluster jedisCluster;
	

	public String putString(String key, String value) {
		
		try {
		
			return jedisCluster.set(key, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return "0";
		} finally {
			
		}
	}
	
	public String putExpire(String key, String value, int seconds) {
		
		String res = null;
		try {
		
			return jedisCluster.setex(key, seconds, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	
	public String getString(String key) {
		
		String value = null;
		try {
		
			value = jedisCluster.get(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return value;
	}

	public String putMap(String key, Map<String, String> valueMap) {
		
		String res = null;
		try {
		
			res = jedisCluster.hmset(key, valueMap);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}

	public Map<String, String> getMap(String key) {
		
		Map<String, String> res = null;
		try {
		
			res = jedisCluster.hgetAll(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}

	public Long putSet(String key, Set<String> valueSet) {
		
		Long res = null;
		try {
			String[] members = null;
			members = new String[valueSet.size()];
			valueSet.toArray(members);

		
			res = jedisCluster.sadd(key, members);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	public Long putSet(String key, String... members) {
		
		Long res = null;
		try {		

		
			res = jedisCluster.sadd(key, members);
		} catch (Exception e) {
			
			res = -1l;
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}

	public Long scard(String key) {
		
		Long res = null;
		try {
		
			res = jedisCluster.scard(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}

	public Boolean sismember(String key, String member) {
		
		Boolean res = null;
		try {
		
			res = jedisCluster.sismember(key, member);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	public Set<String> getSet(String key) {
		
		Set<String> res = null;
		try {
		
			res = jedisCluster.smembers(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}

	public Boolean exists(String key) {
		
		try {
		
			return jedisCluster.exists(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return false;
		} finally {
			
		}
	}

	public Long putList(String key, List<String> valueList) {
		
		Long res = null;
		try {
			String[] strings = null;
			strings = new String[valueList.size()];
			valueList.toArray(strings);

		
			res = jedisCluster.rpush(key, strings);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
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
		
		try {
		
			return jedisCluster.ltrim (key, start, end);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return "error";
		} finally {
			
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
		
		try {
		
			return jedisCluster.lrem(key, count, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return (long) 9999;
		} finally {
			
		}
	}

	public List<String> getList(String key) {
		
		List<String> res = null;
		try {
		
			res = jedisCluster.hvals(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	public Long del(String... keys) {
		
		try {
			for(String key : keys){
				jedisCluster.del(key);
			}
			return 1l;
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return 0L;
		} finally {
			
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
		
		String value = null;
		
		try {
		
			value = jedisCluster.hget(key, field);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
		} finally {
			
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
		
		Long result = null;
		
		try {
		
			result = jedisCluster.hset(key, field, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return result;
	}
	
	public Long incr(String key, Long max){
		
		Long value = -1l;
		
		try {
			
			value = jedisCluster.incr(key);
			if(value > max){
				jedisCluster.set(key, "0");
				value = 0l;
			}
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return value;
	}

	@Override
	public Long srem(String key, String... values) {
		
		try {
			
			return jedisCluster.srem(key, values);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return 0l;
		} finally {
			
		}
	}
	
	public Long hincrBy(String key, String field, Long value) {
		
		try {
			
			return jedisCluster.hincrBy(key, field, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return 0l;
		} finally {
			
		}
	}
	
	/**
	 * 将 key中储存的数字值加increment
	 * @param key
	 * @param value
	 * @return
	 */
	public Long incrBy(String key, Long increment) {
		
		try {
			
			return jedisCluster.incrBy(key, increment);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			
		}
	}
	
	/**
	 * 将 key中储存的数字值减value
	 * @param key
	 * @param value
	 * @return
	 */
	public Long decrBy(String key, Long value){
		
		try {
			
			return jedisCluster.decrBy(key,value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			
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
		
		try {
			
			System.out.print(jedisCluster.type(key));
			return jedisCluster.zadd(key, score, member);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			
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
		
		try {
			
			return jedisCluster.zrem(key, member);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			
		}
		
	}
	
	
	public List<String> hmget(String key,String... fields){
		
		List<String> value = null;
		try {
		
			value = jedisCluster.hmget(key, fields);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		
		return value;
	}
	
	public Long hdel (String key,String... fields){
		
		Long result = null;
		try {
			
			result = jedisCluster.hdel(key, fields);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result= -1l;
		} finally {
			
		}
		return result;
	}
	
	
	public Long lpush(String key, String... values){
		
		Long result = 0l;
		try {
			
			result = jedisCluster.lpush(key, values);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result= 0l;
		} finally {
			
		}
		return result;
	}
	
	public Long rpush(String key, String... values){
		
		Long result = 0l;
		try {
			
			result = jedisCluster.rpush(key, values);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result= 0l;
		} finally {
			
		}
		return result;
	}
	
	public List<String> lrange(String key, long start, long end) {
		
		List<String> result = null;
		try {
			
			result = jedisCluster.lrange(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = null;
		} finally {
			
		}
		return result;
	}
	
	public Long llen(String key) {
		
		Long result = 0l;
		try {
			
			result = jedisCluster.llen(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = 0l;
		} finally {
			
		}
		return result;
	}
	
	public Long expire (String key, int seconds) {
		
		Long res = null;
		try {
		
			return jedisCluster.expire(key, seconds);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	public Long expireAt(String key, long unixTime) {
		
		Long res = null;
		try {
		
			return jedisCluster.expireAt(key, unixTime);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	public Long setnx (String key, String value) {
		
		Long res = 0l;
		try {
		
			return jedisCluster.setnx(key, value);
		} catch (Exception e) {
			res = 0l;
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	public String setex (String key,int seconds, String value) {
		
		String res = null;
		try {
		
			return jedisCluster.setex(key,seconds, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		//接口参考地址：  http://www.tuicool.com/articles/ieAvAzz
		
		RedisClusterServiceImpl r=new RedisClusterServiceImpl();
		//System.out.println(r.putString("name", "String"));
		
		System.out.println(r.del("name"));
	}

	@Override
	public Integer getPageQueryTotalCount(String md5PageKey) {
		
		Integer totalCount = 0;
		
		try {
		
			
			if (null != jedisCluster.get(md5PageKey)){
				totalCount = Integer.valueOf(jedisCluster.get(md5PageKey));
			}
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		
		return totalCount;
	}


	@Override
	public Long incr(String key) {
		
		Long value = -1l;
		
		try {
			
			value = jedisCluster.incr(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return value;
	}

	@Override
	public String get(String key) {
		
		String value = "";
		
		try {
			
			value = jedisCluster.get(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return value;
	}

	@Override
	public String set(String key,String value) {
		
		String result = "";
		try {
			
			result = jedisCluster.set(key, value);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
		} finally {
			
		}
		return result;
	}

	/**
	 * 返回名称为key的zset（元素已按score从大到小排序）中的index从start到end的所有元素
	 */
    @Override
    public Set<String> zRange(String key, long start, long end) {
        // TODO Auto-generated method stub
        
        Set<String> result = null;
        try {
            
            result = jedisCluster.zrange(key, start, end);
        } catch (Exception e) {
            
            LogCvt.error(e.getMessage(), e);
            result = null;
        } finally {
            
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
		
		try {
			
			return jedisCluster.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return -1l;
		} finally {
			
		}
		
	}
	
	/**
	 * Redis读取阻塞队列BRPOP
	 * @param timeout
	 * @param key
	 * @return
	 */
	public List<String> brpop(int timeout,String key){
		
		try {
			
			return jedisCluster.brpop(timeout,key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			
		}
	}
	
	
	/**
	 * Redis读取阻塞队列BRPOP
	 * @param timeout
	 * @param key
	 * @return
	 */
	public String rpop(String key){
		
		try {
			
			return jedisCluster.rpop(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			
		}
	}
	
	public List<String> blpop(int timeout,String key){
		
		try {
			
			return jedisCluster.blpop(timeout,key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			
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
		
		try {
			
			return jedisCluster.zrevrange(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			
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
		
		try {
			
			return jedisCluster.zscore(key, member);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			
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
		
		try {
			
			return jedisCluster.zrangeByScore(key, min, max);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			
		}
	}

	@Override
	public Long zcard(String key) {
		
		Long result = 0l;
		try {
			
			result = jedisCluster.zcard(key);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = 0l;
		} finally {
			
		}
		return result;
	}

	@Override
	public Long zremrangeByScore(String key, double start, double end) {
		
		Long result = 0l;
		try {
			
			result = jedisCluster.zremrangeByScore(key, start, end);
		} catch (Exception e) {
			
			LogCvt.error(e.getMessage(), e);
			result = 0l;
		} finally {
			
		}
		return result;
	}

	@Override
	public void setPageQueryTotalCount(String md5PageKey, Integer count) {
		
	}

	@Override
	public Set<String> keys(String pattern) {
		return null;
	}

	@Override
	public Long zinterstore(String dstkey, String... sets) {
		return null;
	}

	@Override
	public String lpop(String key) {
		try {
			
			return jedisCluster.lpop(key);
		} catch (Exception e) {
			LogCvt.error(e.getMessage(), e);
			return null;
		} finally {
			
		}
	}
	

}
