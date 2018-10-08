package com.quxun.object;

/**
 * Description:
 * Created by quxiaozha on 2018-10-8 15:23.
 */
public class Number {
    public static void main(String[] args) {

        System.out.println(0D);//0.0
        System.out.println(1 / 0D);//Infinity 无穷大
        System.out.println(-1 / 0F);//-Infinity
        System.out.println(true ? null : 0);//null
        try {
            System.out.println(true ? (Integer) null : 0);//NullPointerException
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println((Integer) null);//null
        System.out.println(true ? (Integer) null : new Integer(0));//null

        System.out.println((byte) (-1));//-1
        System.out.println((int) (byte) (-1));//-1
        System.out.println((char) (byte) (-1));//￿
        System.out.println((int) (char) (byte) (-1));//65535

    }
}
