package com.learn.java8.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestUrl2 {
    public static void main(String[] args) {

        String[] strs = {"http://w3h7i1pmgkbfdw.25-t.yokohama/xms/index.html#","http://sbg3puu5.25-t.yokohama/xms/index.html#","http://v6df2pfhmscbtg.25-t.yokohama/xms/index.html#"};
        for (String url : strs) {
            Pattern pattern = Pattern.compile("(\\w+):\\/\\/([^/:]+)(:\\d*)?([^# ]*)");
            Matcher matcher = pattern.matcher(url);
            if(matcher.find())
           /* for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.print(matcher.group(i)+" ");
            }
            System.out.println();*/ {
                String secondDomain = matcher.group(2);
                System.out.print(secondDomain+"___");
                int first = secondDomain.indexOf(".");
                int last = secondDomain.lastIndexOf(".");
                if (last > first) {
                    secondDomain = secondDomain.substring(first + 1);
                    System.out.println(secondDomain);
                }
            }
        }
    }
    //实例中的数组包含 5 个元素，索引 0 对应的是整个字符串，索引 1 对应第一个匹配符（括号内），以此类推。
    //
    //第一个括号子表达式捕获 Web 地址的协议部分。该子表达式匹配在冒号和两个正斜杠前面的任何单词。
    //
    //第二个括号子表达式捕获地址的域地址部分。子表达式匹配非 : 和 / 之后的一个或多个字符。
    //
    //第三个括号子表达式捕获端口号（如果指定了的话）。该子表达式匹配冒号后面的零个或多个数字。只能重复一次该子表达式。
    //
    //第四个括号子表达式捕获 Web 地址指定的路径和 / 或页信息。该子表达式能匹配不包括 # 或空格字符的任何字符序列。
}
