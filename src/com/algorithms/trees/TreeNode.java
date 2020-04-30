package com.algorithms.trees;

public class TreeNode {
    public TreeNode left;
    public Integer val;
    public TreeNode right;
    public int verticalDistance;
    public Character ch;
    public Integer height;
    
    public TreeNode(Integer val){
        this.val = val;
    }

    // hack for constructing expression tree
    public TreeNode(Character ch){this.ch = ch;}
}
