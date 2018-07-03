package com.algorithms.trees;

/*

https://www.geeksforgeeks.org/check-if-two-trees-are-mirror/

Three solutions:
1. recursive.
2. iterative.
3. level order traversal.

*/
public class MirrorTrees {

    public boolean recursiveAreMirror(TreeNode node1, TreeNode node2){

        if (node1 == null && node2 == null){
            return true;
        }

        if (node1 == null || node2 == null){
            return false;
        }

        return node1.val == node2.val &&
                this.recursiveAreMirror(node1.left, node2.right) &&
                this.recursiveAreMirror(node1.right, node2.left);
    }

    public boolean iterativeAreMirror(TreeNode node1, TreeNode node2){
        return true;
    }

    public boolean levelOrderAreMirror(TreeNode node1, TreeNode node2){

        return true;
    }
}
