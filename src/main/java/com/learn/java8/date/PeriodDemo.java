package com.learn.java8.date;

import java.time.LocalDate;
import java.time.Period;

/**
 * Project: myJava8
 * File Created at 2022-02-12 23:08:23:08
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type PeriodDemo.java
 * @Desc
 * @date 2022/2/12 23:08
 */
public class PeriodDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.of(2025, 12, 12);
        Period p = Period.between(now, date);
        System.out.println(p.getYears());
        System.out.println(p.getMonths());
        System.out.println(p.getDays());

    }
}
