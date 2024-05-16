package com.learn.java8.common.beanutils.cons;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 地址
     */
    private String address;

    /**
     * 单参数构造方法
     * @param name 名字
     */
    public Student(String name) {
        this.name = name;
    }

    /**
     * 多参数构造方法
     * @param name 名字
     * @param age 年龄
     */
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 单参数构造方法
     * @param age 年龄
     */
    public Student(Integer age) {
        this.age = age;
    }

}
