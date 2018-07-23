package com.algorithms.trees;

/*
* https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its minimum depth = 2.

*/
public class MinDepthOfBinaryTree {

    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftDepth = this.minDepth(root.left);
        int rightDepth = this.minDepth(root.right);

        /*This is done specifically for a case like this.

           3
          /
         9

         */

        if (leftDepth == 0){
            return rightDepth + 1;
        }

        if (rightDepth == 0){
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }
}
