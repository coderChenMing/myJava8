package com.learn.java8.yaml2java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MyYamlTest {
    public static void main(String[] args) {
       //transform1();
       transform2();

    }
    public static void transform1() {
        // 1、准备 Java 对象
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        Cat cat = new Cat("喵喵", 2, Arrays.asList("捉老鼠", "吃鱼"), map);
        // 2、Java 对象转 yaml 字符串
        String toYaml = YamlUtil.toYaml(cat);
        System.out.println(toYaml);
        // 3、yaml 字符串转 Java 对象
        Cat toObject = YamlUtil.toObject(toYaml, Cat.class);
        System.out.println(toObject);
    }
    public static void transform2() {
        String path = "test.yaml";
        // 1、准备 Java 对象
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        Cat cat = new Cat("喵喵", 2, Arrays.asList("捉老鼠", "吃鱼"), map);
        // 2、Java 对象写到 yaml 文件
        YamlUtil.writeYaml(cat, path);
        // 3、读取 yaml 文件转成 Java 字符串
        System.out.println(YamlUtil.readYaml(path, Cat.class));
    }
}
