package com.learn.java8.great;

import java.util.Random;

/**
 * Project: myJava8
 * File Created at 2022-04-14 20:11:20:11
 * {@link}
 * 一个不一样的hello world
 * @author <a href="mailto:charmFlightChen@gmail.com">chenming</a>
 * @version 1.0.0
 * @Type MainTest.java
 * @Description
 * @date 2022/4/14 20:11
 */
public class MainTest {
    public static void main(String[] args) {
        //System.out.println(randomString(-229985452) + " " + randomString(-147909649));

        randomString2(-229985452);
        System.out.println("----------------------------------");
        randomString2(-229985452);
    }


    public static String randomString(int i) {
        Random ran = new Random(i);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }

    private static void randomString2(int i) {
        Random ran = new Random(i);
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
        System.out.println(ran.nextInt());
    }
}
