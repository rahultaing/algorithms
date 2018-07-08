package com.algorithms.trees;

/*
https://leetcode.com/submissions/detail/130623370/
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \
      4   5
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/

/*Time complexity: O(n)
* Space complexity: O(n) - for implicit call stack.*/

public class DiameterOfBinaryTree {

    private int max;
    public int diameterOfBinaryTree(TreeNode node) {

        if (node == null){
            return 0;
        }

        this.maxDepth(node);
        return this.max;
    }

    private int maxDepth(TreeNode node){

        if (node == null){
            return 0;
        }

        int left = this.maxDepth(node.left);
        int right = this.maxDepth(node.right);

        this.max = Math.max(this.max, left+right);

        return Math.max(left, right) + 1;
    }
}
