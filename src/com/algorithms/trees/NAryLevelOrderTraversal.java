package com.algorithms.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
*
* */
public class NAryLevelOrderTraversal {

    public List<List<Integer>> levelOrder(NAryTreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }

        Queue<NAryTreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()){

            int count = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < count; i++){

                NAryTreeNode cur = queue.poll();
                list.add(cur.val);

                for (NAryTreeNode child: cur.children){
                    queue.add(child);
                }
            }

            result.add(list);
        }

        return result;
    }
}
