package com.quxun.algorithms;

/**
 * Description:70.爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/submissions/
 * Created by quxiaozha on 2018-9-27 11:05.
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n==1 || n==2 ){
            return n;
        }
        int res = 0, pre = 2, ppre = 1;
        for(int i = 3; i <= n; i++){
            res = pre + ppre;
            ppre = pre;
            pre = res;
        }
        return res;
    }

    //递归存在性能问题，会超时
    public int climbStairs2(int n) {
        if(n==1||n==2){
            return n;
        }
        return climbStairs2(n-1)+climbStairs2(n-2);
    }

}
