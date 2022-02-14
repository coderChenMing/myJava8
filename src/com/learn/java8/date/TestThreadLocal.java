package com.learn.java8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Project: myJava8
 * File Created at 2022-02-12 22:36:22:36
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestThreadLocal.java
 * @Desc
 * @date 2022/2/12 22:36
 */
public class TestThreadLocal {
    public static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>() {
        protected DateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMdd");
        }
    };

    public static void main(String[] args) throws ParseException {
        Date convert = convert("20220212");
    }

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }
}
