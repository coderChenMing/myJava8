package com.learn.java8.jcf;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 可对单个Key进行过期的HashMap
 * 实现Map接口，具体存储的逻辑委派给内部的HashMap
 *
 * @since 1.0
 */
public class ExpireTimeHashMap<K, V> extends HashMap<K, V> {
    /**
     * 具体存储缓存数据的容器
     */
    private Map<K,V> map = new HashMap<>();
    /**
     * 过期时间记录
     */
    private final Map<String, Date>  expireRecord ;


    public ExpireTimeHashMap(Map<String, Date> expireRecord) {
        this.expireRecord = expireRecord;
    }
    //原文链接：https://blog.csdn.net/qq_41354631/article/details/122922285
    @Override
    public V get(Object key) {
        Date date = expireRecord.get(key);
        // 未记录过期时间就返回map.getKey
        if(date == null){
            return map.get(key);
        }
        // 命中缓存后 返回缓存数据
        if (new Date().before(date)){
            System.out.printf("key:%s,命中缓存",key);
            return map.get(key);
        }else {
            //  数据过期移除数据存储和过期记录存储
            expireRecord.remove(key);
            map.remove(key);
            return null;
        }
    }
}
