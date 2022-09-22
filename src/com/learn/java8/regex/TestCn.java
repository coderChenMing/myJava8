package com.learn.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: myJava8
 * File Created at 2022-09-22 10:23:10:23
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type TestCn.java
 * @Description
 * @date 2022/9/22 10:23
 */
public class TestCn {
    public static void main(String[] args) {
         String regex = "\\.";
        // Pattern pattern = Pattern.compile("(?i:[a-z0-9\\u4e00-\\u9fa5]|[a-z0-9\\u4e00-\\u9fa5][-a-z0-9\\u4e00-\\u9fa5]*[a-z0-9\\u4e00-\\u9fa5])");
        Pattern pattern = Pattern.compile("\\b(?:(?:ftp|https?)://[-\\w]+(\\.\\w[-\\w]*)+|(?:(?i:[a-z0-9\\u4e00-\\u9fa5]|[a-z0-9\\u4e00-\\u9fa5][-a-z0-9\\u4e00-\\u9fa5]*[a-z0-9\\u4e00-\\u9fa5])\\.)+(?x-i:com\\b|edu\\b|biz\\b|in(?:t|fo)\\b|mil\\b|net\\b|org\\b|[a-z][a-z]\\b))");
        Matcher matcher = pattern.matcher("https://ww.银监会在线服务中心.com/");
        System.out.println(matcher.matches());
    }
}
