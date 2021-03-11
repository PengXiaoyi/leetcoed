package com.checkpeng.leetcode.middle;

public class 环形链表II {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        // 找到相交点
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next == null) {
                return null;
            } else {
                fast = fast.next.next;
            }
            if (fast == slow) {
                while (p!=slow){
                    p = p.next;
                    slow = slow.next;
                }
                return p;
            }
        }
        return null;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
