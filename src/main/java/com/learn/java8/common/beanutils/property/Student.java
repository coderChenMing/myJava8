package com.learn.java8.common.beanutils.property;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

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
     * 朋友
     */
    private Friend friend;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Friend {

        private String name;

        private Integer age;

        private String address;

    }

    /**
     * 爱好
     */
    private List<String> hobbies;

    /**
     * 学校
     */
    private Map<String, String> schoolMap;

}
