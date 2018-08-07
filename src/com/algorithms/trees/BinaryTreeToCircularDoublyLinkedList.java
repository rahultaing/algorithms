package com.algorithms.trees;

/*
* https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/
*
* Convert a Binary Tree to a Circular Doubly Link List
Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place).

The left and right pointers in nodes are to be used as previous and next pointers
respectively in converted Circular Linked List.
The order of nodes in List must be same as Inorder of the given Binary Tree.
The first node of Inorder traversal must be head node of the Circular List.
*/

public class BinaryTreeToCircularDoublyLinkedList {

    public TreeNode bTreeToCList(TreeNode root)
    {
        if (root == null){
            return null;
        }

        TreeNode left = this.bTreeToCList(root.left);
        TreeNode right = this.bTreeToCList(root.right);

        root.left = root;
        root.right = root;

        return this.concat(this.concat(left, root), right);
    }

    private TreeNode concat(TreeNode leftList, TreeNode rightList){

        if (leftList == null){
            return rightList;
        }

        if (rightList == null){
            return leftList;
        }

        TreeNode leftLast = leftList.left;
        TreeNode rightLast = rightList.left;

        leftLast.right = rightList;
        rightList.left = leftLast;

        leftList.left = rightLast;
        rightLast.right = leftList;

        return leftList;
    }
}
