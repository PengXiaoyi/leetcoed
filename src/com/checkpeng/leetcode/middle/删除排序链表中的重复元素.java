package com.checkpeng.leetcode.middle;

import java.util.LinkedList;
import java.util.Queue;

public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode now = pre;
        while(now.next!=null && now.next.next!=null){
            if(now.next.val==now.next.next.val){
                // 有重复节点处理
                int num = now.next.val;
                ListNode should = now.next;
                while(should!=null && should.val==num){
                    should = should.next;
                }
                now.next = should;
            }else{
                // 无重复节点处理
                now = now.next;
            }
        }
        return pre.next;
    }
    
      public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
