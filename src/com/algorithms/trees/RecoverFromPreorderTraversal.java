/*

https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/discuss/274621/JavaC%2B%2BPython-Iterative-Stack-Solution

We run a preorder depth first search on the root of a binary tree.

At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  (If the depth of a node is D, the depth of its immediate child is D+1.  The depth of the root node is 0.)

If a node has only one child, that child is guaranteed to be the left child.

Given the output S of this traversal, recover the tree and return its root.

 
Input: "1-2--3--4-5--6--7"
Output: [1,2,5,3,4,6,7]

*/

class Solution {
    public TreeNode recoverFromPreorder(String S) {
       
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            
            int level = 0;
            while (S.charAt(i) == '-') {
                level++;
                i++;
            }
            
            int val = 0;
            while (i < S.length() && S.charAt(i) != '-') {
                val = val * 10 + (S.charAt(i) - '0');
                i++;
            }
            
            while (stack.size() > level) {
                stack.pop();
            }
            
            TreeNode node = new TreeNode(val);
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.add(node);
        }
        
        while (stack.size() > 1) {
            stack.pop();
        }
        
        return stack.pop(); 
    }
}