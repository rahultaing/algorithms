package com.algorithms.trees;

/*
* https://leetcode.com/problems/path-sum/description/
* Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

*/

public class HasPathSum {

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null){
            return false;
        }

        return this.recurse(root, sum);
    }

    private boolean recurse(TreeNode node, int sum){

        if (node.left == null && node.right == null && node.val == sum){
            return true;
        }

        if (node.left != null){
            if (this.recurse(node.left, sum - node.val)){
                return true;
            }
        }

        if (node.right != null){
            if (this.recurse(node.right, sum - node.val)){
                return true;
            }
        }

        return false;
    }
}
