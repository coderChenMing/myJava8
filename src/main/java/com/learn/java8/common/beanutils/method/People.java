package com.learn.java8.common.beanutils.method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class People extends God {

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
     * 两个参数的 setName 方法
     * @param name1 名字1
     * @param name2 名字2
     */
    public void setName(String name1, String name2) {
        this.name = name1 + name2;
    }

    /**
     * 单参数静态方法：say
     * @param word
     */
    public static void say(String word) {
        System.out.println(word);
        System.out.println("单参数静态方法：say");
    }

    /**
     * 多参数静态方法：say
     * @param word1
     * @param word2
     */
    public static void say(String word1, String word2) {
        System.out.println(word1 + word2);
        System.out.println("多参数静态方法：say");
    }

    /**
     * 无参数静态方法：say
     */
    public static void say() {
        System.out.println("无参数静态方法：say");
    }

}
