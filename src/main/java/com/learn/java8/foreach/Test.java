package com.learn.java8.foreach;

public class Test {
    public static void main(String[] args) {
        int index=4;
        while (index-- > 0) { // 第一次index为4,打印的是--后的值
            System.out.println(index);
            //index--;
        }
        System.out.println("====================================");
        index = 4;
        while (index > 0) {
            System.out.println(index);
            index--;
        }

        // 以上两种方式都是循环 4 次,但是打印内容不同
    }
}
