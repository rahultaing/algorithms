package com.algorithms.LinkedList;

/*

https://leetcode.com/problems/swap-nodes-in-pairs/description/

* Given a linked list, swap every two adjacent nodes and return its head.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
Note:

Your algorithm should use only constant extra space.
You may not modify the values in the list's nodes, only nodes itself may be changed.
*/
public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode p = dummy.next;

        while(p != null && p.next != null){
            ListNode q = p.next;
            ListNode r = p.next.next;

            prev.next = q;
            q.next = p;

            p.next = r;
            prev = p;
            p = r;
        }

        return dummy.next;
    }
}
