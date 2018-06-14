package com.algorithms.trees;

public class FloorCeiling {

    /*TODO: implement this*/
    public Integer floor(TreeNode node, Integer val){

        return 0;
    }


    public Integer ceiling(TreeNode node, Integer val){

        if (node == null){
            return null;
        }

        if (node.val.equals(val)){
            return node.val;
        }

        if (node.val < val){
            return this.ceiling(node.right, val);
        }

        // node.val > val
        Integer leftCeil = this.ceiling(node.left, val);
        if (leftCeil == null || leftCeil < val){
            return node.val;
        }
        else{
            return leftCeil;
        }
    }
}
