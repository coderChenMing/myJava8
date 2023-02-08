package com.learn.java8.jvm;

public class B extends A{

    @Override
    public D test(String name) {
        System.out.println("B.test");
        return new D();
    }
}
