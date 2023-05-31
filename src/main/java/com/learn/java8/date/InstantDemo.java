package com.learn.java8.date;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * Project: myJava8
 * File Created at 2022-02-12 23:05:23:05
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type InstantDemo.java
 * @Desc
 * @date 2022/2/12 23:05
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);

        OffsetDateTime odt = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(odt.toEpochSecond());

        Instant instant = Instant.ofEpochSecond(1);
        System.out.println(instant);
    }
}
