package com.quxun.object;

/**
 * Description:
 * Created by quxiaozha on 2018-9-21 11:05.
 */
public class BasicDataTypes {
    public static void main(String args[]) {
        int num = 2147483647;
        long temp = num + 10L;
        System.out.println(num);

        String String = "";//String不是关键字 可以当做标识符！

        long num2 = 100;
        int x = (int) (num2 + 2);//必须强制转换 否则报错
        System.out.println(x);

        int num3 = 50;
        num3 = num3++ * 2;//100
        num3 = num3++;//还是100
        num3++;//101
        int tmp = num3++;//tmp=101 num3=102
        System.out.println(tmp);
        System.out.println(num3);

        int num4 = 2147483647 ;//2^31-1
        num4 += 2 ;
        System.out.println(num4) ;//-2147483647

        int num5 = 2147483647 ;
        num5 += 2L ;
        System.out.println(num5);//-2147483647
    }
}
