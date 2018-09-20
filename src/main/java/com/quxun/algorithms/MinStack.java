package com.quxun.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Description:最小栈 https://leetcode-cn.com/problems/min-stack/
 * Created by quxiaozha on 2018-9-20 14:33.
 */
public class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack;
    List<Integer> minList;

    public MinStack() {
        stack = new Stack<>();
        minList = new ArrayList<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minList.size()==0 || x <= minList.get(minList.size()-1)){
            minList.add(x);
        }
    }

    public void pop() {
        int e = stack.pop();
        if(e == minList.get(minList.size()-1)){
            minList.remove(minList.size()-1);
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minList.get(minList.size()-1);
    }

//    /** initialize your data structure here. */
//    Stack<Integer> stack;
//    Stack<Integer> stack_res;
//    public MinStack() {
//        stack= new Stack<>();
//        stack_res= new Stack<>();
//    }
//
//    public void push(int x) {
//        stack.push(x);
//        if(stack_res.isEmpty()||stack_res.peek()>=x)
//            stack_res.push(x);
//    }
//
//    public void pop() {
//        if (stack.pop().equals(stack_res.peek())) {
//            stack_res.pop();
//        }
//    }
//
//    public int top() {
//        return stack.peek();
//    }
//
//    public int getMin() {
//        return stack_res.peek();
//    }
}
