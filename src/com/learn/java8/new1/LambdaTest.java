package com.learn.java8.new1;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaTest {

    /*无参数，无返回值*/
    @Test
    public void Test01() {
        /*new Runnable(){
            @Override
            public void run() {
                System.out.println("无参数,无返回值");
            }
        }.run();*/

        Runnable runnable = () -> System.out.println("无参数,无返回值");
        runnable.run();
    }

    /*有参数，无返回值*/
    @Test
    public void Test02() {
        Consumer<String> consumer = x -> System.out.println("有参数无返回值:"+x);
        consumer.accept("test");
    }

    /*有参数，有返回值*/
    @Test
    public void Test03() {
        Function<Integer, String> function = x -> "有参数"+x+",有返回值"+(x>>1);
        System.out.println(function.apply(100));
    }
}
