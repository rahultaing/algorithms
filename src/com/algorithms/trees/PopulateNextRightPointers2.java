/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

this is better / clearer 

https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/37811/Simple-solution-using-constant-space
*/
package com.algorithms.trees;

public class PopulateNextRightPointers2 {

    public void connect(TreeLinkNode node) {

        if (node == null){
            return;
        }

        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode pre = dummy;

        while (node != null){

            if (node.left != null){
                pre.next = node.left;
                pre = pre.next;
            }

            if (node.right != null){
                pre.next = node.right;
                pre = pre.next;
            }

            node = node.next;

            if (node == null){
                pre = dummy;
                node = dummy.next;
                dummy.next = null;
            }
        }
    }

    // solution 2

    public void connect2(TreeLinkNode node){


        while (node!=null){

            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode cur = dummy;

            while (node!=null){

                if (node.left != null){

                    cur.next= node.left;
                    cur = cur.next;
                }

                if (node.right!=null){
                    cur.next = node.right;
                    cur = cur.next;
                }

                node = node.next;
            }

            node = dummy.next;
        }
    }
}
