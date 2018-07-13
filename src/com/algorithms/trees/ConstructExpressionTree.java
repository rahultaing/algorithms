package com.algorithms.trees;

import java.util.Stack;

/*
* https://www.geeksforgeeks.org/expression-tree/
*
* Expression tree is a binary tree in which each internal node corresponds to
* operator and each leaf node corresponds to operand so for example expression tree for 3 + ((5+9)*2) would be:*/
public class ConstructExpressionTree {

    /*we are constructing a binary expression tree from a postfix string*/
    public TreeNode constructTree(String postfix){
        Stack<TreeNode> stack = new Stack<>();

        int n = postfix.length();

        for (int i=0; i<n; i++){

            if (!this.isOperator(postfix.charAt(i))){
                TreeNode node = new TreeNode(postfix.charAt(i));
                stack.push(node);
            }
            else{
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();

                TreeNode node = new TreeNode(postfix.charAt(i));
                node.left=left;
                node.right=right;

                stack.push(node);
            }
        }

        return stack.pop();
    }

    private boolean isOperator(char ch){
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}
