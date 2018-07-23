package com.algorithms.LinkedList;

import java.util.List;

public class RotateList {

    public ListNode rotate(ListNode list, int k){

        if (list == null){
            return null;
        }

        int len = 1;

        ListNode tail = list;

        while (tail.next != null){
            tail = tail.next;
            len++;
        }

        k = k % len;

        ListNode newHead = list;
        if (k != 0){

            tail.next = list;

            for (int i=0; i<len-k; i++){
                tail = tail.next;
            }

            newHead = tail.next;
            tail.next = null;
        }

        return newHead;
    }
}
