package com.algorithms.trees;

/*
https://leetcode.com/problems/invert-binary-tree/description/
*/

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return null;
        }

        TreeNode left = this.invertTree(root.left);
        TreeNode right = this.invertTree(root.right);

        root.right = left;
        root.left = right;

        return root;
    }
}
