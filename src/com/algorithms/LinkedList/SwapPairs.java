package com.algorithms.LinkedList;

public class SwapPairs {

    public ListNode swapPairs(ListNode head) {

        if (head==null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode p = dummy.next;

        while(p!=null && p.next!=null){
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
