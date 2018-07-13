package com.algorithms.trees;

/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
* Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

        */
public class FlattenBinaryTree {

    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);
        flatten(right);

        root.left = null;
        root.right = left;

        while (root.right != null){
            root = root.right;
        }

        root.right = right;
    }
}
