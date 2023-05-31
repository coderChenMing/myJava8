package com.learn.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: myJava8
 * File Created at 2022-12-02 14:27:14:27
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestDomain.java
 * @Description
 * @date 2022/12/2 14:27
 */
public class TestDomain {
    public static void main(String[] args) {
        String[] urls = {
            "https://lr.lykh888.cn/waplogin.php",
            "http://js.1.cczmkm.com/waplogin.php",
            "https://xueshu.baidu.com",
            "https://zhidao.baidu.com/question/569520099382340124.html",
            "http //149.30.246.36",
            "http //149.30.246.36/abcd.html"};
        for (String url : urls) {
            checkUrl(url);
        }

    }

    public static void checkUrl(String url) {
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|tv)",Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        // find()方法是部分匹配，是查找输入串中与模式匹配的子串，如果该匹配的串有组还可以使用group()函数。
        if(matcher.find()) {
            //System.out.println(url.charAt(matcher.start())+"---"+url.charAt(matcher.end()));
            System.out.println(url.substring(matcher.start(), matcher.end()));
            System.out.println("域名是："+matcher.group());
        }
    }
}
