package com.learn.java8.base;

import java.util.Arrays;
import java.util.List;

public class ArraysTest {
    public static void main(String[] args) {
        System.out.println(getVictims("zhangsan,lisi"));
    }
    private static List<String> getVictims(String customerName) {
        String[] victimeArray = customerName.split(",");
        List<String> victims= Arrays.asList(victimeArray);
        return victims;
    }
}
