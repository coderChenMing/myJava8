package com.learn.java8.stream.exercise;

import com.learn.java8.stream.AbstractDemo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project: myJava8
 * File Created at 2022-02-12 18:10:18:10
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/12 18:10
 */
public class Test extends AbstractDemo {

    public static void main(String[] args) {
        // test1();
        test2();
    }

    public static void test1() {
        // 给定一个列表返回列表值平方后的列表
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareList = list.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("原数据列表: "+list);
        System.out.println("平方列表: "+squareList);
    }

    public static void test2() {
        // 怎样使用map和reduce数一数 employees流中employee个数
        Integer count = employees.stream().map(e -> 1).reduce(0, Integer::sum);
        System.out.println("元素个数: "+count);
    }
}
