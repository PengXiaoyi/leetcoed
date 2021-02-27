package com.checkpeng.nowcoder;

public class 翻转链表 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        ListNode listNode = ReverseList(head);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    public static ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;
        while (b != null) {
            b.next = a;
            a = b;
            b = c;
            if (b != null) {
                c = b.next;
            }
        }
        head.next = null;
        return a;
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
