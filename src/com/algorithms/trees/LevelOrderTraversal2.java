// https://leetcode.com/submissions/detail/118011428/

import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal2{

    private List<List<Integer>> outlist = new ArrayList<>();
    private Stack<List<Integer>> stack = new Stack<>();
    private Queue<TreeNode> q = new LinkedList<>();
    
    public List<List<Integer>> compute(TreeNode node){

        if (node == null){
            return new ArrayList<>();
        }

        q.add(node);

        while (q.size() > 0){
            int count = q.size();

            List<Integer> list = new ArrayList<>();
            for (int i=0; i<count; i++){
                
                TreeNode x = q.remove();
                list.add(x.val);

                if (x.left != null){
                    q.add(x.left);
                }

                if (x.right != null){
                    q.add(x.right);
                }
            }

            this.stack.push(list);
        }

        while (!this.stack.isEmpty()){
            this.outlist.add(this.stack.pop());
        }

        return this.outlist;
    }
}