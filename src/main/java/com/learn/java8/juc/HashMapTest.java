package com.learn.java8.juc;

import java.util.HashMap;

public class HashMapTest {
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
    public static void main(String[] args) {
        //System.out.println(tableSizeFor(2));
        HashMap<String, String> testMap = new HashMap<>(2, 2);
        testMap.put("test1", "val");
        testMap.put("test2", "val");
        testMap.put("test3", "val");
        System.out.println(testMap);
    }
}
