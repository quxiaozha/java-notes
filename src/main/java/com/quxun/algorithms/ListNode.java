package com.quxun.algorithms;

/**
 * Description:单向链表
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
        ListNode tmp = next;
        StringBuffer sb = new StringBuffer();
        sb.append(data + ">");
        while(tmp != null){
            sb.append(tmp.data+">");
            tmp = tmp.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
