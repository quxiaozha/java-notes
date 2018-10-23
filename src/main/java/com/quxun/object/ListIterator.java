package com.quxun.object;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:不要在 foreach 循环里进行元素的 remove / add 操作。 remove 元素请使用 Iterator方式，
 *              如果并发操作，需要对 Iterator 对象加锁。
 * Created by quxiaozha on 2018-10-23 11:13.
 */
public class ListIterator {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
//                list.remove(item); //ConcurrentModificationException
            }
        }
//        list.add("1");
//        for (String item : list) {
//            if ("1".equals(item)) {
//                list.remove(item); //ConcurrentModificationException
//            }
//        }
        System.out.println(list.size());
    }
}
