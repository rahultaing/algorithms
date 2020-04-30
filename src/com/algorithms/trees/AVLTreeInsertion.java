package com.algorithms.trees;

// https://www.geeksforgeeks.org/avl-tree-set-1-insertion/
// mission-peace interview avl tree - put the link here
public class AVLTreeInsertion {

    private int balance(TreeNode node){
        if (node == null){
            return 0;
        }

        return node.left.height - node.right.height;
    }

    private int height(TreeNode node){
        if (node == null){
            return 0;
        }

        return node.height;
    }

    private TreeNode rightRotate(TreeNode y){

        TreeNode x = y.left;
        TreeNode t2 = x.right;

        x.right = y;
        y.left = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return x;
    }

    private TreeNode leftRotate(TreeNode x){

        TreeNode y = x.right;
        TreeNode t1 = y.left;

        x.right = t1;
        y.left = x;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    public TreeNode insert(TreeNode node, int key){

        if (node == null){
            return new TreeNode(key);
        }

        if (node.val > key){
            node.left = insert(node.left, key);
        }
        else if (node.val < key){
            node.right = insert(node.right, key);
        }
        else{
            // duplicate key
            return node;
        }

        int bal = balance(node);

        
        if (bal>1){

            // right rotate
            if (height(node.left.left) >= height(node.left.right)){
                node = rightRotate(node);
            }
            else {

                // left rotate
                node.left = leftRotate(node.left);

                // and then right rotate
                node = rightRotate(node);
            }
        } 
        

        if (bal < -1){

            if (height(node.right.right) >= height(node.right.left)){
                node = leftRotate(node);
            }
            else{
                // right rotate
                node.right = rightRotate(node.right);

                // and then left rotate
                node = leftRotate(node);
            }
        }

        return node;
    }
}