package com.algorithms.trees;

public class PopulateNextRightPointers {

    public void connect(TreeLinkNode root) {

        if (root == null){
            return;
        }

        TreeLinkNode cur = root;

        while (cur != null){
            TreeLinkNode levelStartNode = cur;

            while(cur != null){
                if (cur.left != null){
                    cur.left.next = cur.right;
                }

                if (cur.next != null && cur.right != null){
                    cur.right.next = cur.next.left;
                }

                cur = cur.next;
            }

            cur = levelStartNode.left;
        }
    }
}
