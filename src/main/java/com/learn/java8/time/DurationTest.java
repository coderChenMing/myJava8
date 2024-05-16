package com.learn.java8.time;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.Instant;

/**
 * duration 此类以秒和纳秒为单位对时间量进行建模，在上个类的基础可更加精密准确的处理时间
 * Period 类与 Duration 类都是一段持续时间的概念,如果需要对比时间，
 * 它们就需要一个固定的时间值,所以就需要 LocalDate 类与 Instant 类来配合它们使用:
 * Period 对应使用 LocalDate ，它们的作用范围域都是日期(年/月/日)
 * Duration 对应使用 Instant，它们的作用范围域都是时间(天/时/分/秒/毫秒/纳秒)
 */
@Slf4j
public class DurationTest {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        Instant start = Instant.parse("2021-04-13T13:52:30.00Z");
        Instant end = Instant.parse("2021-04-14T10:16:30.00Z");
        Duration duration = Duration.between(start, end);
        log.info("start 和 end 之间的时差值天:{},小时：{},分钟：{},秒：{},毫秒:{},纳秒：{}",
                duration.toDays(), duration.toHours(), duration.toMinutes(), duration.getSeconds(), duration.toMillis(), duration.toNanos());
    }
}
