package com.quxun.pattern;

/**
 * Description:懒汉式-双重检查锁
 * Created by quxun on 2018-10-23.
 */
public class Singleton3 {
    private volatile static Singleton3 instance;//使用volatile，重排序被禁止，所有的写（write）操作都将发生在读（read）操作之前

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if (null == instance) {
            synchronized (Singleton3.class) {
                if (null == instance) {
                    instance = new Singleton3();
                }
            }
        }
        return instance;
    }
}
