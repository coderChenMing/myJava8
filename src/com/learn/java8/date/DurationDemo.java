package com.learn.java8.date;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

/**
 * Project: myJava8
 * File Created at 2022-02-12 23:08:23:08
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type DurationDemo.java
 * @Desc
 * @date 2022/2/12 23:08
 */
public class DurationDemo {
    public static void main(String[] args) {
        Instant i1 = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant i2 = Instant.now();
        Duration du = Duration.between(i1, i2);
        System.out.println(du.toMillis());


        LocalTime now = LocalTime.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime now1 = LocalTime.now();
        Duration du2 = Duration.between(now, now1);
        System.out.println(du2.toMillis());
    }
}
