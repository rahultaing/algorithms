package com.algorithms.trees;

/*Delete a node in a BST*/
public class DeleteNodeBST {

    public void delete(TreeNode node, Integer val){

    }

    private void deleteMin(){

    }

    private TreeNode min(TreeNode node){
        if (node == null){
            return null;
        }

        if (node.left==null){
            return node;
        }

        return this.min(node.left);
    }
}
