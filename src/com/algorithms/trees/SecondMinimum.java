//https://leetcode.com/articles/second-minimum-node-in-a-binary-tree/

public class SecondMinimum{

    private int min;
    private long ans = Long.MAX_VALUE;

    public int compute(TreeNode node){
        min = node.val;
        dfs(node);
        return ans != Long.MAX_VALUE ? (int) ans : -1;
    }

    public void dfs(TreeNode node){

        if (node!=null){

            if (ans > node.val && min<node.val){
                ans = node.val;
            }
            else if (min == node.val){
                dfs(node.left);
                dfs(node.right);
            }
        }
    }
}