package com.learn.java8.arrayRef;

import java.util.function.Function;

/**
 * Project: myJava8
 * File Created at 2022-02-12 01:03:1:03
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Desc
 * @date 2022/2/12 1:03
 */
public class Test {
    public static void main(String[] args) {
        Function<Integer, int[]> function = (x) -> new int[x];
        System.out.println(function.apply(10).length);

        Function<Integer, String[]> function1 = String[]::new;
        System.out.println(function1.apply(10).length);
    }
}
