package com.learn.java8.juc;

public class TestWhile {
    private static long count = 0;

    private static void add10K() {
        int idx = 0;
        while (idx++ < 1) {
            count += 1;
            System.out.println("执行循环");
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        add10K();
    }
}
