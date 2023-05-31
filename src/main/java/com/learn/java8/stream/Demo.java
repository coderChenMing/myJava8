package com.learn.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Project: myJava8
 * File Created at 2022-02-12 11:07:11:07
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo.java
 * @Desc
 * @date 2022/2/12 11:07
 */
public class Demo {
    public static void main(String[] args) {
        // 使用Collection实现类创建Stream
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        // 使用Arrays.stream()
        int[] intArray = new int[10];
        IntStream stream1 = Arrays.stream(intArray);
        // 使用Stream的静态方法
        Stream<String> stringStream = Stream.of("aa", "bb", "cc");
        // 创建无限流
        // 迭代
        Stream<Integer> iterate = Stream.iterate(0, s -> s + 2);
        // iterate.limit(10).forEach(System.out::println);
        // generate
        Stream<Integer> generate = Stream.generate(() -> 1);
        generate.limit(2).forEach(System.out::println);
    }
}
