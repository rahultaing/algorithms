package com.algorithms.trees;

/*
https://leetcode.com/articles/binary-tree-pruning/

We are given the head node root of a binary tree,
where additionally every node's value is either a 0 or a 1.

Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

(Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
*/

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode node) {

        if (node == null){

            return null;
        }

        node.left = this.pruneTree(node.left);
        node.right = this.pruneTree(node.right);

        boolean contains = node.left != null || node.right != null || node.val == 1;

        return contains ? node : null;
    }
}
