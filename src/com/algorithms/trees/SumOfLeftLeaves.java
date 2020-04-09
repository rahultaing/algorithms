package com.algorithms.trees;

/*
* https://leetcode.com/problems/sum-of-left-leaves/description/
*
* Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

* */
public class SumOfLeftLeaves {

    // REDO
    private int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        this.recurse(root, false);
        return this.sum;
    }

    private void recurse(TreeNode node, boolean fromLeft){

        if (node.left == null && node.right == null){
            if (fromLeft){
                this.sum += node.val;
            }

            return;
        }

        if (node.left != null){
            this.recurse(node.left, true);
        }

        if (node.right != null){
            this.recurse(node.right, false);
        }
    }
}
