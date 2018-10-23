package com.quxun.pattern;

/**
 * Description:单例模式-饿汉式-非延迟加载
 * Created by quxun on 2018-10-23.
 */

public class Singleton1 {
    private static Singleton1 instance = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return instance;
    }
}
