package com.geling.msg.test;

import java.util.Map;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

public class RedisTest {

	public static void main(String[] args) {
		JedisPoolConfig poolConfig = null;
		JedisPool pool = null;
		Jedis resource = null;
		Map<String, String> userMap = null;
		
		poolConfig = new JedisPoolConfig();
		pool = new JedisPool(poolConfig, "192.168.177.128", 6379,
				Protocol.DEFAULT_TIMEOUT, "123456", Protocol.DEFAULT_DATABASE,
				"Message Service");
		resource = pool.getResource();
		
//		Builder builder = new Builder();
		
		//String
		resource.set("hello", "redis");
		resource.set("key1", "value1");
		System.out.println(resource.get("a"));
		
		//List
//		resource.lpush("list", "l1", "l2", "l3");
//		resource.lrange("list", 0, -1);
		
		//Map
//		userMap = new HashMap<String, String>();
//		userMap.put("user", "abu");
//		userMap.put("password", "abu");
//		resource.hmset("user", userMap);
//		resource.hkeys("user");
//		resource.hvals("user");
//		resource.hmget("user", "user", "password");
		
		//Set
//		resource.sadd("set", "s1", "s2", "s3");
//		resource.scard("set");
//		resource.smembers("set");
		
//		resource.save();
		
		pool.returnResource(resource);
		pool.destroy();
		pool.close();
	}

}
