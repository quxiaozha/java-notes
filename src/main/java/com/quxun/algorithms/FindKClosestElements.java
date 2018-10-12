package com.quxun.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:https://leetcode-cn.com/problems/find-k-closest-elements/description/
 * Created by quxiaozha on 2018-10-11 15:17.
 */
public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int len = arr.length;
        List<Integer> list = new ArrayList<>();
        if (arr[0] > x) {
            for (int i = 0; i < k; i++) {
                list.add(arr[i]);
            }
        } else if (x > arr[len - 1]) {
            for (int i = len - k; i < len; i++) {
                list.add(arr[i]);
            }
        } else {
            int foot = 0;
            int head = len - 1;
            int target = 0;
            boolean flag = false;
            while (head > foot) {
                int tmp = (foot + head) / 2;
                if (arr[tmp] == x) {
                    target = tmp;
                    flag = true;
                    break;
                }
                if (x > arr[tmp]) {
                    foot = tmp;
                } else {
                    head = tmp;
                }
                target = tmp;
            }
            //通过target取数据，需要考虑flag以及左边或右边的数据是否够，很麻烦。。。

        }
        return list;
    }

    public static List<Integer> findClosestElements2(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int start = 0, end = arr.length - 1;
        while (end - start + 1 > k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }
        for (int j = start; j <= end; j++) {
            list.add(arr[j]);
        }
        return list;
    }

    public static List<Integer> findClosestElements3(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int start = 0, end = arr.length - k;
        while (start < end) {
            int mid = (start + end) / 2;
            //比较mid和mid+k与x的距离
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x)) {
                start = mid + 1;//由于数组有序，如果大于说明mid离x较远，越往mid左侧越远，最优解在mid右侧，所以start必定>=mid+1
            } else {
                end = mid;//由于数组有序，如果小于说明mid+k离x较远，越往mid+k右侧越远，最优解在mid左侧，所以start必定<=mid
            }
        }
        for (int j = start; j < start + k; j++) {
            list.add(arr[j]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
        List<Integer> list = findClosestElements3(arr, 3, 6);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
