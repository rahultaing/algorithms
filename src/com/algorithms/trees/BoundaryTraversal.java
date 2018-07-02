package com.algorithms.trees;

/*
* https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
*
* We break the problem in 3 parts:
1. Print the left boundary in top-down manner.
2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
…..2.1 Print all leaf nodes of left sub-tree from left to right.
…..2.2 Print all leaf nodes of right subtree from left to right.
3. Print the right boundary in bottom-up manner.

We need to take care of one thing that nodes are not printed again. e.g.
The left most node is also the leaf node of the tree.

Based on the above cases, below is the implementation:
*/
public class BoundaryTraversal {

    public void traverseBoundary(TreeNode node){

        if (node != null){
            System.out.print(node.val);

            this.traverseLeft(node.left);

            this.printLeaves(node.left);

            this.printLeaves(node.right);

            this.traverseRight(node.left);
        }
    }

    private void traverseLeft(TreeNode node){

        if (node != null){

            if (node.left != null){
                System.out.print(node.val);
                this.traverseLeft(node.left);
            }
            else if (node.right != null){
                System.out.print(node.val);
                this.traverseRight(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    private void printLeaves(TreeNode node){

        if (node != null){

            this.printLeaves(node.left);

            if (node.left == null && node.right == null){
                System.out.print(node.val);
            }

            this.printLeaves(node.right);
        }
    }

    private void traverseRight(TreeNode node){

        if (node != null){

            if (node.right != null){
                this.traverseRight(node.right);
                System.out.print(node.val);
            }
            else if (node.left != null){
                this.traverseRight(node.left);
                System.out.print(node.val);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }
}
