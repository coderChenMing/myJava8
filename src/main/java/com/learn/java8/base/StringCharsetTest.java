package com.learn.java8.base;

/**
 * Project: myJava8
 * File Created at 2022-08-19 09:43:9:43
 * {@link}
 *
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type StringCharsetTest.java
 * @Description
 * @date 2022/8/19 9:43
 */
public class StringCharsetTest {
    public static void main(String[] args) {
        String greeting = "hello";
        int length = greeting.length();
        System.out.printf("%s.length= %d\n",greeting,length);
        String str1 = "严";
        int length1 = str1.length();
        System.out.printf("%s.length= %d\n",str1,length1);
        // 使用 length 和 charAt 等方法时返回的是编码后的码元数量而不是认为的字符个数
        // 在一个字符串内如果有使用多个码元表示的字符，在使用以上的方法时会出现检索错误，


        System.out.println(new String("字").getBytes().length);
        // Java语言规定，Java 的 char 类型是 UTF-16 的码元，所以 char 一定是16 位（ 2 字节）；
        // String.getBytes() 是一个用于将 String 的内码转换为指定的外码的方法。
        // 无参数版使用平台的默认编码作为外码，有参数版使用参数指定的编码作为外码；将String 的内容用外码编码好，结果放在一个新 byte[] 返回。
    }
}
