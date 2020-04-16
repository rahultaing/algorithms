package com.algorithms.trees;

/*
* https://leetcode.com/problems/convert-bst-to-greater-tree/description/
*
* Given a Binary Search Tree (BST), convert it to a Greater Tree such that
 * every key of the original BST is changed to the original key plus sum of all
 * keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
*/

public class ConvertToGreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {

        if (root == null){
            return null;
        }

        this.recurse(root);
        return root;
    }

    private void recurse(TreeNode node){

        if (node == null){
            return;
        }

        this.recurse(node.right);
        node.val += this.sum;
        this.sum = node.val;
        this.recurse(node.left);
    }
}
