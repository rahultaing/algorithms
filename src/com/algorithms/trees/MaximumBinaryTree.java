package com.algorithms.trees;

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        return this.construct(nums, 0, nums.length);
    }

    private TreeNode construct(int[] nums, Integer l, Integer r){

        if (l == r){
            return null;
        }

        Integer index = this.findMax(nums, l, r);
        TreeNode node = new TreeNode(nums[index]);
        node.left = this.construct(nums, l, index);
        node.right = this.construct(nums, index + 1, r);
        return node;
    }

    private Integer findMax(int[] nums, Integer l, Integer r){

        Integer max = Integer.MIN_VALUE;
        Integer index = -1;
        for (Integer i=l; i<r; i++){

            if (max < nums[i]){
                max = nums[i];
                index = i;
            }
        }

        return index;
    }
}
