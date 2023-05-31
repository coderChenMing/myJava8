package com.learn.java8.base;

/**
 * Project: myJava8
 * File Created at 2022-11-29 16:08:16:08
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type SplitTest.java
 * @Description
 * @date 2022/11/29 16:08
 */
public class SplitTest {
    public static void main(String[] args) {
        String[] urls = {"http://www.dududu.com", "baidu.com", "银行"};
        for (String url : urls) {
            if(url.lastIndexOf(".")>url.indexOf(".")) {
                String[] strings = url.split("\\.", 2);
                for (String string : strings) {
                    System.out.println(string);
                }
            }
        }
    }
}
