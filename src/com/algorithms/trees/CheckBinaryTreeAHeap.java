package com.algorithms.trees;

/*
https://www.geeksforgeeks.org/check-if-a-given-binary-tree-is-heap/

* a binary tree is a heap if it is complete and if all the nodes have value
* greater than the value of their children*/
public class CheckBinaryTreeAHeap {

    public IsCompleteBinaryTree isCompleteBinaryTree;

    public boolean isHeap(TreeNode node){
        return this.isCompleteBinaryTree.isComplete(node) &&
                this.isHeapUtil(node);
    }

    private boolean isHeapUtil(TreeNode node){

        if (node == null){
            return true;
        }

        if (node.left == null && node.right == null){
            return true;
        }
        else if (node.right == null){
            return node.val >= node.left.val;
        }
        else {

           if (node.val >= node.left.val &&
                   node.val >= node.right.val){

               return this.isHeapUtil(node.left) && this.isHeapUtil(node.right);
           }
           else{
               return false;
           }
        }
    }
}
