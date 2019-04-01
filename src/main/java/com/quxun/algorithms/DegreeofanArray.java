package com.quxun.algorithms;

import java.util.HashMap;
import java.util.Map;

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
            if(max == map.get(i)[2]){
                min = Math.min(min, map.get(i)[1] - map.get(i)[0] + 1);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(findShortestSubArray(new int[] {1,2,2,3,1,4,2}));
    }
}
