package com.learn.java8.stream;

import com.learn.java8.Employee;
import com.learn.java8.bean.Student;

import java.util.Arrays;
import java.util.List;

/**
 * Project: myJava8
 * File Created at 2022-02-12 12:19:12:19
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type AbstractDemo.java
 * @Desc
 * @date 2022/2/12 12:19
 */
public class AbstractDemo {
    public static List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
    public static List<Employee> employees = Arrays.asList(
        new Employee("张三", 16, 5555.88),
        new Employee("李四", 36, 2222),
        new Employee("王五", 56, 6666.22),
        new Employee("何六", 66, 8888.88),
        new Employee("何六", 66, 8888.88),
        new Employee("田七", 26, 10000)
    );
    public static List<Student> students = Arrays.asList(
        new Student("张三", 16, 100, Student.Status.BUSY),
        new Student("李四", 36, 80, Student.Status.FREE),
        new Student("王五", 56, 49, Student.Status.VOCATION),
        new Student("何六", 66, 66, Student.Status.FREE),
        new Student("田七", 26, 90, Student.Status.VOCATION),
        new Student("孙悟空", 44, 90, Student.Status.VOCATION),
        new Student("猪八戒", 88, 90, Student.Status.VOCATION),
        new Student("唐三藏", 32, 90, Student.Status.VOCATION)
    );
}
