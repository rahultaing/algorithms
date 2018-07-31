package com.algorithms.trees;

/*
* https://leetcode.com/problems/maximum-width-of-binary-tree/description/
*
* Given a binary tree, write a function to get the maximum width of the given tree.
* The width of a tree is the maximum width among all levels. The binary tree has the same
* structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost
and right most non-null nodes in the level, where the null nodes between the end-nodes are
also counted into the length calculation.

Example 1:
Input:

           1
         /   \
        3     2
       / \     \
      5   3     9

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input:

          1
         /
        3
       / \
      5   3

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input:

          1
         / \
        3   2
       /
      5

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input:

          1
         / \
        3   2
       /     \
      5       9
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
*/

import java.util.HashMap;

public class MaxWidthOfBinaryTree {

    private HashMap<Integer, Integer> map = new HashMap<>();
    private int max = 0;
    public int widthOfBinaryTree(TreeNode root) {

        if (root == null){
            return 0;
        }

        this.recurse(root, 1, 0);

        return this.max;
    }

    private void recurse(TreeNode node, int index, int depth){

        if (node == null){
            return;
        }

        if (this.map.containsKey(depth)){
            this.max = Math.max(this.max, index - this.map.get(depth));
        }else{
            this.map.put(depth, index);
        }

        this.recurse(node.left, index*2, depth + 1);
        this.recurse(node.right, index*2 + 1, depth + 1);
    }
}
