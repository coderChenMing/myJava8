package com.learn.java8.time;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * 可以根据年、月、日来模拟一个数量或者时间量的工具类。使用between()方法可以获取两个日期之间的差作为Period对象返回
 */
@Slf4j
public class PeriodTest {
    public static void main(String[] args) {
        betweenMethod();
        ofGetMethod();
    }

    private static void ofGetMethod() {
        Period period = Period.of(2021, 04, 8);
        Period periodYear = Period.ofYears(2021);
        Period periodMonths = Period.ofMonths(04);
        Period periodDays = Period.ofDays(8);
        log.info("给period赋予的值：年：{}，月：{}，日：{}", period.getYears(), period.getMonths(), period.getDays());
        log.info("给periodYear赋予的值：年：{}，月：{}，日：{}", periodYear.getYears(), periodYear.getMonths(), periodYear.getDays());
        log.info("给periodMonths赋予的值：年：{}，月：{}，日：{}", periodMonths.getYears(), periodMonths.getMonths(), periodMonths.getDays());
        log.info("给periodDays赋予的值：年：{}，月：{}，日：{}", periodDays.getYears(), periodDays.getMonths(), periodDays.getDays());
        log.info("使用get取值{}", period.get(ChronoUnit.YEARS));
    }

    private static void betweenMethod() {
        LocalDate startTime = LocalDate.of(2020, 01, 30);
        LocalDate endTime = LocalDate.of(2021, 04, 8);
        Period period = Period.between(startTime, endTime);
        log.info("两个时间之间的差值  年：{}，月：{}，日：{}", period.getYears(), period.getMonths(), period.getDays());
    }


}
