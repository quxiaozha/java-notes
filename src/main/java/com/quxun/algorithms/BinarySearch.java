package com.quxun.algorithms;

/**
 * Description:二分查找 https://leetcode-cn.com/problems/binary-search/
 * Created by quxiaozha on 2018-9-21 14:00.
 */
public class BinarySearch {
    public static int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            //int mid = start + (end - start) / 2;
            int mid = (begin + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = search(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10);

        System.out.println(i);
    }
}
