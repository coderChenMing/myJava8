package com.learn.java8.inter;

/**
 * Project: myJava8
 * File Created at 2022-02-11 22:35:22:35
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type EmployeeCondition.java
 * @Desc
 * @date 2022/2/11 22:35
 */
public interface Condition<T> {

    boolean condition(T t);
}
