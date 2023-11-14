package com.learn.java8.redis;

import redis.clients.jedis.Jedis;

public class TestVersion {
    public static void main(String[] args) {
        // 创建Jedis对象，连接Redis服务器
        Jedis jedis = new Jedis("10.4.123.133",6379);
        jedis.auth("123456");
        // 获取Redis服务器的信息
        String info = jedis.info();
        // 解析信息，查找redis_version字段
        String[] infoLines = info.split("\r\n");
        String redisVersion = null;

        for (String line : infoLines) {
            if (line.startsWith("redis_version:")) {
                redisVersion = line.substring("redis_version:".length());
                break;
            }
        }

        if (redisVersion != null) {
            System.out.println("Redis Version: " + redisVersion);
        } else {
            System.out.println("Redis Version not found in INFO response.");
        }
        jedis.close();
    }
}
