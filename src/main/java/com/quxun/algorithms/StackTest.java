package com.quxun.algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Queue<Integer> st = new LinkedList<>();
        st.offer(1);
        st.offer(2);
        st.offer(3);
        st.offer(4);

        for(Integer i:st){
            System.out.println(i);
        }
        //这里没有按照stack的先进后出原则！
    }
}
