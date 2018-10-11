package com.quxun.algorithms;

import java.util.Stack;

/**
 * Description:https://leetcode-cn.com/problems/score-of-parentheses/
 * Created by quxiaozha on 2018-10-11 9:54.
 */
public class ScoreofParentheses {
    static int sum;
    public static int scoreOfParentheses(String S) {
        int index = getIndex2(S);
        if (S.length() == 2) {
            sum = 1;
        }else if(index == S.length()-1){
            sum = 2 * scoreOfParentheses(S.substring(1,index));
        } else{
            sum = scoreOfParentheses(S.substring(0,index+1)) + scoreOfParentheses(S.substring(index+1));
        }

        return sum;
    }

    public static int getIndex(String s){
        Stack<Integer> stack = new Stack<>();
        int[] index = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                index[stack.pop()] = i;
            }
        }
        return index[0];
    }

    public static int getIndex2(String s){
        int target = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                target++;
            }else{
                if(--target == 0){
                    return i;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println((int)'(');//40
//        System.out.println((int)')');//41
        System.out.println(scoreOfParentheses("(()(()))"));
//        System.out.println("(()(()))".substring(1,7));
//        System.out.println(getIndex2("(())(())"));
    }
}
