package com.learn.java8.test;

/*这段代码是在著名的单例延迟初始化例子中2，只有当调用 Singleton.getInstance 时，程序才会访问 LazyHolder.INSTANCE，
才会触发对 LazyHolder 的初始化（对应第 4 种情况），
继而新建一个 Singleton 的实例。
由于类初始化是线程安全的，并且仅被执行一次，因此程序可以确保多线程环境下有且仅有一个 Singleton 实例。*/
public class Singleton {
    /*private Singleton() {
    }

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }*/

    private Singleton() {
    }

    private static class LazyHolder {
        static final Singleton INSTANCE = new Singleton();

        static {
            System.out.println("LazyHolder.");
        }
    }

    public static Object getInstance(boolean flag) {
        if (flag) return new LazyHolder[2];
        return LazyHolder.INSTANCE;
    }

    public static void main(String[] args) {
        getInstance(true);
        System.out.println("----");
        getInstance(false);
    }
}
