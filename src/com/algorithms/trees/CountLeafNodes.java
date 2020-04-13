// https://www.geeksforgeeks.org/write-a-c-program-to-get-count-of-leaf-nodes-in-a-binary-tree/

public class Solution{

    public int getLeafCount(TreeNode node){

        if (node == null){
            return 0;
        }

        if (node.left == null && node.right == null){
            return 1;
        }
        else {
            return this.getLeafCount(node.left) + this.getLeafCount(node.right);
        }
    }
}