package com.learn.java8.date;

import java.time.LocalDateTime;

/**
 * Project: myJava8
 * File Created at 2022-02-12 22:53:22:53
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestLocalDateTime.java
 * @Desc
 * @date 2022/2/12 22:53
 */
public class TestLocalDateTime {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now.plusYears(2));
        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getHour());
        System.out.println(now.getMinute());
        System.out.println(now.getSecond());
        // 指定日期
        System.out.println(LocalDateTime.of(2025,12,12,10,10,30,98));

    }
}
