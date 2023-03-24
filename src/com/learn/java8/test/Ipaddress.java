package com.learn.java8.test;

public class Ipaddress {
    public static boolean isIpv4Address(String ip) {
        if (null == ip || ip.length() == 0) {
            return false;
        }

        String[] lines = ip.split("\\.");

        if (lines.length != 4) {
            return false;
        }

        for (String pattern : lines) {
            try {
                int number = Integer.parseInt(pattern);

                if ((number >= 0) && (number <= 255)) {
                    continue;
                } else {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return true;
    }

    public static int ip2int(String ip) {
        if (!isIpv4Address(ip)) {
            throw new RuntimeException("invalid ip address");
        }

        int result = 0;
        String[] lines = ip.split("\\.");
        //125.213.100.123
        for (String pattern : lines) {
            int number = Integer.parseInt(pattern);
            result = number | (result << 8);
        }

        return result;
    }

    public static void testIp2Int() {
        String ip = "125.213.100.123";
        int result = ip2int(ip);
        System.out.println(result);
        System.out.println((125 * 256 * 256 * 256) + (213 * 256 * 256) +
                (100 * 256) + 123);
        //代码的输出结果为：
        //2111136891
        //2111136891
        //上面代码的思路：
        //1.首先判断输入ip地址的合法性。
        //2.将ip按.分隔，分成4段。
        //3.将第一段左移24位，第二段左移16位，第三段左移8位，第四段不变，结果相加，就可以得到最终的结果。具体的实现逻辑就是
        //result = number | (result << 8)这一行。
        //4.如果是最暴力的方法，main方法里的125*256*256*256+213*256*256+100*256+123这部分，实现的就是第三条提到的逻辑，两者得到的最终结果是一样的。
    }

    public static void main(String[] args) {
        testIp2Int();
        testInt2Ip();
    }

    public static String int2ip(int num) {
        return ((num >> 24) & 0xff) + "." + ((num >> 16) & 0xff) + "." +
                ((num >> 8) & 0xff) + "." + (num & 0xff);
        //具体的逻辑为：
        //ip地址的第一段为num右移24位后取低8位
        //ip地址的第二段为num右移16位后取低8位
        //ip地址的第三段为num右移8位后取低8位
        //ip地址的第四段为num取低8位
    }

    public static void testInt2Ip() {
        int num = 2111136891;
        String ip = int2ip(num);
        System.out.println(ip);
    }
}
