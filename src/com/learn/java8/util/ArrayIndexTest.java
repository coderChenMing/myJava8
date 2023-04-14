package com.learn.java8.util;

import java.util.Arrays;

public class ArrayIndexTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    public static void test1() {
        int[] array = new int[]{1, 2, 3, 4, 6};
        int size = array.length;
        System.out.println(size);
        System.out.println(array[--size]);
        System.out.println(size);
    }

    public static void test2() {
        int[] array = new int[5];
        int size = 0;
        array[size++] = 1;
        System.out.println(Arrays.toString(array));
        System.out.println(size);
    }

    public static void test3() {
        int[] array = new int[5];
        int size = 0;
        array[++size] = 1;
        System.out.println(Arrays.toString(array));
        System.out.println(size);
    }
}
