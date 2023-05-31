package com.learn.java8.proxy.jdk;

public class Apple implements Sell {
    @Override
    public void sellPhone() {
        System.out.println("Apple: Sell iPhone X14");
    }

    @Override
    public void sellPc() {
        System.out.println("Apple: Sell MacBook Pro");
    }
}
