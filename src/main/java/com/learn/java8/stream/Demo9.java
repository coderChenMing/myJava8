package com.learn.java8.stream;

import com.learn.java8.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Project: myJava8
 * File Created at 2022-02-12 17:59:17:59
 * {@link}
 * 分区
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Demo9.java
 * @Desc
 * @date 2022/2/12 17:59
 */
public class Demo9 extends AbstractDemo {
    public static void main(String[] args) {
        // 按照工资是否大于6000的员工进行分区
        Map<Boolean, List<Employee>> salaryPart = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 6000));
        System.out.println(salaryPart);
    }
}
