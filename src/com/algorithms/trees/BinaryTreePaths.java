package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/*
* https://leetcode.com/problems/binary-tree-paths/description/
* Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

*/
public class BinaryTreePaths {

    private List<String> list = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {

        if (root == null){
            return this.list;
        }

        this.recurse(root, new StringBuilder());
        return this.list;
    }

    private void recurse(TreeNode node, StringBuilder sb){

        sb.append(node.val);

        if (node.left == null && node.right == null){
            this.list.add(sb.toString());
            return;
        }

        if (node.left != null){
            this.recurse(node.left, new StringBuilder(sb).append("->"));
        }

        if (node.right != null){
            this.recurse(node.right, new StringBuilder(sb).append("->"));
        }
    }
}
