package com.learn.java8.jcf;

import java.util.Comparator;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        //Collections.synchronizedList()
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "val");
        treeMap.put(2, "val");
        treeMap.put(1, "val");
        treeMap.put(5, "val");
        treeMap.put(4, "val");
        System.out.println(treeMap);// 默认按照key升序排列
        System.out.println("last key"+treeMap.lastKey());
        System.out.println("ceiling key 3 "+treeMap.ceilingKey(3));
        System.out.println(treeMap.subMap(2, 4));
        TreeMap<Integer, String> treeMap2 = new TreeMap<>(Comparator.reverseOrder());
        treeMap2.put(3, "val");
        treeMap2.put(2, "val");
        treeMap2.put(1, "val");
        treeMap2.put(5, "val");
        treeMap2.put(4, "val");
        System.out.println(treeMap2);// 按照key降序排列
    }
}
