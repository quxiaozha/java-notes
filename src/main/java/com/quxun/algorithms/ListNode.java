package com.quxun.algorithms;

/**
 * Description:单链表反转
 * Created by quxiaozha on 2018-9-18 9:20.
 */
public class ListNode {
    int data;
    ListNode next;

    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

    public ListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data +"";
    }

    public static void main(String[] args) {
        ListNode node5 = new ListNode(9, null);
        ListNode node4 = new ListNode(6, node5);
        ListNode node3 = new ListNode(8, node4);
        ListNode node2 = new ListNode(5, node3);
        ListNode node1 = new ListNode(7, node2);
        ListNode node0 = new ListNode(6, node1);
        System.out.println(node0.toString());
        System.out.println(reverse(node0).toString());
//        System.out.println(reverse(node1, node0).toString());
//        System.out.println(reverse2(node0).toString());
    }

    /**
     * @Author quxiaozha
     * @Description a->b->c->null ==> null<-a<-b<-c 将节点挪一位
     * @Date 9:31 2018-9-18
     * @Param [node]
     * @return com.quxun.algorithms.ListNode
     **/
    public static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode now = node;
        while (now != null) {
            ListNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }

        return prev;
    }

    /**
     * @Author quxiaozha
     * @Description a->b->c->null ==> null<-a<-b<-c
     * @Date 9:41 2018-9-18
     * @Param [node, prev]
     * @return com.quxun.algorithms.ListNode
     **/
    public static ListNode reverse(ListNode node, ListNode prev){//b a
        if (node.next == null) {//==null表示到链尾巴了
            node.next = prev;   //将尾巴的节点反转
            return node;//返回反转后的node
        } else {//不是尾巴
            ListNode rev = reverse(node.next, node);//继续往下循环
            node.next = prev;//将本次的两个节点反转
            return rev;
        }
    }

    public static ListNode reverse2(ListNode node) {
        if (node.next == null) {//到尾巴了
            return node;
        }
        ListNode next = node.next;//先保存next节点
        node.next = null;//去掉next链接指向
        ListNode rev = reverse2(next);//继续下次循环
        next.next = node;//反转链接指向
        return rev;
    }

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
