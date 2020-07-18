package com.algorithms.trees;
/*https://leetcode.com/problems/inorder-successor-in-bst/solution/
 */
public class InorderSuccessorBST {
    
    public TreeNode findInorderSuccessor(TreeNode root, TreeNode p){

        
        // p is the node whose successor we have to find

        TreeNode cur = root;
        TreeNode candidate = null;

        while (cur!=null){

            if (cur.val>p.val){
                candidate = cur;
                cur = cur.left;
            }
            else{

                cur  = cur.right;
            }
        }

        return candidate;
    }
}