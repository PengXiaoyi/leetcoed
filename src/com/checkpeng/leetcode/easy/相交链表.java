package com.checkpeng.leetcode.easy;

public class 相交链表 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode p = headA;
        ListNode q = headB;
        ListNode last = null;
        while (true) {
            if (p == q) {
                return p;
            }
            // p遍历到了尾结点
            if (p.next == null) {
                if (last == null) {
                    last = p;
                } else if (last != p) {
                    return null;
                }
                p = headB;
            } else {
                p = p.next;
            }
            // q遍历到了尾结点
            if (q.next == null) {
                if (last == null) {
                    last = q;
                } else if (last != q) {
                    return null;
                }
                q = headA;
            } else {
                q = q.next;
            }
        }
    }
}
