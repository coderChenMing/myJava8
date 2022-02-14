package com.learn.java8.date;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;

/**
 * Project: myJava8
 * File Created at 2022-02-12 23:32:23:32
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type ZoneDemo.java
 * @Desc
 * @date 2022/2/12 23:32
 */
public class ZoneDemo {
    public static void main(String[] args) {
        // test1();
        test2();
    }

    public static void test1() {
        // 查看当前可用时区
        Set<String> zon = ZoneId.getAvailableZoneIds();
        zon.forEach(System.out::println);
    }

    public static void test2() {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("America/Los_Angeles"));
        System.out.println(now);
    }
}
