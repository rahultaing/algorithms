/*https://www.youtube.com/watch?v=NBcqBddFbZw */

package com.algorithms.trees;

public class LowestCommonAncestor {

    public int lca(TreeNode node, int p, int q){

        if (node == null){
            return 0;
        }

        return this.recurse(node, p, q).val;
    }

    private TreeNode recurse(TreeNode node, int p, int q){

        if (node == null || node.val == p || node.val == q){
            return node;
        }

        TreeNode left = this.recurse(node.left, p, q);
        TreeNode right = this.recurse(node.right, p, q);

        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }

        return node;
    }
}
