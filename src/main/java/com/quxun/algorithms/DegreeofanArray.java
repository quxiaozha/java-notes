package com.quxun.algorithms;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 * https://leetcode-cn.com/problems/degree-of-an-array/submissions/
 */
public class DegreeofanArray {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i])[1] = i;
                map.get(nums[i])[2]++;
            } else {
                int[] detail = {i, i, 1};
                map.put(nums[i], detail);
            }
            max = Math.max(max, map.get(nums[i])[2]);
        }

        int min = nums.length;
        for (int i : map.keySet()) {
            if (max == map.get(i)[2]) {
                min = Math.min(min, map.get(i)[1] - map.get(i)[0] + 1);
            }
        }

        return min;
    }

    public static int findShortestSubArray(int[] nums, String info) {
        int max = nums[0];
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int len = nums.length;
        int[] numCount = new int[max + 1];
        int[] numFirstMeet = new int[max + 1];
        int[] numLen = new int[max + 1];
        int maxCount = 1;
        for (int i = 0; i < len; i++) {
            numCount[nums[i]]++;
            if (numCount[nums[i]] != 1) {
                numLen[nums[i]] = i - numFirstMeet[nums[i]] + 1;
                maxCount = Math.max(maxCount, numCount[nums[i]]);
            } else {
                numFirstMeet[nums[i]] = i;
            }
        }
        if (maxCount == 1) {
            return 1;
        }
        int min = len;
        for (int i = 0; i < numCount.length; i++) {
            if (maxCount == numCount[i]) {
                min = Math.min(min, numLen[i]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(findShortestSubArray(new int[]{1}, "m2"));
    }
}
