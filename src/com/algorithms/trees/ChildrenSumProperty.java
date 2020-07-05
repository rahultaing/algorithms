// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/

/*Given a binary tree, write a function that returns true if the tree satisfies below property.
For every node, data value must be equal to sum of data values in left and right children. Consider data value as 0 for NULL children. Below tree is an example

 */

public class Solution{

    public boolean childrenSumProperty(TreeNode node){

        if (node == null){
            return true;
        }

        int leftVal = node.left == null ? 0: node.left.val;
        int rightVal = node.right == null? 0 : node.right.val;

        return node.val == leftVal + rightVal && 
                this.childrenSumProperty(node.left) &&
                this.childrenSumProperty(node.right);
    }
}