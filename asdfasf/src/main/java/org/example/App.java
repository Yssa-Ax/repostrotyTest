package org.example;

import org.example.utils.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        Jedis jedis = new Jedis("192.168.139.129",6379);
        JedisPool jedisPool = RedisUtils.open("192.168.139.129",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB();
        jedis.set("ads","ads");
        String ads = jedis.get("ads");
        System.out.println(ads);
        System.out.println("=============");
        Map<String ,String> map = new HashMap<>();
        map.put("id","10001");
        map.put("name","李四");
        jedis.hmset("student",map);
        List<String> hmget = jedis.hmget("student","id","name");
        System.out.println(hmget);
        jedisPool.close();

    }
}
