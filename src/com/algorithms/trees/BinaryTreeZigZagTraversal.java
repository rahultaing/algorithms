import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
public class Solution{

    public List<List<Integer>> compute(TreeNode node){
        
        List<List<Integer>> outList = new ArrayList<>();

        if (node == null){
            return this.outList;
        }

        Stack<Integer> stack = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(node);
        boolean isRev = false;

        while (!q.isEmpty()){

            List<Integer> list = new ArrayList<>();

            int count = q.size();

            for (int i =0; i<count; i++){

                TreeNode x = q.poll();

                if (!isRev){
                    list.add(x.val);
                }
                else{
                    stack.push(x.val);
                }

                if (x.left != null){
                    q.add(x.left);
                }

                if (x.right!=null){
                    q.add(x.right);
                }
            }

            if (isRev){
                while (!stack.isEmpty()){
                    list.add(stack.poll());
                }
            }

            isRev = !isRev;

            this.outList.add(list);
        }
        return this.outList;
    }
}