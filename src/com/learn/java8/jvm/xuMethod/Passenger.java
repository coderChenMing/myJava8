package com.learn.java8.jvm.xuMethod;

public abstract class Passenger {
    abstract void passThroughImmigration();

    @Override
    public String toString() {
        System.out.println("dududu");
        return "dududu";
    }

    public static void main(String[] args) {
        Passenger passenger = new ChinesePassenger();
        passenger.passThroughImmigration();
    }
}
