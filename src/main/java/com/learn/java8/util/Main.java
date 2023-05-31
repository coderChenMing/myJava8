package com.learn.java8.util;

public class Main {
    public static void main(String[] args) {
        //test1();
        test2();
    }

    public static void test1() {
        LinkedList<Integer> list = new LinkedList<>();
        System.out.println(list.indexOfE(0));
        //System.out.println(list.first.item);
        //System.out.println(list.last.item);
        System.out.println(list);
    }

    public static void test2() {
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        list.add(2);
        list.add(12);
        list.add(32);
        list.add(23);
        list.add(24);
        list.remove(0);
        list.remove(0);
        list.remove(0);
        System.out.println(list);
    }
}
