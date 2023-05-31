package com.learn.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: myJava8
 * File Created at 2022-07-26 17:44:17:44
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type Test.java
 * @Description
 * @date 2022/7/26 17:44
 */
public class Test {
    public static void main(String[] args) {
        // testSplit();
         testSearch();
        // testReplace();
        // testDateReplace();
        //testDateReplace2();
    }

    // split使用正则进行分割: , ; 和空格(\\s表示)
    public static void testSplit() {
        String[] split = "a, b ;; c".split("[,;\\s]+");
        for (String s : split) {
            System.out.println(s);
        }
    }
    /**
     \\w表示匹配字母数字下划线
     获取到Matcher对象后，不需要调用matches()方法（因为匹配整个串肯定返回false），
     而是反复调用find()方法，在整个串中搜索能匹配上\\wo\\w规则的子串，并打印出来。
     这种方式比String.indexOf()要灵活得多，因为我们搜索的规则是3个字符：中间必须是o，前后两个必须是字符[A-Za-z0-9_]。
     **/
    public static void testSearch() {
        String s = "the quick brown fox jumps over the lazy dog. _op";
        Pattern p = Pattern.compile("\\wo\\w");
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            System.out.println(sub);
        }
    }
    // 空格加四个小写字母匹配的前后分别增加<b></b>
    public static void testReplace() {
        String s = "the quick brown fox jumps over the lazy dog.";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }


    // 年月日分成三组,每组匹配,对应$1 $2 $3
    // 可以用$1, $2和 $3获取各group
    public static void testDateReplace() {
        String str = "2021/04/24";
        String regex = "(\\d{4})[-/](\\d{2})[-/](\\d{2})";
        String change = str.replaceAll(regex, "$1年$2月$3日");
        System.out.println(change);//2021年04月24日
    }
    // 此时若用(?:)替换括号，该部分变为non-capturing group,不生成可获取的group
    // 只有$1和$2
    public static void testDateReplace2() {
        String str = "2021/04/24";
        String regex = "(?:\\d{4})[-/](\\d{2})[-/](\\d{2})";
        String change = str.replaceAll(regex, "$1月$2日");
        System.out.println(change);//04月24日
    }
}
