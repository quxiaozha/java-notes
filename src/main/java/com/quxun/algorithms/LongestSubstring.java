package com.quxun.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:无重复字符的最长子串 https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/
 * Created by quxiaozha on 2018-9-25 9:22.
 */
public class LongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (count >= (len - i)) {
                break;
            }
            int iCount = 1;
            set.clear();
            set.add(c[i]);
            for (int j = i + 1; j < len; j++) {
                if (set.add(c[j])) {
                    iCount++;
                } else {
                    break;
                }
            }
            count = Math.max(count, iCount);
        }
        return count;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<>();
        while (right < s.length()) {
            if (res >= s.length() - left) {
                break;
            }
            if (t.add(s.charAt(right))) {
                right++;
                res = Math.max(res, t.size());
            } else {
                //只让left++，right没变，所以如果s.charAt(right)没有被移除，
                // 上面的t.contains(s.charAt(right))会一直true，会循环执行t.remove
                t.remove(s.charAt(left++));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcddcbabcbbghac"));
    }
}
