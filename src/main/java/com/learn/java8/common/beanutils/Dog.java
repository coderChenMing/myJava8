package com.learn.java8.common.beanutils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dog {

    private String name;

    private Integer age;

    private String color;

    private Dog son;

    private List<String> hobbies;

    private Map<String, String> habits;

}
