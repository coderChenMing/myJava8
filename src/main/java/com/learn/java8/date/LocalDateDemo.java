package com.learn.java8.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Project: myJava8
 * File Created at 2022-02-12 22:47:22:47
 * {@link}
 * LocalDate每次都会产生新实例,所以不会有线程安全问题
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type LocalDateDemo.java
 * @Desc
 * @date 2022/2/12 22:47
 */
public class LocalDateDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        Callable<LocalDate> task = () -> LocalDate.parse("20220212", dtf);
        ExecutorService pool = Executors.newFixedThreadPool(10);
        List<Future<LocalDate>> results = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }
        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }
}
