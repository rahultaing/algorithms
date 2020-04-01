/*https://leetcode.com/problems/print-binary-tree/

Print a binary tree in an m*n 2D string array following these rules:

The row number m should be equal to the height of the given binary tree.
The column number n should always be an odd number.
The root node's value (in string format) should be put in the exactly middle of the first row it can be put.
The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part).
You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part.
The left-bottom part and the right-bottom part should have the same size.
Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree.
However, if two subtrees are none, then you don't need to leave space for both of them.
Each unused space should contain an empty string "".
Print the subtrees following the same rules.

 */
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
