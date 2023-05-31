package com.learn.java8.stream;

import com.learn.java8.Employee;
import com.learn.java8.bean.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Project: myJava8
 * File Created at 2022-02-12 17:05:17:05
 * {@link}
 * reduce:归约
 * collector:收集器
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo6.java
 * @Desc
 * @date 2022/2/12 17:05
 */
public class Demo6 extends AbstractDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream().reduce(0, (x, y) -> x + y);
        // 规约执行流程:x第一次取起始值,如上x第一次取0,y第一次取stream第一个元素1,执行x+y
        // x第二次取(x+y)的第一次的结果,y取stream流中第二个元素
        // ....
        System.out.println(sum);

        // 计算所有学生分数之和
        Double sumScore = students.stream().map(Student::getScore).reduce(0.0, Double::sum);
        System.out.println("所有学生分数之和: " + sumScore);
        // reduce不设置起始值 计算所有员工工资之和
        Optional<Double> salarySum = employees.stream().map(Employee::getSalary).reduce(Double::sum);
        System.out.println("所有员工工资之和: " + salarySum.get());

    }
}
