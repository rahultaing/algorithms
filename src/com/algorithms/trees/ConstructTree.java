package com.algorithms.trees;

/*given preorder and inorder traversal construct a binary tree.*/
public class ConstructTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return this.build(0, 0, inorder.length-1, preorder, inorder);
    }

    private TreeNode build(Integer preStart, Integer inStart, Integer inEnd, int[] preorder, int[] inorder){

        if (preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }

        Integer inIndex = -1;
        for (Integer i=inStart; i<=inEnd; i++){
            if (preorder[preStart] == inorder[i]){
                inIndex = i;
            }
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = this.build(preStart + 1, inStart, inIndex-1, preorder, inorder);
        root.right = this.build(preStart + inIndex - inStart + 1,
                inIndex+1, inEnd, preorder, inorder);
        return root;
    }
}
