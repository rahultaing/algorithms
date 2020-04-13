import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

https://leetcode.com/problems/average-of-levels-in-binary-tree/description/

public class Solution{

    public List<Double> averageOfLevels(TreeNode root) {
        
        if (root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<Double> list = new ArrayList<>();

        while (!q.isEmpty()){

            int count = q.size();
            int total = 0;

            for (int i=0; i<count; i++){
                TreeNode x = q.poll();

                if (x.left != null){
                    q.add(x.left);
                }

                if (x.right != null){
                    q.add(x.right);
                }

                total += x.val;
            }

            list.add(total/count);
        }

        return list;
    }
}