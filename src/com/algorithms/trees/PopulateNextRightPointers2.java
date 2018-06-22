package com.algorithms.trees;

public class PopulateNextRightPointers2 {

    public void connect(TreeLinkNode root) {

        if (root == null){
            return;
        }

        while(root != null){

            TreeLinkNode temp = new TreeLinkNode(0);
            TreeLinkNode curNode = temp;

            while (root != null){

                if (root.left != null){
                    curNode.next = root.left;
                    curNode = curNode.next;
                }

                if (root.right != null){
                    curNode.next = root.right;
                    curNode = curNode.next;
                }

                root = root.next;
            }

            root = temp.next;
        }
    }
}
