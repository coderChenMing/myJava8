package com.learn.java8.jvm.xuMethod;

public abstract class Passenger {
    abstract void passThroughImmigration();

    @Override
    public String toString() {
        System.out.println("dududu");
        return "dududu";
    }

    public static void main(String[] args) {
        //-XX:CompileCommand='dontinline,*.passThroughImmigration' 保证不走方法内联
        Passenger a = new ChinesePassenger();
        Passenger b = new ForeignerPassenger();
        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            Passenger c = (i < 1_000_000_000) ? a : b;
            c.passThroughImmigration();
        }
    }
}
