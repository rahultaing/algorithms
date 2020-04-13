//https://leetcode.com/problems/subtree-of-another-tree/solution/

public class Solution{

    public boolean isSubTree(TreeNode s, TreeNode t){

        return this.traverse(s, t);
    }

    public boolean equals(TreeNode s, TreeNode t){

        if (s==null && t==null){
            return true;
        }

        if (s==null || t==null){
            return false;
        }

        return (s.val==t.val) && this.equals(s.left, t.left) && this.equals(s.right, t.right);
    }

    public boolean traverse(TreeNode s, TreeNode t){

        return s!=null && (this.equals(s,t) || this.traverse(s.left, t) ||
        this.traverse(s.right, t));
    }
}