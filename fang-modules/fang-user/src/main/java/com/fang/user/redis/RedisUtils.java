package com.fang.user.redis;

import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * @author:fxm
 * @createTime:2021/9/23 16:20
 */
public class RedisUtils {
    private StringRedisTemplate stringRedisTemplate;
    private static JedisPool jedisPool;
    static {
        JedisPoolConfig jedisPoolconfig = new JedisPoolConfig();
        jedisPoolconfig.setMaxTotal(20);
        jedisPoolconfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolconfig ,"127.0.0.1",6379);

    }

    public static Jedis getJedis() throws Exception{
        if( null  != jedisPool ){
            return jedisPool.getResource();
        }
        throw  new Exception(" jedisPool is  not  ok ");
    }

}
