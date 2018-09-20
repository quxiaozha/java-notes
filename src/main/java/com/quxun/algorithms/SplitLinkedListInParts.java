package com.quxun.algorithms;

/**
 * Description:725. 分隔链表 https://leetcode-cn.com/problems/split-linked-list-in-parts/description/
 * Created by quxiaozha on 2018-9-20 10:16.
 */
public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode tmp = root;
        int count = 0;
        while(tmp != null){
            count++;
            tmp = tmp.next;
        }

        int base = count < k?1:count/k;
        int extra = count < k?0:count%k;
        ListNode[] listNodes = new ListNode[k];
        tmp = root;
        ListNode cur;
        int i = 0;
        int j = 0;
        int cut = 0;
        while (tmp != null) {
            if(j >= k){
                break;
            }
            cur = tmp;
            tmp = tmp.next;
            if (i == cut) {
                cut = cut + (j<extra?base+1:base);
                listNodes[j] = cur;
                j++;
            }
            if (i == cut-1) {
                cur.next = null;
            }
            i++;

        }
        return listNodes;
    }

    public ListNode[] splitListToParts2(ListNode root, int k) {
        //总数
        int sum = 0;
        ListNode curr = root;
        while (curr != null) {
            sum++;
            curr = curr.next;
        }
        curr = root;
        //每个部分的基础大小
        int per = sum < k ? 1 : sum / k;
        //额外分配多1的结点数(extra<per)
        int extra = sum < k ? 0 : sum % k;

        ListNode[] result = new ListNode[k];
        ListNode pre = null;
        for (int i = 0; i < k; i++) {
            result[i] = curr;
            for (int j = 0; (j < ((i < extra) ? (per + 1) : per)) && (curr != null); j++) {
                pre = curr;
                curr = curr.next;
            }
            if (pre != null) {
                pre.next = null;
            }
        }

        return result;
    }

}
