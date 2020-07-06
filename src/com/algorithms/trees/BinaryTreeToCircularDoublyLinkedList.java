package com.algorithms.trees;
/*https://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/

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
