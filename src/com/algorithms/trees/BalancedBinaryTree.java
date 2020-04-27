package com.algorithms.trees;
// https://leetcode.com/submissions/detail/119476716/

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
}

/*another way where the method returns -1 if not balanced or the depth of the node.*/
public class BalancedBinaryTree2{

    public boolean isBalanced(TreeNode root)
    {
        return check(root) == -1 ? false : true;
    }

    private int check(TreeNode node)
    {
        if (node == null)
            return 0;

        int left = check(node.left);
        if (left == -1)
            return -1;

        int right = check(node.right);
        if (right == -1)
            return -1;

        return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
    }
}
