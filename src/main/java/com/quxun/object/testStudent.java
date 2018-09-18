package com.quxun.object;

import javax.sound.midi.Soundbank;

/**
 * Description:
 * Created by quxiaozha on 2018-9-18 13:05.
 */
public class testStudent {
    public static void main(String[] args) {
        Address addr = new Address("home address", "company address");
        Student student1 = new Student(1, "qq", addr);

        System.out.println("addr的hascode：" + addr.hashCode());

        Address newAddr = new Address("new home address", "new company address");
        addr = newAddr;//将addr的引用指向新的地址，student1里边的不变，所以不会改变student1的addr属性
        System.out.println("新addr的hascode：" + addr.hashCode());
        System.out.println("student1的hascode：" + student1.addr.hashCode());
        System.out.println(student1.getAddr().getHomeAddr() + ">" + student1.getAddr().getWorkAddr());
        System.out.println(addr.getHomeAddr() + ">" + addr.getWorkAddr());

        student1.setAddr(addr);//set方法直接拿到addr的引用，可以改变student1的addr属性
        System.out.println(student1.getAddr().getHomeAddr() + ">" + student1.getAddr().getWorkAddr());

        Address latestAddr = new Address("latestAddr home address", "latestAddr company address");
        Address sa = student1.getAddr();
        sa = latestAddr;//只会将sa指向新的latestAddr，原来指向的地址内容不会变，所以不会改变student1的addr属性
        System.out.println(student1.getAddr().getHomeAddr() + ">" + student1.getAddr().getWorkAddr());

        student1.addr = latestAddr;//直接拿到引用，可以改变student1的addr属性
        System.out.println(student1.getAddr().getHomeAddr() + ">" + student1.getAddr().getWorkAddr());

        /**
         * python:
         * def f(x, l=[]):
         *     for i in range(x):
         *         l.append(i * i)
         *     print(l)
         *
         * f(2)
         * f(3, [3, 2, 1])
         * f(4)
         *
         * result:
         * [0, 1]
         * [3, 2, 1, 0, 1, 4]
         * [0, 1, 0, 1, 4]
         * 注意第三个，这是由于它使用了之前内存地址中存储的旧列表l[0,1]。
         **/
    }
}
