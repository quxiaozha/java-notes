package com.quxun.algorithms;

/**
 * Description:115.不同的子序列 https://leetcode-cn.com/problems/distinct-subsequences/description/
 * Created by quxiaozha on 2018-9-27 13:18.
 */
public class DistinctSubsequences {
    public static int numDistinct(String s, String t) {
        int ls = s.length();
        int lt = t.length();

        if (ls < lt) {
            return 0;
        }
        int[][] dp = new int[ls + 1][lt + 1];

        for (int i = 0; i <= ls; i++) {
            dp[i][0] = 1;
        }

//        for (int j = 1; j <= lt; j++) {
//            dp[0][j] = 0;
//        }

        for (int i = 1; i <= ls; i++) {
            for (int j = 1; j <= lt; j++) {
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[ls][lt];
    }

    public static int numDistinct2(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return 0;
        }
        char[] ct = t.toCharArray();
        char[] cs = s.toCharArray();
        int lt = ct.length;
        int ls = cs.length;
        int[][] dp = new int[lt + 1][ls + 1];
        for (int i = 0; i <= ls; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i <= lt; i++) {
            for (int j = i; j <= ls; j++) {//只有满足j >= i 才可能匹配 否则都是0
                //类似从s中挑出t来，从尾巴的字母开始跳，如果这个字母是相等的，我们有两种选择，
                // 1、捡起来这个匹配字母，然后继续找次尾巴的字母
                // 2、放弃这个，继续找尾巴的这个字母
                dp[i][j] = dp[i][j - 1] + (ct[i - 1] == cs[j - 1] ? dp[i - 1][j - 1] : 0);
            }
        }
        return dp[lt][ls];
    }

    //最长公共序列 相对位置
    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[len1][len2];
    }

    //最长公共子串 必须连续
    public static int lcs2(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int result = 0;     //记录最长公共子串长度
        int c[][] = new int[len1+1][len2+1];
        for (int i = 0; i <= len1; i++) {
            for( int j = 0; j <= len2; j++) {
                if(i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    c[i][j] = c[i-1][j-1] + 1;
                    result = Math.max(c[i][j], result);
                } else {
                    c[i][j] = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println(lcs("rabbbit", "rabbit"));
        System.out.println(lcs2("rabbbit", "rabbit"));
    }
}
