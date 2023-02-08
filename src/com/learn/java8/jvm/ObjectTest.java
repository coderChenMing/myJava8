package com.learn.java8.jvm;

public class ObjectTest {

    public static void test1(Object obj, Object ... obj2) {
        System.out.println("不带string");
    }
    public static void test1(String str,Object obj, Object ... obj2) {
        System.out.println("带string");
    }

    public static void main(String[] args) {

        test1(null,1);
    }
}
