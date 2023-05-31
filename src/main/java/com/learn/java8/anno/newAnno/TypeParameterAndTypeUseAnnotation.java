package com.learn.java8.anno.newAnno;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

// 自定义ElementType.TYPE_PARAMETER注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_PARAMETER)
@interface MyNotEmpty {
}

// 自定义ElementType.TYPE_USE注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@interface MyNotNull {
}

public class TypeParameterAndTypeUseAnnotation<@MyNotEmpty T> {
    //使用TYPE_PARAMETER类型，会编译不通过
    /*public @MyNotEmpty T test(@MyNotEmpty T a) {
        new ArrayList<@MyNotEmpty String>();
        return a;
    }*/

    //使用TYPE_USE类型，编译通过
    public @MyNotNull T test2(@MyNotNull T a) {
        new ArrayList<@MyNotNull String>();
        return a;
    }

}
