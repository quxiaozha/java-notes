package com.quxun.algorithms;

/**
 * Description:https://leetcode-cn.com/problems/reverse-integer/
 * Created by quxiaozha on 2018-10-8 16:12.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long res = 0;
        while(x != 0){
            res = res * 10 + x % 10;
            x = x / 10;
            System.out.println("res："+res+"、x:"+x);
        }
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
           res = 0;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0x80000001);
        System.out.println(reverse(1234567899));
    }
}
