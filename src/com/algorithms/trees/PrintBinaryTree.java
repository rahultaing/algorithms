package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/*write tests*/
public class PrintBinaryTree {

    public List<List<String>> print(TreeNode node){

            if (node == null){
                return new ArrayList<>();
            }

            Integer rows = this.height(node);
            Integer cols = (int) Math.pow(2, rows) - 1;

            List<String> row = new ArrayList<>();
            for (Integer i=0; i<cols; i++){
                row.add("");
            }

            List<List<String>> list = new ArrayList<>();
            for (Integer i=0; i<rows; i++){
                list.add(row);
            }

            this.populate(list, 0, rows, node, 0, cols-1);
            return list;
    }

    private void populate(List<List<String>> list,
                          Integer row,
                          Integer totalRows,
                          TreeNode node,
                          Integer colStart,
                          Integer colEnd){

        if (row >= totalRows || node == null){
            return;
        }

        list.get(row).set((colStart+colEnd)/2 , node.val.toString());

        this.populate(list, row+1, totalRows, node.left, colStart, (colStart+colEnd)/2 - 1);
        this.populate(list, row+1, totalRows, node.right, (colStart+colEnd)/2 + 1, colEnd);
    }

    /*TODO: complete this method and externalize it*/
    private Integer height(TreeNode node){
        return 0;
    }
}
