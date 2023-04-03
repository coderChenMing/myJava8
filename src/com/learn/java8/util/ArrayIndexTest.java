package com.learn.java8.util;

public class ArrayIndexTest {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,6};
        int size = array.length;
        System.out.println(size);
        System.out.println(array[--size]);
        System.out.println(size);
    }
}
