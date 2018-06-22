package com.algorithms.trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class DiagonalTraversal {

    private HashMap<Integer, List<Integer>> map = new HashMap<>();

    public Collection<List<Integer>> traverse(TreeNode node){

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
