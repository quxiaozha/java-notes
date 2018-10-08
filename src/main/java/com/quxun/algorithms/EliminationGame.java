package com.quxun.algorithms;

/**
 * Description:390.消除游戏 https://leetcode-cn.com/problems/elimination-game/description/
 * Created by quxiaozha on 2018-9-28 10:52.
 */
public class EliminationGame {
    public static int lastRemaining2(int n){
        return n==1?1:2*(n/2 + 1 - lastRemaining2(n/2));
    }

    public static int lastRemaining(int n) {
        int[] ints = new int[n/2];
        int j = 0;
        if(n==1){
            return n;
        }
        for(int i = 2; i <= n; i = i+2){
            ints[j++] = i;
        }
        while (ints.length > 1) {
            ints = deleteFromHead(ints);
            ints = deleteFromFoot(ints);
        }

        return ints[0];
    }

    public static int[] deleteFromFoot(int[] ints) {
        int len = ints.length;
        if (len <= 1) {
            return ints;
        }
        int[] reInts = new int[len / 2];
        int j = 0;
        for (int i = 1; i < len; i = i + 2) {
            reInts[j++] = ints[i];
        }
        return reInts;
    }

    public static int[] deleteFromHead(int[] ints) {
        int len = ints.length;
        if (len <= 1) {
            return ints;
        }
        int[] reInts = new int[len / 2];
        int j = len / 2 - 1;
        for (int i = len - 2; i >= 0; i = i - 2) {
            reInts[j--] = ints[i];
        }
        return reInts;
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining2(4));
    }
}
