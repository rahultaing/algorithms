package com.algorithms.LinkedList;

/*
https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Given a linked list, remove the n-th node from the end of list and return its head.

Example:
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.

Note:
Given n will always be valid.

Follow up:
Could you do this in one pass?

*/
public class RemoveNthFromEnd {

    public ListNode RemoveNthFromEnd(ListNode head, int n) {
        if (n == 0){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        int i=0;

        while (i<=n){
            fast = fast.next;
            i++;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
