//https://leetcode.com/submissions/detail/117846225/

/*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
  */
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
        && this.isSym(p.right, q.left);
    }
}