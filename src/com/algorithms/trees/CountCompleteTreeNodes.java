package com.algorithms.trees;

/*
https://leetcode.com/problems/count-complete-tree-nodes/discuss/61948/Accepted-Easy-Understand-Java-Solution
* Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled,
 and all nodes in the last level are as far left as possible.
 It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6*/
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftDepth = this.leftDepth(root);
        int rightDepth = this.rightDepth(root);

        if (leftDepth == rightDepth){
            return (1 << leftDepth) - 1;
        }

        return this.countNodes(root.left) + this.countNodes(root.right) + 1;
    }

    private int leftDepth(TreeNode node){

        int depth = 0;

        while (node != null){
            node = node.left;
            depth++;
        }

        return depth;
    }

    private int rightDepth(TreeNode node){
        int depth = 0;

        while (node != null){
            node = node.right;
            depth++;
        }

        return depth;
    }
}
