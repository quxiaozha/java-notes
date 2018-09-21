package com.quxun.algorithms;

/**
 * Description:移除元素 https://leetcode-cn.com/problems/remove-element/description/
 * Created by quxiaozha on 2018-9-21 10:22.
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
         int len = nums.length;
         int j = 0;
         for(int i = 0; i < len; i++){
             if(nums[i] != val){
                 nums[j++] = nums[i];
             }
         }
         return j;
    }

    public int removeElement2(int[] nums, int val) {
        int len = nums.length;
        int j = len-1;

        for(int i = 0; i < len; i++){
            if(i > j){
                break;
            }
            if(nums[i] == val){
                while(j > i && nums[j] == val){
                    j--;
                }
                nums[i] = nums[j];
                j--;
            }
        }
        return j+1;
    }

    public int removeElement3(int[] nums, int val) {
         int len = nums.length;
         int count =0;
         for(int i = 0; i < len; i++){
             if(i + count >= len){
                 break;
             }
             if(nums[i] == val){
                 count++;
                 for(int k = len - count; k > i; k--){
                     if(nums[k] != val){
                         nums[i] = nums[k];
                         break;
                     }else{
                         count++;
                     }
                 }
             }
         }
         return len-count;
    }
}
