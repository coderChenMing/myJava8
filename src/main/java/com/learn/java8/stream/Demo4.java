package com.learn.java8.stream;

import java.util.Comparator;

/**
 * Project: myJava8
 * File Created at 2022-02-12 16:02:16:02
 * {@link Comparator}
 * 排序
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo4.java
 * @Desc
 * @date 2022/2/12 16:02
 */
public class Demo4 extends AbstractDemo {
    public static void main(String[] args) {
        // 自然排序 String实现了Comparable自然排序
        // list.stream().sorted().forEach(System.out::println);
        // 自定义排序  Employee没有实现自然排序,自定义排序方式
        // sorted(Comparator<? super T> comparator)
        // sorted接收的是{@link Comparator}实现类,使用lambda表达式重写compare方法
        employees.stream().sorted(
            (e1, e2) -> {
                if (e1.getAge() == e2.getAge()) {
                    return e1.getName().compareTo(e2.getName());
                } else {
                    return -Integer.compare(e1.getAge(), e2.getAge());// -表示倒序
                }
            }
        ).forEach(System.out::println);
    }

}
