package com.quxun.pattern;

/**
 * Description:单例模式-懒汉式-效率低
 * Created by quxun on 2018-10-23.
 */
public class Singleton2 {
    private static Singleton2 instance;

    private Singleton2() {}

    public static synchronized Singleton2 getInstance(){
        if (null == instance) {
            instance = new Singleton2();
        }
        return instance;
    }
}
