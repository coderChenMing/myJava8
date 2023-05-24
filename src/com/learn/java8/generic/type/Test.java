package com.learn.java8.generic.type;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList list1 = new ArrayList<String>();
        list1.add(1);
        list1.add("2");
        ArrayList<String> list2 = new ArrayList<>();
        //list2.add(1);
        list2.add("2");
    }
}
