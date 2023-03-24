package com.learn.java8.test;

/**
 * 位运算应用
 */
public class Role {
    public static final int PROGRAMMER = 1; // 程序员（2的0次方，0001）
    public static final int GAMER = 2;      // 玩游戏（2的1次方，0010）
    public static final int OTAKU = 4;      // 宅（2的2次方，0100）
    public static final int MAN = 8;        // 男性（2的3次方，1000）

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(PROGRAMMER));
        System.out.println(Integer.toBinaryString(GAMER));
        System.out.println(Integer.toBinaryString(OTAKU));
        System.out.println(Integer.toBinaryString(MAN));
        // | 或位运算 有1则1
        int zhang = PROGRAMMER | GAMER | OTAKU | MAN; // 小张的特质
        System.out.println(zhang);
        // 小张是个程序员，还是个经常玩游戏的宅男。⇒四样齐全，即二进制是1111，换算成十进制15。
        int liu = GAMER | OTAKU; // 小刘的特质
        // 小刘不是程序员，她是个玩游戏的宅女。⇒“2的1次方位”以及“2的2次方位”“置1”，即二进制是0110，换算成十进制6。
        System.out.println(liu);
        // 即用“按位或运算”来将这些常量分别列出来即可。计算结果就是15和6。在实际应用中，这个数字，可以永久保存在配置文件中、保存在数据库中等等。
        // & 与位运算特点:两个二进制数进行与位运算，结果一定<=两个二进制数中比较小的一个
        if ((zhang & PROGRAMMER) == PROGRAMMER) {
            System.out.println("小张是程序员");
        } else {
            System.out.println("小张不是程序员");
        }
        if ((liu & PROGRAMMER) == PROGRAMMER) {
            System.out.println("小刘是程序员");
        } else {
            System.out.println("小刘不是程序员");
        }
        //即用“按位与运算”，使用常量“PROGRAMMER”将不关注的位遮掩掉，只判断我们关心的“2的0次方”那个二进制位，这种操作，被习惯性称为掩码操作。
        //掩码实际应用非常广泛。在指定计算机网络地址时，需要指定的“子网掩码”，便是用掩码的原理，来判断计算机是否属于某个子网。另外Linux传统的rwx文件权限也是同样的原理。
    }
}
