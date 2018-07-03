package com.algorithms.trees;

public class ConvertTreeToMirror {

    public TreeNode convertToMirror(TreeNode node){

        if (node == null){
            return null;
        }

        TreeNode left = this.convertToMirror(node.left);
        TreeNode right = this.convertToMirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }
}
