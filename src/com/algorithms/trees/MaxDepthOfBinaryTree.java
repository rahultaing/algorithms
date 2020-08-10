package com.algorithms.trees;

/*
* https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
* Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
*/
public class MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
    }

    public int maxDepth_iterative(TreeNode node){

        if (node == null){
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();

        stack.push(node);
        depths.push(1);

        int depth = 0, cur_depth = 0;
        while (!stack.isEmpty()){

            TreeNode cur = stack.pop();
            cur_depth = depths.pop();

            if (cur!=null){

                depth = Math.max(depth, cur_depth);
                
                stack.push(node.left);
                stack.push(node.right);
                depths.push(cur_depth + 1);
                depths.push(cur_depth + 1);
            }
        }

        return depth;
    }
}
