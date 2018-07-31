package com.algorithms.trees;

/*
* https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
* Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Example 1:

Input: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
Output: 1
Example 2:

Input: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
Output: 3
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
How would you optimize the kthSmallest routine?

* */
public class KthSmallest {
    public int kthSmallest(TreeNode root, int k) {

        if (root == null){
            return -1;
        }

        int cnt = this.count(root.left);
        if (cnt == k-1){
            return root.val;
        }else if (cnt > k-1){
            return this.kthSmallest(root.left, k);
        }else{
            return this.kthSmallest(root.right, k-cnt-1);
        }
    }

    private int count(TreeNode node){
        if (node == null){
            return 0;
        }

        return this.count(node.left) + this.count(node.right) + 1;
    }
}
