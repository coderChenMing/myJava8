package com.learn.java8.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class LinkedHashSetTest {
    public static void main(String[] args) {
        LinkedHashSet<String> set=new LinkedHashSet<>();
        set.add("222");
        set.add("333");
        set.add("444");
        set.add("222");
        set.add("555");
        System.out.println("set"+set);
        System.out.println("===============================");
        ArrayList<String> list = new ArrayList<>();
        list.addAll(set);
        set.clear();
        System.out.println("set"+ set);
        System.out.println("list"+list);
        list.clear();
        System.out.println(list);
    }
}
