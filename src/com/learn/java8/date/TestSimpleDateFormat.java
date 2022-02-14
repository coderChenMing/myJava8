package com.learn.java8.date;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Project: myJava8
 * File Created at 2022-02-12 22:29:22:29
 * {@link}
 * 线程安全问题展示
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestSimpleDateFormat.java
 * @Desc
 * @date 2022/2/12 22:29
 */
public class TestSimpleDateFormat {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //会有线程安全问题
        // 使用ThreadLocal解决线程安全问题
        Callable<Date> task = () -> TestThreadLocal.convert("20220212");
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<Date>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<Date> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
