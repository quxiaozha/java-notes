package com.quxun.algorithms;

/**
 * Description:单链表反转 https://leetcode-cn.com/problems/reverse-linked-list/
 * Created by quxiaozha on 2018-9-20 9:13.
 */
public class ListNodeReverse {

    /**
     * @Author quxiaozha
     * @Description a->b->c->null ==> null<-a<-b<-c 将节点挪一位
     * @Date 9:31 2018-9-18
     * @Param [node]
     * @return com.quxun.algorithms.ListNode
     **/
    public static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        ListNode nex = null;
        while(cur != null){
            nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
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

}
