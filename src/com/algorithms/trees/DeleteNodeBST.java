package com.algorithms.trees;

/*Delete a node in a BST*/
public class DeleteNodeBST {

    public TreeNode delete(TreeNode node, Integer key){

        if (node == null){
            return null;
        }

        if (node.val < key){
            node.right = this.delete(node.right, key);
        }
        else if (node.val > key){
            node.left = this.delete(node.left, key);
        }
        else{

            if (node.left == null){
                return node.right;
            }

            if (node.right == null){
                return node.left;
            }

            TreeNode t = node;
            node = this.min(t.right);
            node.left = t.left;
            node.right = this.deleteMin(t.right);
        }

        return node;
    }

    private TreeNode deleteMin(TreeNode node){

        if (node.left == null){
            return node.right;
        }

        node.left = this.deleteMin(node.left);
        return node;
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
