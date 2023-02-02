package com.learn.java8.base;

/*跳出多重循环*/
public class SkipLoopTest {
    public static void main(String[] args) {
        //break1();
        break2();

    }

    public static void break1() {
        mark:
        for (int i = 0; i < 100; i++) {
            System.out.println("i==" + i);
            for (int j = 0; j < 50; j++) {
                System.out.println("j==" + j);
                if (j == 3) {
                    //System.out.println("j==3");
                    break mark;
                }
            }
        }
    }

    public static void break2() {
        boolean flag = true;
        for (int i = 0; i < 100 && flag; i++) {
            System.out.println("i==" + i);
            for (int j = 0; j < 50; j++) {
                System.out.println("j==" + j);
                if (j == 3) {
                    //System.out.println("j==3");
                    flag = false;
                    break;
                }
            }
        }
    }
}
