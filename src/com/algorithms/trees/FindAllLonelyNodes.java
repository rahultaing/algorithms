/*In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.

Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.

https://leetcode.com/problems/find-all-the-lonely-nodes/
*/

class Solution {
    
    private List<Integer> nodes= new ArrayList<>();
    
    public List<Integer> getLonelyNodes(TreeNode root) {
        
        getLonelyNodes(root, false); // root is not lonely
        return nodes;
    }
    
    

    private void getLonelyNodes(TreeNode root, boolean isLonely) {
        if (root == null) return;
        
        if (isLonely) {
            nodes.add(root.val);
        }
        
        getLonelyNodes(root.left, root.right == null);
        getLonelyNodes(root.right, root.left == null);
    }
}