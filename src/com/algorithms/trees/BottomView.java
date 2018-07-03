package com.algorithms.trees;

import java.util.*;

/*
https://www.geeksforgeeks.org/bottom-view-binary-tree/

Given a Binary Tree, we need to print the bottom view from left to right.
A node x is there in output if x is the bottommost node at its horizontal distance.
Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
and that of right child is horizontal distance of x plus 1.

Examples:

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root,
then print the later one in level traversal. For example, in the below diagram,
3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.


                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \
                  10    14
For the above tree the output should be 5, 10, 4, 14, 25.
*/

public class BottomView {

    public List<Integer> bottomView(TreeNode node){

        Queue<TreeNode> queue = new LinkedList<>();

        if (node == null){
            return new ArrayList<>();
        }

        node.verticalDistance = 0;
        queue.add(node);

        TreeMap<Integer, Integer> map = new TreeMap<>();

        while(!queue.isEmpty()){

            TreeNode n = queue.poll();
            map.put(n.verticalDistance,  n.val);

            if (n.left != null){
                n.left.verticalDistance = n.verticalDistance - 1;
                queue.add(n.left);
            }

            if (n.right != null){
                n.right.verticalDistance = n.verticalDistance + 1;
                queue.add(n.right);
            }
        }

        return new ArrayList<>(map.values());
    }
}
