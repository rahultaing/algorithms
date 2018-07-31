package com.algorithms.trees;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        if (root == null){
            return true;
        }

        return this.isBalanced(root.right)
                && this.isBalanced(root.left)
                && Math.abs(this.depth(root.left) - this.depth(root.right)) <= 1;
    }

    private int depth(TreeNode node){
        if (node == null){
            return 0;
        }

        return Math.max(this.depth(node.left), this.depth(node.right)) + 1;
    }

    /*TODO implement another way where the method returns -1 if not balanced or the depth of the node.*/
}
