package com.learn.java8.date;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTest {
    public static void main(String[] args) {
        getTomorrowByCalendar();

        getTomorrowByLocalDateTime();

        getTomorrowByLocalDateTime2();
    }

    public static void getTomorrowByCalendar() {
        // 获取明天
        Calendar calendar = Calendar.getInstance();
        //calendar.add(Calendar.DATE,1);
        calendar.add(Calendar.DAY_OF_MONTH,1);
        System.out.println(calendar.getTime());
    }

    /*minusDays() 方法为当前时间减去 n 天，传负值就相当于当前时间加 n 天*/
    public static void getTomorrowByLocalDateTime() {
        System.out.println(LocalDateTime.now().plusDays(1));
    }

    public static void getTomorrowByLocalDateTime2() {
        System.out.println(LocalDateTime.now().minusDays(-1));
    }
}
