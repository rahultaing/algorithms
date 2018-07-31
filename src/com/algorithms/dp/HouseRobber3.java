package com.algorithms.dp;

import com.algorithms.trees.TreeNode;

/*
*
* https://leetcode.com/submissions/detail/118779841/
*
* The thief has found himself a new place for his thievery again.
* There is only one entrance to this area, called the "root."
* Besides the root, each house has one and only one parent house.
* After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:
     3
    / \
   2   3
    \   \
     3   1
Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
Example 2:
     3
    / \
   4   5
  / \   \
 1   3   1
Maximum amount of money the thief can rob = 4 + 5 = 9.

*/
public class HouseRobber3 {

    public int rob(TreeNode root) {

        int[] result = this.recurse(root);
        return Math.max(result[0], result[1]);
    }

    private int[] recurse(TreeNode node){

        if (node == null){
            return new int[]{0, 0};
        }

        int[] l = this.recurse(node.left);
        int[] r = this.recurse(node.right);

        int incl = node.val + l[0] + r[0];
        int notIncl = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[] {incl, notIncl};
    }
}
