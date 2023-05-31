package com.learn.java8.jcf;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Bob", 37);
        linkedHashMap.put("Tony", 27);
        linkedHashMap.put("Aaron", 23);

        System.out.println("------------ Before Access ------------");
        linkedHashMap.forEach((k, v) -> System.out.println("K : " + k + " V : " + v));

        linkedHashMap.put("Tony", 23);
        System.out.println("------------ Access \"Tony\" ------------");
        linkedHashMap.forEach((k, v) -> System.out.println("K : " + k + " V : " + v));

        linkedHashMap.get("Bob");
        System.out.println("------------ Access \"Bob\" ------------");
        linkedHashMap.forEach((k, v) -> System.out.println("K : " + k + " V : " + v));
    }
}
