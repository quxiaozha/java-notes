package com.quxun.algorithms;

/**
 * Description:
 * Created by quxiaozha on 2018-10-10 16:37.
 */
public class Number2Binary {
    public static String toBin(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append(num >>> i & 1);
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(toBin(-10));
        System.out.println(toBin(((~(-10))+0b1)));
        System.out.println(0b101);
        System.out.println(0b1 == 1);
    }

}
