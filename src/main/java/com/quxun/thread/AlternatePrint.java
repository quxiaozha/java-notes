package com.quxun.thread;

public class AlternatePrint {
    public static void main(String[] args) {
        final Object obj = new Object();
        final char[] charA = new char[]{'1','2','3','4','5'};
        final char[] charB = new char[]{'A','B','C','D','E'};

        Thread t1 = new Thread(){
            public void run() {
                synchronized (obj) {
                    for (char c : charA) {
                        System.out.println(c);
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        Thread t2 = new Thread(){
            public void run() {
                synchronized (obj) {
                    for (char c : charB) {
                        System.out.println(c);
                        obj.notify();
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
