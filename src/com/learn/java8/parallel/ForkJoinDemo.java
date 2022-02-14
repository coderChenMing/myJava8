package com.learn.java8.parallel;

import java.util.concurrent.RecursiveTask;

/**
 * Project: myJava8
 * File Created at 2022-02-12 18:32:18:32
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ForkJoinDemo.java
 * @Desc
 * @date 2022/2/12 18:32
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private static final long serialVersionUID = 134656970987L;
    private long start;
    private long end;

    private static final long THRESHOLD = 10000L;

    public ForkJoinDemo() {
    }

    public ForkJoinDemo(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD) {
            long sum = 0;

            for (long i = start; i < end; i++) {
                sum += i;
            }
            return sum;
        } else {
            long middle = (start + end) / 2;
            ForkJoinDemo left = new ForkJoinDemo(start, middle);
            left.fork();// 拆分子任务,同时压入线程队列
            ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
            right.fork();
            return left.join() + right.join();
        }
    }
}
