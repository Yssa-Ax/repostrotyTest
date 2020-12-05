package org.example;

import org.example.utils.RedisUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.util.List;

public class jedisTest2 {
    public static void main(String[] args) {
        JedisPool jedisPool = RedisUtils.open("192.168.139.129",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.flushDB();
        //开启事务
        Transaction multi = jedis.multi();
        multi.set("str1","aaaa");
        multi.set("str2","2222");

        //提交事务
        List<Object> list = multi.exec();
        System.out.println(list);
        jedisPool.close();

    }
}
