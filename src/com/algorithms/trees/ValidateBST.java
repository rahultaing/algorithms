/*
https://leetcode.com/problems/validate-binary-search-tree/ 
*/

package com.algorithms.trees;

public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return this.recurse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean recurse(TreeNode node, long min, long max){

        if (node == null){
            return true;
        }

        if (node.val < min || node.val > max){
            return false;
        }

        if (!this.recurse(node.left, min, node.val-1)){
            return false;
        }

        return this.recurse(node.right, node.val+1, max);
    }
}
