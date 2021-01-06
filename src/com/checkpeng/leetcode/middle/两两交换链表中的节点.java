package com.checkpeng.leetcode.middle;

public class 两两交换链表中的节点 {

    public ListNode swapPairs(ListNode head) {
        ListNode result = new ListNode(0, head);
        ListNode now = result;
        while (now.next != null && now.next.next != null) {
            ListNode temp = now.next;
            now.next = temp.next;
            temp.next = temp.next.next;
            now.next.next = temp;
            now = now.next.next;
        }
        return result.next;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



