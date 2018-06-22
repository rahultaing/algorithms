package com.algorithms.trees;

import java.util.Stack;

public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {

        while (root != null){
            this.stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return this.stack.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode node = this.stack.pop();

        TreeNode x = node.right;
        while (x != null){

            this.stack.push(x);
            x = x.left;
        }

        return node.val;
    }
}
