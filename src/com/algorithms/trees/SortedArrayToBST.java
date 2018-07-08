package com.algorithms.trees;

/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in
which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        int n = nums.length;

        if (n == 0){
            return null;
        }

        return this.createBST(nums, 0, n-1);
    }

    private TreeNode createBST(int[] nums, int l, int r){

        if (l <= r) {
            int mid = l + (r - l) / 2;

            TreeNode node = new TreeNode(nums[mid]);
            node.left = this.createBST(nums, l, mid - 1);
            node.right = this.createBST(nums, mid + 1, r);
            return node;
        }

        return null;
    }
}
