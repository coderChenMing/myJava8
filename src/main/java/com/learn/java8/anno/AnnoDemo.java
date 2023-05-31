package com.learn.java8.anno;

import java.lang.reflect.Method;
import java.util.stream.Stream;

/**
 * Project: myJava8
 * File Created at 2022-02-12 23:43:23:43
 * {@link}
 * java8新增
 * 1.同名注解可重复添加
 * 2.支持类型注解{@link java.lang.annotation.ElementType}
 * 需要将要重复的注解指定容器类:MyAnno的容器类MyAnnos
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type AnnoDemo.java
 * @Desc
 * @date 2022/2/12 23:43
 */
public class AnnoDemo {
    @MyAnno("hello")
    @MyAnno("world")
    public static void show() {

    }

    public static void show2(@MyAnno("abc") String name) {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<AnnoDemo> clazz = AnnoDemo.class;
        Method show = clazz.getMethod("show");
        MyAnno[] my = show.getAnnotationsByType(MyAnno.class);
        Stream.of(my).map(MyAnno::value).forEach(System.out::println);

    }
}
