package com.learn.java8.cpu.cache;

public class Test {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    public static void test1() {
        int[] arr = new int[64 * 1024 * 1024];
        Long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 3;
        }
        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " 毫秒");
    }

    public static void test2() {
        int[] arr = new int[64 * 1024 * 1024];
        Long start = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i += 1024) {
            arr[i] *= 3;
        }
        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " 毫秒");
    }

    public static void test3() {
        int[] arr = new int[8 * 1024];
        Long start = System.currentTimeMillis();

        int steps = 64 * 1024 * 1024;
        // Arbitrary number of steps
        int lengthMod = arr.length - 1;
        for (int i = 0; i < steps; i++) {
            arr[(i * 16) & lengthMod]++; // (x & lengthMod) is equal to (x % arr.Length)
        }

        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " 毫秒");
    }

    public static void test4() {
        int[] arr = new int[64 * 1024];
        Long start = System.currentTimeMillis();

        int steps = 64 * 1024 * 1024;
        // Arbitrary number of steps
        int lengthMod = arr.length - 1;
        for (int i = 0; i < steps; i++) {
            arr[(i * 16) & lengthMod]++; // (x & lengthMod) is equal to (x % arr.Length)
        }

        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " 毫秒");
    }

    public static void test5() {
        int[] arr = new int[64 * 1024 * 1024];
        Long start = System.currentTimeMillis();

        int steps = 64 * 1024 * 1024;
        // Arbitrary number of steps
        int lengthMod = arr.length - 1;
        for (int i = 0; i < steps; i++) {
            arr[(i * 16) & lengthMod]++; // (x & lengthMod) is equal to (x % arr.Length)
        }

        Long end = System.currentTimeMillis();
        System.out.println("耗时: " + (end - start) + " 毫秒");
    }
}
