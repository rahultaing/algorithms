package com.algorithms.trees;

import java.util.ArrayList;
import java.util.List;

/*iterative traversal like morris traversal*/

public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null){
            return list;
        }

        TreeNode cur = root;

        while (cur != null){
            if (cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }
            else{

                TreeNode prev = cur.left;

                while (prev.right != null){
                    prev = prev.right;
                }

                prev.right = cur;

                TreeNode temp = cur;
                cur = cur.left;
                temp.left = null;
            }
        }

        return list;
    }
}
