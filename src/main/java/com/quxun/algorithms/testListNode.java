package com.quxun.algorithms;

/**
 * Description:
 * Created by quxiaozha on 2018-9-20 9:22.
 */
public class testListNode {
    public static void main(String[] args) {
        ListNode node5 = new ListNode(9, null);
        ListNode node4 = new ListNode(8, node5);
        ListNode node3 = new ListNode(7, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(5, node2);
        ListNode node0 = new ListNode(4, node1);
        System.out.println("node0: " + node0.toString());
        System.out.println("node2: " + node2.toString());
        //987654+9876=997530
        System.out.println("node0 + node2: " + ListNodeAdd.addTwoNumbers(node0, node2).toString());

        System.out.println("After Reverse: " + ListNodeReverse.reverse(node0).toString());

    }
}
