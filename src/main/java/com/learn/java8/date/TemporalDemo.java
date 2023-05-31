package com.learn.java8.date;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * Project: myJava8
 * File Created at 2022-02-12 23:15:23:15
 * {@link}
 * 时间校正器
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TemporalDemo.java
 * @Desc
 * @date 2022/2/12 23:15
 */
public class TemporalDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime newDate = now.withDayOfMonth(10);
        System.out.println(newDate);

        LocalDateTime next = now.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
        System.out.println(next);

        LocalDateTime newDate2 = now.with(t -> {
            // 自定义实现
            LocalDateTime ldt = (LocalDateTime) t;
            DayOfWeek nowWeek = ldt.getDayOfWeek();
            if (nowWeek.equals(DayOfWeek.SATURDAY)) {
                return ldt.plusDays(1);
            } else if (nowWeek.equals(DayOfWeek.FRIDAY)) {
                return ldt.plusDays(2);
            } else {
                return ldt.plusDays(3);
            }
        });
        System.out.println(newDate2);
    }
}
