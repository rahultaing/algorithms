//https://leetcode.com/submissions/detail/117846225/
public class SymmetricTree{

    public boolean isSymmetric(TreeNode node){

        if (node==null){
            return true;
        }

        return this.isSym(node.left, node.right);
    }

    public boolean isSym(TreeNode p, TreeNode q){

        if (p == null && q==null){
            return true;
        }

        if (p==null || q==null){
            return false;
        }

        return p.val==q.val
        && this.isSym(p.left, q.right)
        && this.isSym(p.right, q.right);
    }
}