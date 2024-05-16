package com.learn.java8.yaml2java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class YamlUtil2Test {
    public static void transform() {
        // 1、准备 Java 对象
        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "v2");
        map.put("k3", "v3");
        Cat cat = new Cat("喵喵", 2, Arrays.asList("捉老鼠", "吃鱼"), map);
        // 2、Java 对象转 yaml 字符串
        String yaml = YamlUtil2.toYaml(cat);
        System.out.println(yaml);
        // 3、读取 yaml 文件转成 Java 字符串
        System.out.println(YamlUtil2.toObject(yaml, Cat.class));
    }

    public static void main(String[] args) {
        transform();
    }
}
