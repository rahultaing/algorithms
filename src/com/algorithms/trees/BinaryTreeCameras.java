import java.util.HashSet;

/*Given a binary tree, we install cameras on the nodes of the tree. 

Each camera at a node can monitor its parent, itself, and its immediate children.

Calculate the minimum number of cameras needed to monitor all nodes of the tree.


https://leetcode.com/problems/binary-tree-cameras/solution/
*/

class Solution {
    public int minCameraCover(TreeNode root) {
        int[] ans = solve(root);
        return Math.min(ans[1], ans[2]);
    }

    // 0: Strict ST; All nodes below this are covered, but not this one
    // 1: Normal ST; All nodes below and incl this are covered - no camera
    // 2: Placed camera; All nodes below this are covered, plus camera here
    public int[] solve(TreeNode node) {
        if (node == null)
            return new int[]{0, 0, 99999};

        int[] L = solve(node.left);
        int[] R = solve(node.right);
        int mL12 = Math.min(L[1], L[2]);
        int mR12 = Math.min(R[1], R[2]);

        int d0 = L[1] + R[1];
        int d1 = Math.min(L[2] + mR12, R[2] + mL12);
        int d2 = 1 + Math.min(L[0], mL12) + Math.min(R[0], mR12);
        return new int[]{d0, d1, d2};
    }
}

public class solution2{

    HashSet<TreeNode> set = new HashSet<>();
    int ans = 0;

    /*greedy solution is much better*/
    public int minCameraCover(TreeNode root) {

        recurse(root, null);
        return ans;
    }

    private void recurse(TreeNode x, TreeNode par){

        if (x==null){
            return;
        }
        recurse(x.left, x);
        recurse(x.right, x);
        if ((par==null && !set.contains(x)) || (!set.contains(x.left) || !set.contains(x.right))){
            ans++;
            set.add(par);
            set.add(x);
            set.add(x.left);
            set.add(x.right);
        }
    }
}