package com.quxun.object;

/**
 * Description:good and gbc
 * Created by quxiaozha on 2018-9-19 13:59.
 */
public class StringAndChar {
    String str = new String("good");
    char[] ch = {'a', 'b', 'c'};

    public static void main(String args[]) {
        StringAndChar ex = new StringAndChar();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "bad";
        ch[0] = 'g';
    }

}
