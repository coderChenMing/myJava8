package com.learn.java8.jvm.xuMethod;

public class ChinesePassenger extends Passenger {
    @Override
    void passThroughImmigration() {
        System.out.println("进中国人通道");
    }

    void visitDutyFreeShops() {
        System.out.println("逛免税店 ");
    }
}
