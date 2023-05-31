package com.learn.java8.parallel;

import java.time.Duration;
import java.time.Instant;
import java.util.OptionalLong;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Project: myJava8
 * File Created at 2022-02-12 18:25:18:25
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo.java
 * @Desc
 * @date 2022/2/12 18:25
 */
public class Demo {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1() {
        long start = System.currentTimeMillis();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0, 100000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        long end = System.currentTimeMillis();
        System.out.println("总耗时: " + (end - start) / 1000 + " (s)");
    }

    public static void test2() {
        // 并行流提高cpu使用率,在数据量庞大时比较有用
        Instant start = Instant.now();
        OptionalLong sum = LongStream.rangeClosed(0, 10000000000L).parallel().reduce(Long::sum);
        System.out.println(sum.getAsLong());
        Instant end = Instant.now();
        System.out.println("耗费总时间: "+ Duration.between(start,end).toMillis());

    }
}
