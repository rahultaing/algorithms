package com.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/*
https://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/

*/

/*Time complexity - O(n) n=number of nodes in the tree
* Space complexity - O(n) n = number of nodes in the tree. */
public class FindNextRightNode {

    public int findNode(TreeNode node, int key){

        if (node == null){
            return -1;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(node);

        while (!queue.isEmpty()){

            int count = queue.size();

            for (int i=0; i<count; i++){

                TreeNode n = queue.poll();

                if (n.val == key && i!=count-1){
                    return queue.peek().val;
                }

                if (n.left != null){
                    queue.add(n.left);
                }

                if (n.right != null){
                    queue.add(n.right);
                }
            }
        }

        return -1;
    }
}
