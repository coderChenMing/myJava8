package com.learn.java8.arrayRef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Project: myJava8
 * File Created at 2022-12-22 15:43:15:43
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestRepeat.java
 * @Description
 * @date 2022/12/22 15:43
 */
public class TestRepeat {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("abc");
        list.add("bcd");
        list.add("bcd");
        list.add("efg");
        list.add("ghi");
        list.add("hij");
        System.out.println(list);
        Set<String> set = new HashSet<>();
        set.addAll(list);
        System.out.println(set);
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String s2 : set) {
            for (String s1 : list) {
                if (s1.equals(s2)) {
                    count++;
                }
            }
            map.put(s2, count);
            count=0;
        }
        System.out.println(map);

    }
}
