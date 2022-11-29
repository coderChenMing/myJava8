package com.learn.java8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Project: myJava8
 * File Created at 2022-02-12 23:26:23:26
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type DateTimeFormatterDemo.java
 * @Desc
 * @date 2022/2/12 23:26
 */
public class DateTimeFormatterDemo {
    public static void main(String[] args) {
        DateTimeFormatter fo = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String strDate = fo.format(now);
        System.out.println(strDate);

        DateTimeFormatter my = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        String format = my.format(now);
        System.out.println(format);

        System.out.println(LocalTime.MAX);//23:59:59.999999999
        System.out.println(LocalTime.MIN);//00:00
        System.out.println(LocalTime.MIDNIGHT);//00:00
        System.out.println(LocalDate.parse("2022-01-01"));//2022-01-01
    }
}
