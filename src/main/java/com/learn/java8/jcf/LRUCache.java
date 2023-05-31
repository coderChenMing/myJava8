package com.learn.java8.jcf;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;  // 缓存容量

    public LRUCache(int cacheSize) {
        super(16, 0.75f, true);
        this.cacheSize = cacheSize;
    }

    /**
     * 超过Cache容量即会移除最近最少被使用的元素
     *
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > cacheSize;
    }

    public static void main(String[] args) {
        // 建立一个容量为3基于LRU算法的缓存Map
        LRUCache<String, Integer> lruCache = new LRUCache<>(3);

        lruCache.put("Bob",37);
        lruCache.put("Tony",27);
        lruCache.put("Aaron",23);
        System.out.println("LRU Cache:");
        lruCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );

        lruCache.put("Cat", 3);
        System.out.println("add new entry LRU Cache:");
        lruCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );

        lruCache.put("Aaron", 24);
        System.out.println("access \"Aaron\" , LRU Cache:");
        lruCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );

        lruCache.get("Cat");
        lruCache.put("David", 30);
        System.out.println("access \"Cat\", add new entry, LRU Cache:");
        lruCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );
    }
}