package com.algorithms.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/*

https://www.geeksforgeeks.org/diagonal-traversal-of-binary-tree/

Consider lines of slope -1 passing between nodes.
Given a Binary Tree, print all diagonal elements in a binary tree belonging to same line.

*/
public class DiagonalTraversal {

    private HashMap<Integer, List<Integer>> map = new HashMap<>();

    public Collection<List<Integer>> traverse(TreeNode node){

        this.recurse(node, 0);
        return this.map.values();
    }

    private void recurse(TreeNode node, Integer d){
        if (node == null){
            return;
        }

        if (this.map.containsKey(d)){
            List<Integer> list = this.map.get(d);
            list.add(node.val);

            /*TEST: if we really need to put the object back into the map or because the list is
            * a reference it would update the object in the map as well.*/

            this.map.put(d, list);

        }else{
            List<Integer> list = new ArrayList<>();
            list.add(node.val);
            this.map.put(d, list);
        }

        this.recurse(node.right, d);
        this.recurse(node.left, d+1);
    }
}
