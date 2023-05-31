package com.learn.java8.impl;

import com.learn.java8.Employee;
import com.learn.java8.inter.Condition;

/**
 * Project: myJava8
 * File Created at 2022-02-11 22:37:22:37
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type SalaryCondition.java
 * @Desc
 * @date 2022/2/11 22:37
 */
public class SalaryCondition implements Condition<Employee> {
    @Override
    public boolean condition(Employee employee) {
        return employee.getSalary()>=5000;
    }
}
