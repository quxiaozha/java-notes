package com.quxun.algorithms;

/**
 * Description:链表相加，包含进位
 * Created by quxiaozha on 2018-9-20 9:18.
 */
public class ListNodeAdd {
    /**
     * @Author quxiaozha
     * @Description https://leetcode.com/problems/add-two-numbers/description/
     *              Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     *              Output: 7 -> 0 -> 8
     *              Explanation: 342 + 465 = 807.
     * @Date 10:42 2018-9-19
     * @Param [l1, l2]
     * @return com.quxun.algorithms.ListNode
     **/
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp1 = l1;
        ListNode tmp2 = l2;
        ListNode newNode = null;
        ListNode curNode = null;
        int sum;
        boolean flag = false;
        while(tmp1 != null || tmp2 != null || (flag == true)){
            sum = (tmp1==null?0:tmp1.data) + (tmp2==null?0:tmp2.data);
            sum = (flag == true)?(sum+1):sum;
            if(sum / 10 >= 1){
                flag = true;
                sum = sum - 10;
            }else{
                flag = false;
            }
            ListNode tmpNode = new ListNode(sum);
            if(newNode == null){
                curNode = tmpNode;
                newNode = tmpNode;
            }else{
                curNode.next = tmpNode;
                curNode = tmpNode;
            }
            tmp1 = (tmp1==null)?null:tmp1.next;
            tmp2 = (tmp2==null)?null:tmp2.next;
        }
        return newNode;
    }

}
