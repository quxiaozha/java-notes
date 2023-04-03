package com.quxun.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Description:
 * Created by quxiaozha on 2018-10-8 10:34.
 */
public class For {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            i *= 2;
            System.out.println(i);//0,2,6,14
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("c");

        for(Iterator<String> iterator = stringList.iterator(); iterator.hasNext();){
            String value = iterator.next();
            if("c".equals(value)){
                iterator.remove();
            }
        }
        System.out.println(stringList);
    }
}
