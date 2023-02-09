package com.learn.java8.jvm.xuMethod;

public class ForeignerPassenger extends Passenger {

    @Override
    void passThroughImmigration() {
        System.out.println("进外国人通道 ");
    }
}
