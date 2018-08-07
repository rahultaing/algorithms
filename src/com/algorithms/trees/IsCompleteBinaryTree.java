package com.algorithms.trees;

/*https://www.geeksforgeeks.org/check-whether-binary-tree-complete-not-set-2-recursive-solution/
*
* This is an O(n) solution. I think it would be good to find a O(logN) solution to this problem
* */
public class IsCompleteBinaryTree {

    private int nodeCount;

    public boolean isComplete(TreeNode node){

        if (node == null){
            return true;
        }

        this.nodeCount = this.countNodes(node);

        return this.isComplete(node, 0);
    }

    private boolean isComplete(TreeNode node, int index){

        if (node == null){
            return true;
        }

        if (index >= this.nodeCount){
            return false;
        }

        return this.isComplete(node.left, 2*index + 1) &&
                this.isComplete(node.right, 2*index + 2);
    }

    private int countNodes(TreeNode node){

        if (node == null){
            return 0;
        }

        return this.countNodes(node.left) + this.countNodes(node.right) + 1;
    }
}
