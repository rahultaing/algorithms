// https://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/

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