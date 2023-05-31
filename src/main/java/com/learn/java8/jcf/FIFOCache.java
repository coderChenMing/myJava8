package com.learn.java8.jcf;

import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache<K, V> extends LinkedHashMap<K, V> {
    private final int cacheSize;

    public FIFOCache(int cacheSize) {
        this.cacheSize = cacheSize;
    }

    // 当Entry个数超过cacheSize时，删除最老的Entry
    // 该方法的作用是告诉Map是否要删除“最老”的Entry，
    // 所谓最老就是当前Map中最早插入的Entry，如果该方法返回`true`，
    // 最老的那个元素就会被删除。在每次插入新元素的之后LinkedHashMap会自动询问removeEldestEntry()是否要删除最老的元素。
    // 这样只需要在子类中重载该方法，当元素个数超过一定数量时让removeEldestEntry()返回true，就能够实现一个固定大小的FIFO策略的缓存。
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }

    public static void main(String[] args) {
        //test1();
        test2();

    }
    public static void test1() {
        FIFOCache<String, String> cache = new FIFOCache<>(2);
        cache.put("1", "张三");
        cache.put("2", "李四");
        cache.put("3", "王五");
        cache.put("4", "何六");
        cache.put("5", "崔七");
        System.out.println(cache);
        System.out.println(cache.size());
    }

    public static void test2() {
        FIFOCache<String, Integer> fifoCache = new FIFOCache<>(3);

        fifoCache.put("Bob",37);
        fifoCache.put("Tony",27);
        fifoCache.put("Aaron",23);
        System.out.println("fifoCache:");
        fifoCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );

        fifoCache.put("Cat", 3);
        System.out.println("add new entry fifoCache :");
        fifoCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );

        fifoCache.put("Aaron", 24);
        System.out.println("access \"Aaron\" , fifoCache :");
        fifoCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );

        fifoCache.get("Cat");
        fifoCache.put("David", 30);
        System.out.println("access \"Cat\", add new entry, fifoCache :");
        fifoCache.forEach( (k,v) -> System.out.println("K : " + k + " V : " + v ) );
    }
}
