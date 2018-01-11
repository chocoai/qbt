
 /**
 * @Title: RedisTest.java
 * @Package com.redis.test
 * @Description: TODO
 * Copyright:2016 qiubaotong All Rights Reserved   
 * Company:www.qiubaotong.com
 * 
 * @creater win10 2016年8月13日
 * @version V1.0
 **/

package com.redis.test;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

/**
  * @ClassName: RedisTest
  * @Description: TODO
  * @author win10 2016年8月13日
  * @modify win10 2016年8月13日
  */

public class RedisTest {
	 
	    public static void main(String args[]){  
	    	 Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
	          //Jedis Cluster will attempt to discover cluster nodes automatically
	          jedisClusterNodes.add(new HostAndPort("192.168.1.14", 8001));
	          jedisClusterNodes.add(new HostAndPort("192.168.1.14", 8002));
	          jedisClusterNodes.add(new HostAndPort("192.168.1.14", 8003));
	          jedisClusterNodes.add(new HostAndPort("192.168.1.14", 8004));
	          jedisClusterNodes.add(new HostAndPort("192.168.1.14", 8005));
	          jedisClusterNodes.add(new HostAndPort("192.168.1.14", 8006));
	          JedisCluster jc = new JedisCluster(jedisClusterNodes);
	          
	          String key = "page_view";
	          jc.del(key);
	          jc.incr(key);
	          String result = jc.get(key);
	          System.out.println(result);
	    }  


}


