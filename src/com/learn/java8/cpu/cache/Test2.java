package com.learn.java8.cpu.cache;

public class Test2 {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    public static void test1() {
        int steps = 256 * 1024 * 1024;
        int[] a = new int[2];
        Long start = System.currentTimeMillis();
        // Loop 1
        for (int i = 0; i < steps; i++) {
            a[0]++;
            a[0]++;
        }
        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " 毫秒");

    }

    public static void test2() {
        int steps = 256 * 1024 * 1024;
        int[] a = new int[2];
        Long start = System.currentTimeMillis();
        // Loop 2
        for (int i = 0; i < steps; i++) {
            a[0]++;
            a[1]++;
        }
        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " 毫秒");
    }

    public static void test3() {
        int steps = 256 * 1024 * 1024;
        int[] a = new int[2];
        long start = System.currentTimeMillis();
        // Loop 1
        for (int i = 0; i < steps; i++) {
            a[0]++;
            a[0]++;
        }
        Long end = System.currentTimeMillis();
        System.out.println("loop1耗时: " + (end - start) + " 毫秒");

        Long start2 = System.currentTimeMillis();
        // Loop 2
        for (int i = 0; i < steps; i++) {
            a[0]++;
            a[1]++;
        }
        Long end2 = System.currentTimeMillis();
        System.out.println("loop2耗时: " + (end2 - start2) + " 毫秒");
    }
}
