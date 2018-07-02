package com.algorithms.trees;

/*
https://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/

Given a Binary Tree and a key,
write a function that prints all the ancestors of the key in the given binary tree.

For example, if the given tree is following
Binary Tree and key is 7, then your function should print 4, 2 and 1.


              1
            /   \
          2      3
        /  \
      4     5
     /
    7
*/

public class PrintAncestors {

    public void print(TreeNode root, int key){

        this.containsKey(root, key);
    }

    private boolean containsKey(TreeNode node, int key){

        if (node == null){
            return false;
        }

        if (node.val == key){
            return true;
        }

        if (this.containsKey(node.left, key)){
            System.out.print(node.val);
            return true;
        }

        if (this.containsKey(node.right, key)){
            System.out.print(node.val);
            return true;
        }

        return false;
    }
}
